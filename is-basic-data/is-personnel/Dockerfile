FROM java:openjdk-8

MAINTAINER xiaobage 1090789972@qq.com

WORKDIR  /app

COPY target/is-personnel-IS.2023.09.30.jar  is-personnel.jar

VOLUME /temp

EXPOSE 80

CMD ["java", "-jar", "is-personnel.jar"]

