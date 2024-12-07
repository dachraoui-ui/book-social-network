# build stage

FROM maven:3.8.7-openjdk-18 AS build
# installing mvn
WORKDIR /build
COPY pom.xml .
# copy pom.xml to the project location which is build to download the dependencies
RUN mvn dependency:go-offline
#download the dependency even your are offline
COPY src ./src
RUN mvn clean package -DskipTests

#Runtime stage
FROM amazoncorretto:17

ARG PROFILE=dev
ARG APP_VERSION=1.0.0

WORKDIR /app
COPY --from=build /build/target/book-network-*.jar /app/

EXPOSE 8088

ENV JAR_VERSION=${APP_VERSION}

CMD java -jar book-network-${JAR_VERSION}.jar

