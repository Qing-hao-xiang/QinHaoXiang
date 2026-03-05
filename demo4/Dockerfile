# 构建阶段
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# 运行阶段（使用新的镜像标签）
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]
