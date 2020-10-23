#!/usr/bin/env bash
set -euo pipefail

statik compile -d . src/site.clj

git add -u && git commit --amend --no-edit && git push --force
