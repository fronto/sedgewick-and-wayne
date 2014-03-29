#!/bin/bash

function summarizeJava () { 
    grep public $1 | awk 'BEGIN{ FS=":" }{print $NF}' | sed 's/public//g'
}

function compileSources() {

        if [ -d out ] 
		 then rm out/*.class
        fi
		STDLIB="lib/stdlib.jar"
		javac -cp $STDLIB  -d out ./src/*.java ./booksite/*java

}

function run() {

		java -cp "$STDLIB:out" ${*}

}
