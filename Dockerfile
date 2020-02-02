# Building the App with Maven
FROM maven:3.6.1-jdk-8-slim

RUN mkdir /app
WORKDIR /app

RUN ls /app/

# Run Maven build
COPY pom.xml pom.xml
RUN mvn dependency:go-offline

RUN rm -rf src
COPY src src
RUN mvn clean package -Dmaven.test.skip=true

FROM tomcat:9

# Change timezone.
RUN ln -fs /usr/share/zoneinfo/Hongkong /etc/localtime && dpkg-reconfigure -f noninteractive tzdata

RUN rm -rf /usr/local/tomcat/webapps/ROOT/*

COPY --from=0 /app/target/rate/ /usr/local/tomcat/webapps/ROOT
COPY docker-entrypoint.sh /usr/local

RUN chmod +x /usr/local/docker-entrypoint.sh

ENV DB_SERVER="127.0.0.1"
ENV DB_PORT="3306"
ENV DB_NAME="rate"
ENV DB_USER="www"
ENV DB_PASSWORD=""

ENTRYPOINT ["/usr/local/docker-entrypoint.sh"]
