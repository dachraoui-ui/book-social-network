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
ARG APP_VERSION=1.0.4

WORKDIR /app
COPY --from=build /build/target/book-network-*.jar /app/

EXPOSE 8088

ENV DB_URL=jdbc:postgresql://postgres-sql-bsn:5432/book_social_network
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}
ENV EMAIL_HOSTNAME=missing_host_name
ENV EMAIL_USER_NAME=missing_user_name
ENV EMAIL_PASSWORD=missing_password
ENV VPS_HOSTNAME=missing_vps_host_name
ENV VPS_USER_NAME=missing_vps_user_name


CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} -Dspring.datasource.url=${DB_URL} book-network-${JAR_VERSION}.jar

