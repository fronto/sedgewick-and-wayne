#!/bin/bash

rm out/*.class
CLASSPATH="lib/stdlib.jar:./src:./booksite"
javac -cp $CLASSPATH  -d out ./src/*.java ./booksite/*java
