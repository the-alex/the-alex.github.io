#!/usr/bin/env bash
set -euo pipefail

git push origin `git subtree split --prefix dist master`:gh-pages --force
