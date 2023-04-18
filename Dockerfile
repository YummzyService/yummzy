FROM openjdk:11-slim as builder
WORKDIR /buid
COPY . .
RUN chmod +x gradlew && ./gradlew bootJar -x testClasses

FROM openjdk:11-slim
WORKDIR /app
RUN groupadd yummzy && useradd -ms /bin/bash -g yummzy yummzy
USER yummzy
COPY --chown=yummzy --from=builder buid/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
