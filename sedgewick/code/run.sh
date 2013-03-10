#!/bin/bash

javac -cp lib/stdlib.jar:. *.java
java -cp lib/stdlib.jar:. ${1}
