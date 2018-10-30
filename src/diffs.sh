#!/bin/bash
for file in ../MyParserTestFiles/*.nl; do
	echo ${file##*/}
	diff -q ${file} ../MyParserTestFiles2/${file##*/}
done