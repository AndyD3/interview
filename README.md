# Interview app (MagiDash Corp)
An application created as part of the interview process for Anaplan.

I've some notes below based on my interpretation of what was sent to me; 
If I've went off track please notify me and I'll make the required changes before the next phase of the interview process.

### Notes
1. The documentation mentioned the database folder containing scripts (plural) but I confirmed with Stu there was only one original script.
2. The smoke tests ran and passed on my machine before I ran the app - once I ran the app the tests work as intended under some circumstances (perhaps a MacBook issue?)
Despite this anomaly I did endeavour to honour the intention of the tests and took the fact that it ran against port 80 to be part of the spec.
3. My machine has a running MySQL on it so I've had to change the default port.
4. The smoke tests and documentation required a script to create the test data; this I feel breaks the black box nature of an integration test
as well as potentially creating a state nof creatable from the API. 
I would have preferred to have done something such as using an end point to POST a dashboard then using the GET /dashboards for assertion.
That said; this is just an opinion and the specification is more important. 
5. I had the app running locally with integration tests (with the db running from docker) but removed these, 
thereby relying on the smoke tests (which aren't reliable enough for me) and a manual test.
This appeared to be what the spec wants, in part so I can demonstrate using Compose.
6. I kept the first sql script as-given assuming you would prefer update scripts as if this was a database I'd inherited. I also treat that
script as the source of truth so did things like use an Integer for the id in the entity and used validate in the properties etc.
7. I've returned the timestamp in the properties - made the assumption this was required.

## Steps to run
1. Build app and run tests:
```
mvn clean install
```
2. Build docker image
```
docker build -t adouglas/interview-app:latest .
```
3. Run the app in compose alongside MySQL DB:
```
docker-compose up --force-recreate
```
4. The web application is then running with JSON dashboards available at http://localhost:80/dashboards

## Testing
Once the app is running you can run the smoke tests with `./smoke_tests.sh`

## Author
* **Andy Douglas** - andy_douglasuk@yahoo.co.uk
