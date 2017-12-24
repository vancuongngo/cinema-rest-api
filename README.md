# Cinema Rest API

Nearly real Cinema Rest API project for demonstrating the use of Hibernate and Spring Data JPA

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites


```
Java JDK
Maven
Git
```

### Installing

Cloning project

```
git clone https://github.com/bavuonglong/cinema-rest-api
```

## Deployment

Using Maven

```
mvn clean package && java -jar target/cinema-rest-api-0.0.1-SNAPSHOT.jar
```

Check out the service

```$xslt
$ curl http://localhost:1234
Welcome to Cinema Rest API
```

Access H2 Console DB via browser by the link
```$xslt
http://localhost:1234/console
```

Filling H2 information with:
```$xslt
Driver Class: org.h2.Driver 
jdbc: h2:mem:my_db
User Name: sa
Password: {empty}
```

## Authors

* [Cuong Ngo](https://github.com/bavuonglong)