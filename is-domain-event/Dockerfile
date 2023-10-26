FROM java:openjdk-8

MAINTAINER xiaobage 1090789972@qq.com

WORKDIR  /app

COPY target/is-domain-event-IS.2023.09.30.jar  is-domain-event.jar

VOLUME /temp

EXPOSE 80

CMD ["java", "-jar", "is-domain-event.jar"]

