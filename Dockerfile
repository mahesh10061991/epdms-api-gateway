FROM openjdk:21
LABEL maintainer = "SourceFuse"
ADD target/epdms-api-gateway-0.0.1-SNAPSHOT.jar epdms-api-gateway.jar
ENTRYPOINT ["java","-jar","epdms-api-gateway.jar"]