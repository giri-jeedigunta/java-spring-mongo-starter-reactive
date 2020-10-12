# REST starter App with Java Spring-Boot, Gradle, MongoDB, Webflux
This is a simple Java Reactive Spring boot starter app with MondoDB and Web Flux. This app have minimal code taking advantage of the spring framework and the reactive dependencies. 

## Dependencies
```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb-reactive'
	implementation 'org.springframework.boot:spring-boot-starter-webflux'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
}
```
## Local MongoDB Setup(Mac):
 
### Installation: 
```
brew tap mongodb/brew
brew install mongodb-community@4.4
```

### Starting MongoDB
```
brew services start mongodb-community@4.4
or
mongod --config /usr/local/etc/mongod.conf --fork
```

### Add new DB and collections:
Use the below section to create user, db, collections etc,. 

#### Creating DB:
```
use springContacts
```

#### Creating User:
```
use admin;

db.createUser({
    user: "giri",
    pwd: "spring2020",
    roles:[
        {role: "dbAdmin", db:"springContacts"}
    ]
});
```

#### Creating New Collections and Sample Data: 
```
use springContacts;

db.createCollection( "contacts", {
   validator: { $jsonSchema: {
      bsonType: "object",
      required: [ "name" ],
      properties: {
         name: {
            bsonType: "string",
            description: "must be a string and is required"
         },
         email: {
            bsonType : "string",
            description: "must be a string and match the regular expression pattern"
         }
      }
   } }
} );

// Insert data:
db.contacts.insert({"name":"Giri Jeedigunta","email":"hello@spring.com"});
```

### Adding MongoDB Configuration to Spring Boot Java App: 
Add all the Mongo config in the following format to ```application.properties```
```
spring.data.mongodb.uri=mongodb://<Add_Your_UserName>:<Your_Password>@localhost:27017/<DB_NAME>?authSource=admin

// Example: 
spring.data.mongodb.uri=mongodb://giri:spring2020@localhost:27017/springContacts?authSource=admin
```
