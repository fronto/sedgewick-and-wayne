#!/bin/bash

function summarizeJava () { 
    grep public $1 | awk 'BEGIN{ FS=":" }{print $NF}' | sed 's/public//g'
}

function compileSources() {

        if [ -d target ] 
		 then rm target/*.class
        fi
		STDLIB="lib/stdlib.jar"
		javac -cp $STDLIB  -d target ./src/main/java/*.java ./booksite/*java

}

function run() {

		java -cp "$STDLIB:target" ${*}

}
