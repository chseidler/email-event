# Email Event - Microservice

This is an email sender build in Java / Maven / Spring Boot application that can be used as a microservice.

## How to Run 

This application is packaged as a jar. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 11 and Maven 3.x
* The ```application.properties``` file need to be completed with ```spring.mail.username``` and ```spring.mail.password``` values
* You can build the project by running ```mvn clean install -DskipTests```

Once the application runs you should see something like this

```
2022-03-11 21:54:23.046  INFO 11996 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-03-11 21:54:23.061  INFO 11996 --- [           main] c.c.emailevent.EmailEventApplication     : Started EmailEventApplication in 6.052 seconds (JVM running for 6.899)
```

## About the Service

The service is email sender REST service. It uses an in-memory database (H2) to store the return. You can also do with a relational database like MySQL or PostgreSQL. If your database connection properties work, you can call some REST endpoint defined in ```com.chseidler.emailevent.controllers``` on **port 8080**. (see below)

Here are the endpoint you can call:

### Send email.

```
http://localhost:8080/sending-email
```

### Sending an email.

```
POST /sending-email
Accept: application/json
Content-Type: application/json

{
    "ownerRef":"Christian",
    "emailFrom":"**@gmail.com",
    "emailTo":"**@gmail.com",
    "subject":"Test API Email Event",
    "text":"Working!"
}

RESPONSE: HTTP 201 (Created)
{
    "emailId": 1,
    "ownerRef": "Christian",
    "emailFrom": "**@gmail.com",
    "emailTo": "****@gmail.com",
    "subject": "Test API Email Event",
    "text": "Working!",
    "sendDateEmail": "2022-03-11T23:55:45.475044",
    "statusEmail": "SENT"
}
```

### To view your H2 in-memory datbase

The 'test' profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8090/h2-console. Default username is 'sa' with a blank password. Make sure you disable this in your production profiles. For more, see https://goo.gl/U8m62X

# Running the project with PostgreSQL

This project uses an in-memory database so that you don't have to install a database in order to run it. However, converting it to run with another relational database such as PostgreSQL is very easy. Since the project uses Spring Data and the Repository pattern, it's even fairly easy to back the same service with MongoDB. 

The dependency is already in pom.xml

### Append this to the application.properties: 

```
---
# spring.datasource.url=jdbc:postgresql://localhost:5432/emailevent
# spring.datasource.username=postgres
# spring.datasource.password=
# spring.jpa.hibernate.ddl-auto=update
```

