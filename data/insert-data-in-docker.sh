#!/bin/bash

BASEDIR=$(dirname "$0")
CONTAINER_NAME=zebroid_redis_1
CONTAINER_DIRECTORY=/data

docker cp "${BASEDIR}/insert-data.sh" ${CONTAINER_NAME}:${CONTAINER_DIRECTORY}
docker cp "${BASEDIR}/data.txt" ${CONTAINER_NAME}:${CONTAINER_DIRECTORY}

docker exec -i -t ${CONTAINER_NAME} /bin/bash -c ${CONTAINER_DIRECTORY}/insert-data.sh
