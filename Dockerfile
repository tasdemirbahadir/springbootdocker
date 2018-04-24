FROM frolvlad/alpine-oraclejre8:slim
RUN mkdir app
ADD /target/dockerdemo-0.0.1-SNAPSHOT.jar /app/dockerdemo.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT java -jar dockerdemo.jar

#docker image build -t dockerdemo .
#docker container run -d --name dockerdemo -p 8080:8080 dockerdemo
