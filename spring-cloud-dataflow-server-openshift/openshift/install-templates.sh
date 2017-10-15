#!/usr/bin/env bash

project=${1:-scdf}

echo "Installing OpenShift templates into project '${project}'..."


oc replace --force=true -f ./deployment-config.yaml
oc replace --force=true -f ./scdf-sa.yaml

echo "Adding 'edit' role to 'scdf' Service Account..."

oc policy add-role-to-user edit system:serviceaccount:${project}:scdf

echo "Adding 'scdf' Service Account to the 'anyuid' SCC..."

oc adm policy add-scc-to-user anyuid system:serviceaccount:scdf:scdf

echo "Templates installed."
