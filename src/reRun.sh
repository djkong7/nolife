#!/bin/bash
javac ast/*.java driver/*.java parser/*.java visitor/*.java
for file in ../MyParserTestFiles/*.nl; do
  echo ${file##*/}
  java driver/Frontend ${file} > ../MyParserTestFiles2/${file##*/}
done