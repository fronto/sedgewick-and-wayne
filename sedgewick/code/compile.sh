#!/bin/bash

rm out/*.class
STDLIB="lib/stdlib.jar"
javac -cp $STDLIB  -d out ./src/*.java ./booksite/*java
