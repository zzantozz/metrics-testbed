#!/bin/bash -e

# Runs grafana with opentsdb. The app is configured to send metrics to it. Just start this and the app and go to
# http://localhost:3020

top_dir="$(dirname "$(dirname "$(realpath "$0")")")"

docker-compose -f "$top_dir/metric-stacks/opentsdb_grafana/stack.yml" up
