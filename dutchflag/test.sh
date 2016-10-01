#!/bin/bash

DEFAULT_BUILD_DIR="./build"

: ${JAVA_BUILD_DIR:=$DEFAULT_BUILD_DIR}

if [ -d "$JAVA_BUILD_DIR" ]; then

	java -cp $JAVA_BUILD_DIR:$CLASSPATH com.maxjspaulding.java.util.test.TestRunner

else

	echo "Didn't find build directory - $JAVA_BUILD_DIR"

fi


