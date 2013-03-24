#!/bin/bash

rm src/Main.class
javac -cp lib/stdlib.jar:. src/*.java
java -cp lib/stdlib.jar:./src Main $1
