mvn clean install -f smolurl

docker build -t smolurl-backend smolurl

docker build -t smolurl-frontend smolurl-ui # run independently with docker run -p 4200:8080 smolurl-frontend

docker-compose --env-file .env up --build --force-recreate
