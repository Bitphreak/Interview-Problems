#!/bin/bash

DEFAULT_BUILD_DIR="./build"
DEFAULT_SRC_DIR="./java"

: ${JAVA_BUILD_DIR:=$DEFAULT_BUILD_DIR}
: ${JAVA_SRC_DIR:=$DEFAULT_SRC_DIR}

if [ ! -d "$JAVA_BUILD_DIR" ]; then
	mkdir -p $JAVA_BUILD_DIR
fi


find $JAVA_SRC_DIR -regex '.*\.java' -exec javac -cp $JAVA_BUILD_DIR:$CLASSPATH -d $JAVA_BUILD_DIR {} \;

