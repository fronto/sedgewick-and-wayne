#!/bin/bash
source utils.sh

compileSources
java -cp "$STDLIB:out" Main ${*}
