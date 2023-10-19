FROM gradle:jdk18-jammy AS build
ENV APP_HOME=/home/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src

RUN gradle build || return 0
COPY . .
RUN gradle clean build

# actual container
FROM openjdk:18.0-slim
ENV ARTIFACT_NAME=hello-world-java-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/home/app/

WORKDIR $APP_HOME
COPY --from=build $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 5001
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}