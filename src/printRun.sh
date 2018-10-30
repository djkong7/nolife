#!/bin/bash
javac ast/*.java driver/*.java parser/*.java visitor/*.java
for file in ../ParserTestFiles/*.nl; do
  echo ${file##*/}
  java driver/Frontend ${file}
done