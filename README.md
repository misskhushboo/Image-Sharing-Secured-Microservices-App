# Image-Sharing-Secured-Microservices-App

An Image sharing microservices application that allows access to certain authorized users only.
Some of the System functionalities:
  - Application allows access to certain authorized users only. For now, Github OAuth authorization is used.
  - Secured access to APIs are permitted using JWT. Once the users register themselves in the application, they can access the APIs only if they have valid non-expired JWT tokens.
  - Orchestrator intercepting all public requests from the users. The request is then routed to other microservices on intranet.
  - Spring JPA, Spring Security is added. Spring Cloud APIs can also be integrated like API Gateway, Config server and client etc.
  - Integration with Amazon MQ (RabbitMQ) is done for the Orchestrator or other microservices to commute with each other in asynchronous way.
  - Account creation at Imgur is done but image sharing functionality is in progress. 
