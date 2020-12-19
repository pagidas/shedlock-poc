#!/bin/bash

echo "Building gradle project..."
./gradlew clean build shadowJar

echo "Building docker stack..."
docker-compose up -d --build --scale shedlock-poc=2
echo "The shedlock service is scaled to 2 instances to contemplate testing."

echo "Sleeping for 8 seconds for the services to connect to elasticsearch..."
sleep 8

echo "Following shedlock containers docker-compose logs..."
echo "Hopefully, now you can see only one service acts at a time!"
docker-compose logs --tail=0 --follow shedlock-poc

echo "If you've finished, please run $ ./cleanup.sh to clean tear down and clean the stack."