#!/usr/bin/env bash
. ./env.sh
echo "Undeploying services (processing units)..."
./undeploy.sh

echo "Killing GSCs with zones space, mirror"
${GS_HOME}/bin/gs.sh container kill --zones=space,mirror

echo "Stopping HSQL DB..."
./demo-db/shutdown.sh

echo "Demo stop completed"