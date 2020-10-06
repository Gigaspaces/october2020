#!/usr/bin/env bash
. ./env.sh


java -cp "${GS_HOME}"/lib/required/*:./target/common-1.0.jar com.olympus.model.Generator "$1"