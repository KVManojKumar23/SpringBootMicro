FROM eclipse-temurin:21.0.12.1_1-jdk-ubi10-minimal
MAINTAINER "Manoj Kumar !!"
LABEL Description="This is a Dockerfile for product-services"
WORKDIR /myapp
COPY target/product-services-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
