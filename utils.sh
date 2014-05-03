#!/bin/bash

function summarizeJava () { 
    grep public $1 | awk 'BEGIN{ FS=":" }{print $NF}' | sed 's/public//g'
}

function run() {

        STDLIB="lib/stdlib.jar"
        BUILD_ARTIFACT="target/scala-2.10/sedgewick-and-wayne_2.10-1.0.jar"
        
		checkFileExists $STDLIB
		checkFileExists $BUILD_ARTIFACT
		java -cp "$STDLIB:$BUILD_ARTIFACT" ${*}

}

function checkFileExists() {
	if [ ! -f $1 ]
		then echo "error: cannot locate $1"
		exit
	fi
}
