#!/bin/bash
SRCS=`ls ParserTestfiles/*.nl`
for f in $SRCS;
do
  java -jar nolife.jar $f
done
