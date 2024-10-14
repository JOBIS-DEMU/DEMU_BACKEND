# 설치할 java 버전
FROM openjdk:17-jdk 

# .jar file의 경로
ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=doker", "-jar", "app.jar"]
