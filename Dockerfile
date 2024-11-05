FROM openjdk:17-oracle

COPY ./target/*.jar employee-project.jar

CMD ["java", "-jar", "employee-project.jar"]