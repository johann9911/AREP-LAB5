FROM openjdk:8

WORKDIR /usrapp/bin

ENV PORT 7000

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","co.escuelaing.edu.ServicesLogs.ServerApp"]
