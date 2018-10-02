#!/bin/bash

BASEDIR=$(dirname "$0")

redis-cli --pipe < "${BASEDIR}/data.txt"
