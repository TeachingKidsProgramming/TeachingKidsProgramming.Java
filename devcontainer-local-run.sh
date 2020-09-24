#!/usr/bin/env bash
set -euo pipefail

# Syntax: ./devcontainer-local-run.sh [interactive flag]
#
# Usage:
#
# 1. Interactive/debug mode:
# 
# ./devcontainer-local-run.sh true
#
# This mode attaches to the container's terminal and runs bash so you can 
# inspect the container or run toubleshooting commands.  Desktop still runs as
# normal over VNC.
#
# 2. Background mode (default)
#
# ./devcontainer-local-run.sh false 
# 
# OR
#
# ./devcontainer-local-run.sh
#
# This mode runs the container without attaching to a bash session.  Desktop
# runs over VNC.

INTERACTIVE=${1:-"false"}
DOCKER_RUN_MODE="--detach"
CMD=""
if [ "${INTERACTIVE}" == "true" ]; then 
    DOCKER_RUN_MODE="--interactive --tty"
    CMD="/bin/bash"
fi

VARIANT=11

# Some times vendors patch their images and re-release them under the same tag.
# Pulling the image first ensures the cache is fresh with the most recent security updates.
docker pull mcr.microsoft.com/vscode/devcontainers/java:${VARIANT}

# Build the devcontainer for TKP
docker build \
    --build-arg VARIANT=${VARIANT} \
    --file ./.devcontainer/DOCKERFILE \
    --tag devcontainer-tkp \
    ./.devcontainer

# Run the TKP devcontainer
docker run \
    ${DOCKER_RUN_MODE} \
    --rm \
    --publish 6080:6080 \
    --init \
    --security-opt seccomp=unconfined \
    devcontainer-tkp \
    ${CMD}

