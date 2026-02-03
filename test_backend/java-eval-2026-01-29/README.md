# Introduction 
The java eval project, if you are here it's a good starting point.
Reading this file you should understand what you have to do. 

# Getting Started
The project is a SpringBoot project.
You need java 21 to have it run.

## Project hierarchy
There is 3 main package in the project :
 * lu.post.eval.entrypoint : It contains all code related to what is exposed and usable by a client of the backend. So here you should find the @RestController. The Controller defined here should implement generated class based on the __src/main/resources/java-eval-api.yaml__. The entrypoint's classes should use the __domain__ package to provide what the clients need.
 * lu.post.eval.domain : This package contains the business code of the backend. It uses BO (Business Object), if some third party service are needed, it uses the code coming from the __infra__ package.
 * lu.post.eval.infra : Here we store all code related to usage of a third party.

# Build
Use
```
mvn clean compile  
```

# Run
To run the project use 
```
mvn spring-boot:run
```


# Test 
A postman collection is provided in the _postman folder.
Very small unit test are existing...

# TODO
When implementing, we expect you will understand and follow the practice already in place in the backend. 

 * Add a new route __java-eval-api/my-ip__ to this backend : It should return the outgoing IP of the backend, using the HTTPBin client on path http://httpbin.org/ip.
  The Format of the response for the path __java-eval-api/my-ip__ should be a JSON : 
```json
{ "myIp" : "XX.XX.XX.XX" }
```
The HTTPBin Client library is already well generated for you in the __httpbin-client-1.0-SNAPSHOT.jar__ and already used for another path as example.

## At the End
 *  Push the result of your work in a dedicated branch : eval/name-surname

