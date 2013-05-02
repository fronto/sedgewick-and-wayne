#!/bin/bash

rm src/*.class
CLASSPATH="lib/stdlib.jar:./src"
javac -cp $CLASSPATH  ./src/*.java
java -cp $CLASSPATH ${*}
