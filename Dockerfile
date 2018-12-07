FROM java:8-jre
MAINTAINER Eduardo Pichler

RUN mkdir /usr/local/qualirede
RUN mkdir /usr/local/qualirede/lib
ADD build/libs/*.jar /usr/local/qualirede/qualirede.jar
ADD build/libs/lib/* /usr/local/qualirede/lib/

WORKDIR /usr/local/qualirede/

ENV MONGO_HOST localhost
ENV MONGO_PORT 27017

EXPOSE 8080

CMD ["java","-jar", "qualirede.jar"]
