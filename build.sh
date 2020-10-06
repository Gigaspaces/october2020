#!/usr/bin/env bash
if [ -e target ]; then
    echo "Purging existing files from target..."
    rm -r target
fi
mvn package
mkdir target
mv common/target/common-1.0.jar target/
mv space/target/space-1.0.jar target/
mv mirror/target/mirror-1.0.jar target/