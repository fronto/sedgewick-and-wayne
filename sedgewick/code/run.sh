#!/bin/bash

rm *.class
javac -cp lib/stdlib.jar:./src *.java
java -cp lib/stdlib.jar:./src ${1}
