#!/bin/bash

rm src/*.class
CLASSPATH="lib/stdlib.jar:./src:./booksite"
javac -cp $CLASSPATH  ./src/*.java ./booksite/*java
