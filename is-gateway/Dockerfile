FROM java:openjdk-8

MAINTAINER xiaobage 1090789972@qq.com

WORKDIR  /app

COPY target/is-warning-IS.2023.09.30.jar  is-warning.jar

VOLUME /temp

EXPOSE 80

CMD ["java", "-jar", "is-warning.jar"]

