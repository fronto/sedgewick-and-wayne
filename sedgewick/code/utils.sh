#!/bin/bash

function summarizeJava () { 
    grep public $1 | awk 'BEGIN{ FS=":" }{print $NF}' | sed 's/public//g'
}

function compileSources() {

		rm out/*.class
		STDLIB="lib/stdlib.jar"
		javac -cp $STDLIB  -d out ./src/*.java ./booksite/*java

}
