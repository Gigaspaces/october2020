#!/usr/bin/env bash
. ./env.sh
${GS_HOME}/bin/gs.sh pu deploy --properties=values.yaml --zones=mirror mirror target/mirror-1.0.jar
${GS_HOME}/bin/gs.sh pu deploy --properties=values.yaml --zones=space --partitions=${SPACE_PARTITIONS} --ha=${SPACE_HA} -p pu.dynamic-partitioning=${SPACE_HA} space target/space-1.0.jar