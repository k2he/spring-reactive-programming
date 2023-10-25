# spring-reactive-programming

This demo shows how to build a Reactive Rest API using WebFlux. 
1) GET http://localhost:8080/api/v1/transfer request is not block any thread and wait for the response, but response shows at once
2) GET http://localhost:8080/api/v1/transfers-reactive request is not block any thread and wait for the response, but response shows when more date is returned from the endpoint
