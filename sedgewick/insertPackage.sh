#!/bin/bash

function printSedCommand() {
	cat <<+
LINE h
LINE s/^.*$/package bob.sedgewick;/g
LINE G 
+
}

function printSedCommandWithLineNumber() {

	LINE_NUMBER=${1}
	printSedCommand | sed "s/LINE/${LINE_NUMBER}/g"

}

function printWhere() {

	cat <<+
BinaryDump.java 23
BinaryStdInTester.java 15
BinaryStdOutTester.java 7
Copy.java 14
HexDump.java 24
StdArrayIO.java 57
StdStats.java 37
Stopwatch.java 19
DrawListener.java 1
BinaryIn.java 11
BinaryOut.java 14
BinaryStdIn.java 12
BinaryStdOut.java 13
Draw.java 25
In.java 18
Out.java 10
Picture.java 20
PictureDump.java 16
StdAudio.java 15
StdDraw.java 23
StdDraw3D.java 22
StdIn.java 9
StdOut.java 9
StdRandom.java 47
+
}

function insertPackageName() {

	FILE=$1
	LINE_NUMBER=$2

	sed -e "$(printSedCommandWithLineNumber ${LINE_NUMBER})" -i '' ${FILE}	
	sed -e "${LINE_NUMBER} G" -i '' ${FILE}

}

for tuple in $(seq 1 1 $(printWhere | wc -l)); do
	FILE=$(printWhere | sed -n "$tuple p" | awk '{print $1}')
	LINE_NUMBER=$(printWhere | sed -n "$tuple p" | awk '{print $2}')
	insertPackageName $FILE $LINE_NUMBER
done
