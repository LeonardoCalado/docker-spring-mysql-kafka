## Docker MySQL

### Build da imagem
## Para subir apenas o MySQL comentar a linha "ADD ./create.sql /docker-entrypoint-initdb.d" em db/Dockerfile
docker build -t mysql-image -f db/Dockerfile .

### Run do container
### Port MySQL 3307
docker run -d -v $(pwd)/db/data:/var/lib/mysql -p 3307:3306 --rm --name mysql-container mysql-image

### Criação da database
docker exec -i mysql-container mysql -uroot -proot < db/create.sql

## Docker Kafka

### access dir /kafka
docker-compose up -d

## Application
docker-compose up -d