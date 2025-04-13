mvn clean install -f smolurl

docker build -t smolurl-backend smolurl

docker build -t smolurl-frontend smolurl-ui

docker-compose --env-file .env up --build --force-recreate
