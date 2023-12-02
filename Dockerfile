FROM  openjdk:22-slim
WORKDIR /app
COPY  target/*.jar /app/
EXPOSE 2000
CMD ["java","-jar","product_microservices-0.0.1-SNAPSHOT.jar"]
 