#!/bin/bash

rm *.class
javac -cp lib/stdlib.jar:. *.java
java -cp lib/stdlib.jar:. ${1}
