#!/usr/bin/env bash
set -euo pipefail

./build.sh
git add dist
git commit -m "build: add static files from build"
git push origin `git subtree split --prefix master`:gh-pages --force
