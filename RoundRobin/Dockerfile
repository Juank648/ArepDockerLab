FROM openjdk:8

WORKDIR /roundRobin/bin

ENV PORT 6000

COPY /target/classes /roundRobin/bin/classes
COPY /target/dependency /roundRobin/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","com.edu.eci.RoundRobin.RoundRobinApp"]
