# RESTful API server app with Java Spring Reactive Framework
A light-weight RESTful API server starter app built with Java Spring Reactive Framework, MongoDB, WebFlux and Gradle. 

## Features

### Running everything on Docker:
Using ```docker-compose``` run both mongoDB and the app as docker containers.
```
docker-compose up
```

### Not familiar with Docker? No problem run it locally on your machine: 
For this you will need to set up the MongoDB Locally on your machine(Refer the Local MongoDB Setup section towards the end.). 
Add the configurations in ```application.properties``` and run the below or use your fav IDE:  
```
./gradlew clean build
./gradlew bootRun
```

### Try the CRUD. Test the endPoints / REST APIs.
Once the server is running try to access the below APIs using ```cURL``` or ```POSTMAN``` or any tool that you are already using.   

CREATE: 
```POST``` /api/add

```
curl -X POST -d '{"name":"Giri Jeedigunta","email":"giri@yopmail.com"}' -H "Content-Type: application/json" http://localhost:4000/api/add -v
```

READ: 
```GET``` /api/get
```
curl http://localhost:4000/api/get
```

```GET``` /api/get/{email}

```
curl http://localhost:4000/api/get/{email}
```

UPDATE: 
```POST``` /api/udpate/{id}

```
curl -X POST -d '{"name":"Giri J","email":"giri@giri.com"}' -H "Content-Type: application/json" http://localhost:4000/api/update/5f85c2c8b0abe7062019dd16
```

DELETE: 
```POST``` /api/delete/{id}

```
curl -X POST http://localhost:4000/api/delete/5f85c2c8b0abe7062019dd16
```

### Local MongoDB Setup(Mac OS):
If you are not familiar with docker. Follow these steps to setup MongoDB on your machine locally. Here I have instructions for Mac OS. 
  
#### Easy MongoDB Installation: 
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

#### Add User, DB and collections:
Use the below section to create user, db, collections etc,. 

##### Creating User:
```
use admin;

db.createUser({
    user: "giri",
    pwd: "spring2020",
    roles:[
        {role: "dbAdmin", db:"springapi"}
    ]
});
```

##### Creating New Collection: 
```
use springapi;

db.createCollection( "api", {
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
```

##### Sample Data
```
db.api.insert({"name":"Giri Jeedigunta","email":"hello@spring.com"});
```

#### Adding Configuration to Java App: 
Add all the MongoDB related config in a simple URI format like below in the ```application.properties``` file. 

```
spring.data.mongodb.uri=mongodb://<Add_Your_UserName>:<Your_Password>@localhost:27017/<DB_NAME>?authSource=admin

// Example: 
spring.data.mongodb.uri=mongodb://giri:spring2020@localhost:27017/springapi?authSource=admin
```
