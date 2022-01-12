#!/bin/bash -e

# Runs grafana with graphite. The app is configured to send metrics to it. Just start this and the app and go to
# http://localhost:3010

top_dir="$(dirname "$(dirname "$(realpath "$0")")")"

docker-compose -f "$top_dir/metric-stacks/graphite_grafana/stack.yml" up
