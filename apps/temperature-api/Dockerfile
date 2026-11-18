FROM gradle:9.9.1-jdk21 AS build

WORKDIR /build
COPY . /build

RUN gradle build --no-daemon
FROM amazoncorretto:21-alpine-jdk

COPY --from=build /build/build/libs/*.jar ./application.jar

EXPOSE 8081
CMD java -jar ./application.jar