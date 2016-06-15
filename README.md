# springrestmongo

Build a very simple rest service secured by basic authentication. It is backed by MongoDB and uses Spring Data for database access


## Docker UP

`````
docker run -p 27017:27017 mongo
`````

set your docker IP in the application.yml.

## Test run

To start the app
`````
gradle bootRun
`````
and listens then on port 8080. To get a list of all person objects in database, following curl command can be used

`````
curl admin:pwd@localhost:8080/persons
`````
Let’s say, id of one object is 558883595ca419a113ee1440, then you get the specific person with

`````
curl admin:pwd@localhost:8080/persons/558883595ca419a113ee1440
`````
And so on…