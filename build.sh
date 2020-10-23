#!/usr/bin/env bash
set -euo pipefail

statik compile -d . src/site.clj

git add -u && git commit -m "deps: statik build artifacts" && git push --force
