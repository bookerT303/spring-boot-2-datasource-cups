# Using CUPS for database connection

## If you dont have an external Database
CUPS is for an external database but for this example we are going to use
a database from the marketplace.

cf cs p-mysql 100mb my-db

Bind it to an application so that we can get the information

cf push cups-example -p build/libs/datasource-cups-0.0.1-SNAPSHOT.jar --no-start

Now bind the my-db to the cups-example
cf bs cups-example my-db

Use cf env to get the database connection information
cf env cups-example

From the VCAP_SERVICES you can get the database information.

Now unbind the database
cf unbind-service cups-example my-db

## Create the CUPS
create the cups json from the information in the env output

cf cups cups-db -p '{"jdbcUrl":"jdbc:mysql://p-mysql-proxy.run.pivotal.io:3306/cf_3b945260_b32e_4912", "name": "cf_3b945260_b32e_4912", "password": "0haBVrHbzeu2hyFd"}'

## Configure the application
Notice: that we are using the service name and the properties name from the `cups` command.

application.yml
```yaml
spring:
  datasource:
    url: ${vcap.services.cups-db.credentials.jdbcUrl}
    username: ${vcap.services.cups-db.credentials.username}
    password: ${vcap.services.cups-db.credentials.password}
```

**NOTICE:** application.properties does not work

## Push your app
cf push cups-example -p build/libs/datasource-cups-0.0.1-SNAPSHOT.jar --no-start

## bind the cups
cf bs cups-example cups-db

## Restart the apps
cf restart cups-example

## Check if it worked
`curl localhost:8080/tags`

Since no data you should see "[]"

### Might need to create a table
`cf mysql my-db`

use the correct database

`create table Tag (id int, label VARCHAR(200));`

