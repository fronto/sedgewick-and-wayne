#!/bin/bash

rm *.class
javac -cp lib/stdlib.jar:. *.java
