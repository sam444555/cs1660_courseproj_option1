FROM openjdk:8
COPY . /Users/Sam/Desktop/driver
WORKDIR /Users/Sam/Desktop/driver
EXPOSE 8080
RUN apt-get update
RUN apt-get -y install openssh-server
RUN useradd testuser
RUN passwd -testuser -testuser -testuser 
RUN service ssh restart
RUN javac driver.java
CMD ["java", "driver"]