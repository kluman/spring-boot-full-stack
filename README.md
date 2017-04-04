# Full stack development with Sprint Boot, React, Material-UI and Webpack

This project demonstrates a full-stack implementation using [Spring Boot](https://projects.spring.io/spring-boot/)
to handle the backend wired together with [React](https://facebook.github.io/react/) and 
[Material-UI](https://github.com/callemall/material-ui) for the frontend rendering. 
While there are great resources out there for each of these components, more than 
I would ever attempt to document, I found it difficult to find them all put together
in an non-trivial way.

While this project is in no way what I would consider "production quality" it does
try to demonstrate more than just the simplistic "hello world" examples. Hopefully you
will find it of use in getting started with these great Web development platform/framworks.

## Backend

### Models and Data

As mentioned, [Spring Boot](https://projects.spring.io/spring-boot/) is being used
to manage the server side. An H2 (in memory) SQL database is used as the data source. The 
choice of H2 was solely for simplicity of the demo since no installation is required. 
Also included are Springs implementation of the [Java Persistence API](http://projects.spring.io/spring-data-jpa/) 
(JPA) for easy DB access using annotations and Repository interfaces and the REST [Spring Boot
Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters).


The models and their corresponding Repository interfaces are
all contained within the "domain" package. Models are simple pojos with various Spring
JPA annotations. Basically, every field in your pojo is in turn tied to a column in the DB.
It's that easy!

Each model pojo also contains a <code>Builder</code> static nested class 
following a builder pattern. None of these <code>Builder</code> classes are required and
would probably not exist in a real world example, but it made populating the H2 database
a heck of a lot easier. More on that later.

### MVC

TODO


## Frontend

TODO

