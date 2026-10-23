#!/usr/bin/env bash
set -euo pipefail

exec python3 - "$@" <<'PY'
import argparse
import re
import sys
from pathlib import Path


INCLUDE_RE = re.compile(
    r'^\s*#\s*include\s*"([^"\n]+)"(?:\s*(?://.*|/\*.*\*/))?\s*$'
)
PRAGMA_ONCE_RE = re.compile(
    r'^\s*#\s*pragma\s+once\s*(?://.*|/\*.*\*/)?\s*$'
)


def main() -> int:
    parser = argparse.ArgumentParser(
        description="Recursively expand quoted #include directives."
    )
    parser.add_argument("input", type=Path, help="input source file")
    parser.add_argument(
        "output",
        type=Path,
        nargs="?",
        help="output file (default: <input-name>.expanded<input-suffix>)",
    )
    parser.add_argument(
        "-I",
        dest="include_dirs",
        action="append",
        type=Path,
        default=[],
        metavar="DIR",
        help="additional directory to search for quoted includes",
    )
    args = parser.parse_args()

    source = args.input.resolve()
    if not source.is_file():
        parser.error(f"input file does not exist: {source}")

    output = args.output
    if output is None:
        output = source.with_name(f"{source.stem}.expanded{source.suffix}")
    output = output.resolve()
    if output == source:
        parser.error("output file must be different from the input file")

    include_dirs = [directory.resolve() for directory in args.include_dirs]
    active: list[Path] = []
    once_included: set[Path] = set()

    def expand(path: Path) -> str:
        path = path.resolve()
        if path in once_included:
            return ""
        if path in active:
            return ""

        active.append(path)
        try:
            text = path.read_text(encoding="utf-8")
            expanded_lines: list[str] = []
            for line_number, line in enumerate(text.splitlines(keepends=True), 1):
                content = line.rstrip("\r\n")
                if PRAGMA_ONCE_RE.match(content):
                    once_included.add(path)
                    continue

                match = INCLUDE_RE.match(content)
                if match is None:
                    expanded_lines.append(line)
                    continue

                requested = Path(match.group(1))
                candidates = [path.parent / requested]
                candidates.extend(directory / requested for directory in include_dirs)
                included = next((candidate.resolve() for candidate in candidates
                                 if candidate.is_file()), None)
                if included is None:
                    searched = ", ".join(str(candidate) for candidate in candidates)
                    raise FileNotFoundError(
                        f"{path}:{line_number}: quoted include not found: "
                        f'{match.group(1)} (searched: {searched})'
                    )
                expanded_lines.append(expand(included))
            return "".join(expanded_lines)
        finally:
            active.pop()

    try:
        result = expand(source)
        output.parent.mkdir(parents=True, exist_ok=True)
        output.write_text(result, encoding="utf-8")
    except (OSError, UnicodeError, FileNotFoundError) as error:
        print(f"expand_includes.sh: {error}", file=sys.stderr)
        return 1

    print(output)
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
PY
