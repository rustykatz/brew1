# Springboot Sandbox 

Setup is similar to Tutorial from here:
https://spring.io/guides/gs/spring-boot#scratch


## How to run
in root dir
```
.\mvnw spring-boot:run
```

## Sending Requests
can send curl requests like
```
curl http://localhost:8080/
```
### Routes
- "/"
- "/mono"
- "/receive"


## Checking Status
check health up app 
```
curl http://localhost:8080/actuator/health
```

## Architecture 

### dto 
- RequestDTO -> request from client 
- ResponseDTO -> response to client 
- DataDTO -> Request/Response DTO return a data property which contains a list of DataDTO 


