# zebroid

Barcode to music

## Running the server

1. Build server: `mvn clean package -f server/pom.xml`
2. Start all services: `docker-compose up`
3. Insert data: `./data/insert-data-in-docker.sh`
4. Test `curl http://localhost:8080/barcode/get/078635470222`
