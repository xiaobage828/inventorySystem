FROM java:openjdk-8

MAINTAINER xiaobage 1090789972@qq.com

WORKDIR  /app

COPY target/is-product-IS.2023.09.30.jar  is-product.jar

VOLUME /temp

EXPOSE 80

CMD ["java", "-jar", "is-product.jar"]

