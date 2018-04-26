FROM frolvlad/alpine-oraclejre8:slim
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/dockerdemo.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT java -jar dockerdemo.jar

#docker image build -t dockerdemo .
#docker container run -d --name dockerdemo -p 8080:8080 dockerdemo
