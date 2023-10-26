FROM java:openjdk-8

MAINTAINER xiaobage 1090789972@qq.com

WORKDIR  /app

COPY target/is-gateway-IS.2023.09.30.jar is-gateway.jar

VOLUME /temp

EXPOSE 80

CMD ["java", "-jar", "is-gateway.jar"]

