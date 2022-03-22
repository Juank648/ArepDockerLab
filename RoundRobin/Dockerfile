FROM openjdk:8

WORKDIR /roundRobin/bin

ENV PORT 4567

COPY /target/classes /roundRobin/bin/classes
COPY /target/dependency /roundRobin/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","com.edu.eci.RoundRobin.RoundRobinApp"]