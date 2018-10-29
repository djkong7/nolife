#!/bin/bash
for file in ../MyParserTestFiles/*.nl; do
	diff -q ${file} ../MyParserTestFiles2/${file##*/}
done