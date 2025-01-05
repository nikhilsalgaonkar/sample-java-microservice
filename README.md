# Sample Java Microservice for EKS

This is a simple Spring Boot microservice designed to be deployed on Amazon EKS (Elastic Kubernetes Service).

## Prerequisites

- Java 17
- Maven
- Docker
- kubectl configured with EKS cluster
- AWS CLI

## Local Development

1. Build the application:
```bash
mvn clean package
```

2. Run locally:
```bash
mvn spring-boot:run
```

The application will be available at http://localhost:8080

## Docker Build

Build the Docker image:
```bash
docker build -t sample-microservice:1.0.0 .
```

## Deployment to EKS

1. Tag and push the image to Amazon ECR:
```bash
aws ecr get-login-password --region region | docker login --username AWS --password-stdin YOUR_ACCOUNT_ID.dkr.ecr.region.amazonaws.com
docker tag sample-microservice:1.0.0 YOUR_ACCOUNT_ID.dkr.ecr.region.amazonaws.com/sample-microservice:1.0.0
docker push YOUR_ACCOUNT_ID.dkr.ecr.region.amazonaws.com/sample-microservice:1.0.0
```

2. Update the image in k8s/deployment.yaml to match your ECR repository.

3. Deploy to EKS:
```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

4. Check the deployment:
```bash
kubectl get pods
kubectl get services
```

## Endpoints

- `/`: Returns a hello message with current timestamp
- `/health`: Health check endpoint

## Configuration

The application uses the following default configuration:
- Server port: 8080
- Java version: 17
- Spring Boot version: 3.2.1
