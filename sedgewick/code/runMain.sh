#!/bin/bash

rm Main.class
javac -cp lib/stdlib.jar:. *.java
java -cp lib/stdlib.jar:. Main $1
