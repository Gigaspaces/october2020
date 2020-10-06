#!/usr/bin/env bash
export GS_HOME=/home/alon/Downloads/builds/15.5.1/gigaspaces-xap-enterprise-15.5.1
export SPACE_PARTITIONS=2
export SPACE_HA=true
if [ ${SPACE_HA} = true ]; then
    export SPACE_INSTANCES=$((${SPACE_PARTITIONS}*2))
else
    export SPACE_INSTANCES=${SPACE_PARTITIONS}
fi
