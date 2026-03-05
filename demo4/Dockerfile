# 基础镜像，包含JDK17和Maven
FROM maven:3.8-openjdk-17 AS build

# 设置工作目录
WORKDIR /app

# 复制pom.xml和源码
COPY pom.xml .
COPY src ./src

# 打包项目，跳过测试
RUN mvn clean package -DskipTests

# 运行阶段，使用更小的JRE镜像
FROM openjdk:17-jdk-slim

WORKDIR /app

# 从构建阶段复制Jar包
COPY --from=build /app/target/*.jar app.jar

# 暴露端口
EXPOSE 8080

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]