##Tool required 
1->Java 1.8
2->maven
3->Mysql
4->eclipse
5->Postman

Start the mysql server
Import the project in to eclipse as  maven project and start the project by right clicking on the project and run as spring boot application
or if you want do deploy in any application server then build it with maven package and deploy to application server.

before running the project the configuration of database in application.properties file
spring.datasource.url= jdbc:mysql://localhost:3306/toDodb?useSSL=false
spring.datasource.username= root
spring.datasource.password= root

## Dependency
– If you want to use PostgreSQL:
```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```
## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`
- For PostgreSQL:
```
spring.datasource.url= jdbc:postgresql://localhost:5432/toDodb
spring.datasource.username= postgres
spring.datasource.password= 123

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

# App Properties
todo.app.jwtSecret= todoSecretKey
todo.app.jwtExpirationMs= 86400000
```

```
## Run Spring Boot application
```
mvn spring-boot:run
```


## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```



Open the Postman Post request 

Step1-> Sigup create a user using below url.

http://localhost:8080/api/auth/signup

in the Body provide below string as json 


{
	
	"username" : "mohsin123",
	"password" : "mohsin",
	"email" : "mohsin.eci2@gmail.com",
	"roles" : "ROLE_USER"
}

step2-> Now sign in to below URL to get bearer token.
http://localhost:8080/api/auth/signin

Json - {
"username" : "mohsin123",

"password" : "mohsin"


}

Now set the bearer token for the rest of the API calls;

Use the below URLs for the todo API testing.

http://localhost:8080/api/todo -Post call to add the Todo task.
http://localhost:8080/api/getTodo - get call to get all the todo tasks.
http://localhost:8080/api/getTodo/{id} - pass the ID to get by Id
http://localhost:8080/api/update/{id} - Put call to update by id
http://localhost:8080/api/delete/{id} - delete call to delete tasks by id

you can also use the Swagger for API documents at below location.
http://localhost:8080/swagger-ui.html

Alternatively also use the test controllers to test the file


 
 

