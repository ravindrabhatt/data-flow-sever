#!/usr/bin/env bash

echo "Pulling images..."

declare -a images=(
  "donovanmuller/spring-cloud-dataflow-server-openshift:1.1.0.RELEASE"
  "digitalwonderland/zookeeper"
  "wurstmeister/kafka:0.10.1.0"
  )

for((i=0;i<${#images[@]};i++))
do
   echo "Pulling '${images[$i]}' - `expr $i + 1` of ${#images[@]}"
   docker pull ${images[$i]}
done
