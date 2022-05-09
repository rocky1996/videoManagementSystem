FROM kevinyan001/aliyun-mvn:0.0.1 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src

WORKDIR /build/
# mount anonymous host directory as .m2 storage for contianer 
VOLUME /root/.m2

RUN mvn clean package -Dmaven.test.skip=true --quiet

FROM openjdk:8-jre


COPY --from=MAVEN_BUILD /build/target/*.jar /app/application.jar

ENTRYPOINT ["java", "-jar", "/app/application.jar"]
