FROM openjdk:8

WORKDIR /logService/bin

ENV PORT 4567

COPY /target/classes /logService/bin/classes
COPY /target/dependency /logService/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","com.edu.eci.logService.LogServiceMain"]