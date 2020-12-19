FROM openjdk:14-alpine
ADD build/libs/*-all.jar shedlock-poc.jar
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "shedlock-poc.jar"]
