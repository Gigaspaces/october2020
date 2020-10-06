#!/usr/bin/env bash
set -e
. ./env.sh

echo "Building services (processing units)..."
./build.sh

./demo-db/run.sh &> hsqldb.out &
HSQL_PID=$!
echo "Started HSQL DB [pid = $HSQL_PID , log = $(pwd)/hsqldb.out]"

echo "Creating container for mirror service (processing unit)..."
${GS_HOME}/bin/gs.sh container create --zone=mirror --memory=256m localhost
echo "Creating $SPACE_INSTANCES containers for space service (processing unit)..."
${GS_HOME}/bin/gs.sh container create --count=$SPACE_INSTANCES --zone=space --memory=512m localhost

echo "Deploying services (processing units)..."
./deploy.sh

echo "Writing ref table data to space..."
./feed-space.sh FX_RATES

echo "Redeploying space..."
./redeploy-space.sh

echo "Writing partitioned table data to space..."
./feed-space.sh FUTURES

echo "Demo start completed"
