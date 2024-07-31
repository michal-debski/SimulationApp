# Simulation Application
This app is created to simulate the Covid pandemic. 
To create application I used below technologies:
- Java 17,
- Gradle
- Lombok,
- Spring boot,
- Spring Data JPA,
- PostgreSQL,
- Flyway

## How to open this app:
1. Clone this repository into your local desktop
2. Create database named "simulation" in pgAdmin
4. Test application in Postman by:

   A) Creating a simulation by using post request with JSON for example:
   ```
       {
        "name": "Simulation",
        "populationSize": 10000,
        "initialInfected": 5,
        "infectionRate": 0.1,
        "mortalityRate": 0.01,
        "recoveryDays": 14,
        "deathDays": 7,
        "simulationDays": 100
      }
   ```
   B) Run the simulation by using post request with url for example:
     http://localhost:8080/simulation-app/api/simulations/1/run

   C) Look at the result in pgAdmin using query:
     ```
     "SELECT * FROM simulation_result"
       
As well you can:
 - update the input data by using the PUT Request in Postman on url:
  http://localhost:8080/simulation-app/api/simulations/1
 - delete simulation by using DELETE Request in Postman on url:
  http://localhost:8080/simulation-app/api/simulations/1
 - get the simulation by id by using the GET Request in Postman on url:
  http://localhost:8080/simulation-app/api/simulations/1
 - get all simulations by using the GET Request in Postman on url:
  http://localhost:8080/simulation-app/api/simulations

## What will be next? 
I would like to add frontend for this application to present the result dataset in the graphs as the  :) 
   
