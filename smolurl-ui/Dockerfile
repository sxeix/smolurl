
# Stage 1: Build the Angular application
FROM node:22-alpine AS build

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install

COPY . .

RUN npm run build

# Stage 2: Serve the application with angular-http-server
FROM node:22-alpine

WORKDIR /app

# Install angular-http-server globally
RUN npm install -g angular-http-server

# Copy the built application from the build stage
COPY --from=build /app/dist/smolurl-ui/browser /app/dist/smolurl-ui/browser

# Expose the port angular-http-server runs on
EXPOSE 8080

# Command to run the angular-http-server
CMD ["angular-http-server", "--path", "/app/dist/smolurl-ui/browser", "--port", "8080"]
