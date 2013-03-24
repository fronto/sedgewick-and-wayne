#!/bin/bash

rm src/*.class
javac -cp lib/stdlib.jar:./src ./src/*.java
java -cp lib/stdlib.jar:./src ${1}
