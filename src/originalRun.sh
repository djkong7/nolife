#!/bin/bash
javac ast/*.java driver/*.java parser/*.java visitor/*.java
mkdir -p ../MyParserTestFiles/
for file in ../ParserTestFiles/*.nl; do
  echo ${file##*/}
  java driver/Frontend ${file} > ../MyParserTestFiles/${file##*/}
done