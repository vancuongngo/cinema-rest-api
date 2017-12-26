# Cinema Rest API

Nearly real Cinema Rest API project for 
- Demonstrating the use of Hibernate and Spring Data JPA
- Applying AOP and writing an annotation to log the execution time of a method

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites


```
Java JDK
Maven
Git
Lombok plugin for IDEA
```

### Installing

Cloning project

```
git clone https://github.com/bavuonglong/cinema-rest-api
```

## Deployment

The project uses Spring Boot, so you can start it any of a few ways

Using IDEA

```$xslt
Run the main method from CinemaRestApiApplication
```

Packaging the application as a JAR and run it
```
mvn clean package && java -jar target/cinema-rest-api-0.0.1-SNAPSHOT.jar
```

Using Maven Spring Boot plugin
```$xslt
mvn spring-boot:run
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

## Things

### One to One relationship
- A foreign key column is created in owner entity, in our example, Showtime owns ShowtimeSystem, so @JohnColumn will be used in Showtime entity.
- Foreign key column's name is the concatenation of the name of relationship in the owner side, _ , and then name of the primary key column(s) in the owned side.
- The owner is responsible for the association column(s) update, a side as not responsible for the relationship will use attribute mappedBy
- Besides that, we have other approaches for OneToOne at [here](https://howtodoinjava.com/hibernate/hibernate-one-to-one-mapping-using-annotations/)

### Many to One relationship
- ManyToOne annotation is always defined on owning entity, along with @JoinColumn annotation
- If no @JoinColumn is defined along with the @ManyToOne mapping, then a default name is assumed.

### Many to Many relationship
- Refer [here](http://www.mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/) for normal case
- And [here](https://www.mkyong.com/hibernate/hibernate-many-to-many-example-join-table-extra-column-annotation/) for join table has extra columns


## Authors

* [Cuong Ngo](vancuongngo.93@gmail.com)