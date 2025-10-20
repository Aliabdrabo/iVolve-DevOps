FROM maven:sapmachine AS builder
WORKDIR /app
COPY . .
RUN mvn package


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar","app.jar"]
EXPOSE 8080
