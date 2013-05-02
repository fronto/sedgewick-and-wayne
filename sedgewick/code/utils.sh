#!/bin/bash

function summarizeJava () { 
    grep public $1 | awk 'BEGIN{ FS=":" }{print $NF}' | sed 's/public//g'
}
