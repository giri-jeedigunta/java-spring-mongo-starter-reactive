# REST starter App with Java Spring-Boot, Gradle, MongoDB, Webflux
This is a simple Java Reactive Spring boot starter app with MondoDB and Web Flux. This starter app have minimal code taking advantage of the spring framework and the insanely cool reactive dependencies !!!

### Running the App
```
./gradlew bootRun
```

### CRUD - Use cURL to access / test the REST APIs.
Once the server is running try the following APIs: 


GET /contacts/get
```
curl http://localhost:8083/contacts/get
```

GET /contacts/get/{email}

```
curl http://localhost:8083/conatcts/get/{email}
```

POST /contacts/add

```
curl -X POST -d '{"name":"Giri Jeedigunta","email":"giri@yopmail.com"}' -H "Content-Type: application/json" http://localhost:8083/contacts/add -v
```

POST /contacts/udpate/{id}

```
curl -X POST -d '{"name":"Giri J","email":"giri@giri.com"}' -H "Content-Type: application/json" http://localhost:8083/contacts/update/5f85c2c8b0abe7062019dd16
```

POST /contacts/delete/{id}

```
curl -X POST http://localhost:8083/contacts/delete/5f85c2c8b0abe7062019dd16
```

### Local MongoDB Setup(Mac):
 
#### Installation: 
```
brew tap mongodb/brew
brew install mongodb-community@4.4
```

#### Starting MongoDB
```
brew services start mongodb-community@4.4
or
mongod --config /usr/local/etc/mongod.conf --fork
```

#### Add new DB and collections:
Use the below section to create user, db, collections etc,. 

##### Creating DB:
```
use springContacts
```

##### Creating User:
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

##### Creating New Collections and Sample Data: 
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

#### Adding Configuration to Java App: 
Add all the MongoDB related config in the following format to ```application.properties```
```
spring.data.mongodb.uri=mongodb://<Add_Your_UserName>:<Your_Password>@localhost:27017/<DB_NAME>?authSource=admin

// Example: 
spring.data.mongodb.uri=mongodb://giri:spring2020@localhost:27017/springContacts?authSource=admin
```
