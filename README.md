# Full stack development with Sprint Boot, React, Material-UI and Webpack

This project demonstrates a full-stack implementation using [Spring Boot](https://projects.spring.io/spring-boot/)
to handle the backend wired together with [React](https://facebook.github.io/react/) and 
[Material-UI](https://github.com/callemall/material-ui) for the frontend rendering. 
While there are great resources out there for each of these components, more than 
I would ever attempt to document, I found it difficult to find them all put together
in an non-trivial way.

While this project is in no way what I would consider "production quality" it does
try to demonstrate more than just the simplistic "hello world" examples. Hopefully you
will find it of use in getting started with these great Web development platform/frameworks.

## Installation

### Dependencies

1. [Git](https://git-scm.com/downloads), of course, installed on your local machine. 
2. [Maven](https://maven.apache.org/) to compile and run the project.

Assuming you have Git and Maven on your local machine you will run the following commands. On the terminal of your
choice and change directories to where you want the cloned project files to download.

```
git clone https://github.com/kluman/about.git
```
Since we are using Maven to run/build this project you will execute the following at the project root.

```
mvn spring-boot:run
```
In your Web browser go to <span style="font-style: Courier;">http://localhost:8080/</span> 


## Backend

### Spring Boot

As mentioned [Spring Boot](https://projects.spring.io/spring-boot/) is the foundation
for the server side. An H2 (in memory Java-based) SQL database is used as the data store. The 
choice of H2 was solely for simplicity of the demo, since no installation is required. 
Also included is the Spring implementation of the [Java Persistence API](http://projects.spring.io/spring-data-jpa/) 
(JPA). This allows for easy DB access using annotations and `*Repository` interfaces.
Rounding off the backend is the REST [Spring Boot
Starter](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter) to 
support the RESTful APIs our React Javascript is going to call. You can read more about Spring
Boot Starters and get a list of the many that are provided at the link provided. In short though,
as stated:

>Spring Boot Starters are a set of convenient dependency descriptors that you can include 
in your application. You get a one-stop-shop for all the Spring and related technology that you 
need without having to hunt through sample code and copy paste loads of dependency descriptors.

Simply add the Starter you want as a dependency in your POM file and that's it, you're ready to roll.

There are four used here.

|Name                           | Description               
-------------------------------|----------------------------
spring-boot-starter-data-rest  | Starter for exposing Spring Data repositories over REST using Spring Data REST. |
spring-boot-starter-data-jpa   | Starter for using Spring Data JPA with Hibernate.
spring-boot-starter-web        | Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.
spring-boot-starter-mustache   | Starter for building MVC web applications using Mustache views.


#### Structure

The models and their corresponding `*Repository` interfaces are all contained within 
the "domain" package. Models are simple POJOs with various Spring JPA annotations. Basically, 
every field in your POJO is in turn tied to a column in the DB.
It's that easy!

Each model POJO also contains a `Builder` static nested class 
following a builder pattern. None of these `Builder` classes are required and
would probably not exist in a real world example, but it made populating the H2 database
a heck of a lot easier. More on that later.

#### MVC

We are following the typical layout specified in the [Spring Boot Docs](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-locating-the-main-class)
with an `Application` class on the root package using a `@SpringBootApplication` annotation to 
explicitly identify our main application class. This class does two things of interest. First it kicks off our Spring
Boot app and second imports our `WebConfiguration` class.
 
The `WebConfiguration` is also very simple doing one thing. By extending the `RepositoryRestConfigurerAdapter`
class and overriding its `configureRepositoryRestConfiguration` method it routes all of the RESTful API 
endpoints through the "/api" path.

```
http://localhost:8080/api/persons
```

There is a single controller class in the project, `AboutController`, that routes requests to the root path to the
"index.html" page. Which is actually our one Mustache-templated page. It also looks for the first `Person` in our
database and puts it as the model for Mustache to use.

#### Database Population

With Spring Boot there is no need for reading and loading in a SQL file, we can do everything we need to populate
or H2 database - right in Java. Spring has various events that you can hook into and the `AboutLoader` class takes 
advantage of `ContextRefreshedEvent` that is triggered when the `ApplicationContext` gets initialized or refreshed.

This class does a couple things. First it used the `AutoWired` annotation to inject in instances of our `*Repository` JPA 
classes and set them to corresponding fields. The second is overrdiding the `onApplicationEvent` method and it is
in this method that we use all of those `Builder` static nested classes to populate the database with content.

## Frontend

TODO
