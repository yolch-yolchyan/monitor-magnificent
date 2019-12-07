# Getting Started

## Configs
The application configurations could be found `application.properties`, under directory **src/main/resources**.

## Prerequisites to Start the Application
```
- Java 11
- Maven 3.3.5+
```

## How to Run The Application
Execute the following steps to run the application. (I did this on Mac OS)
1. Open the terminal and go to the root folder of the project
2. Execute the command: `mvn clean package`. This will run test cases and generate an executable jar.
3. Execute the command: `java -jar target/monitor-magnificent-0.0.1-SNAPSHOT.jar`
4. The application is running and you can check the logs.

## Libraries Used
- Spring Boot is used to bootstrap the project. Spring also used for dependency injections and running a scheduler.
- lombok is used at runtime to make writing code easier and enjoyable: https://projectlombok.org/
- Apache HTTP is used to send requests to **magnificent** to check the application state.

## Other Notes
- When magnificent is down/not responding, this app will print error log, which could be handled
by our administrator's tool. This way we can inform him/her about that magnificent is down.
- We can easily send emails as notifications. To do so, we can create `MailNotificationSender` class and implement it
from `NorificationSender`, and start sending emails when **Magnificent** is down. Another way of handling failures.