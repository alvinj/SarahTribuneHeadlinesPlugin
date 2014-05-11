#!/bin/bash

sbt package

if [ $? != 0 ]
then
  echo "'sbt package' failed, exiting now"
  exit 1
fi

cp target/scala-2.10/tribuneheadlines_2.10-0.1.jar TribuneHeadlines.jar

ls -l TribuneHeadlines.jar

echo ""
echo "Created TribuneHeadlines.jar. Copy that file to /Users/al/Sarah/plugins/DDTribuneHeadlines, like this:"
echo "cp TribuneHeadlines.jar /Users/al/Sarah/plugins/DDTribuneHeadlines"

