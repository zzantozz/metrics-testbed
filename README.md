# Metrics Testbed

This project is for me to play around with some metrics tools like
OpenTSDB, Graphite, Grafana, etc. It's a simple little app that emits
some different kinds of metrics that can be visualized so that I can
compare how the different metrics tools work.

The app is just a silly little demo that models cars driving on a road
while cows cross it.  If a car and a cow ever intersect, it's a
hit. When a car or a cow completes its traversal, it escapes.  Both
cars and cows are colored. Metrics are emitted for hits and escapes
and tagged with what "kind" and "color" of thing did it.

# Adding tools

To add another tool stack that runs locally, add a
bin/start-&lt;stack>-stack.sh script and a metric-stacks/&lt;stack
name>/stack.yml which is the docker-compose file for running it.  Any
supporting files for the new stack should go into that directory
alongside stack.yml.

Listening ports are different from the defaults because they would
collide with each other or with other instances of these services that
I might be running.  In general, to add a new service, add 1 to the
tens position of the port. For instance, the first two Grafana
services are on ports 3010 and 3020 instead of the default of 3000.

# Using it

Use `./gradlew run` to start the app. It logs each event that creates
a metric. See the `bin` directory for scripts to start some local
metrics tools, or set up an appropriate SaaS metrics tool, which you
can add by adding an appropriate dependency and configuring it in
`application.properties`.