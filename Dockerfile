FROM  openjdk:22-slim
RUN apt install -y maven
WORKDIR /app
RUN mvn clean package
COPY  target/*.jar /app/
EXPOSE 2000
CMD ["java","-jar","product_microservices-0.0.1-SNAPSHOT.jar"]
 