# Clinic_history_ms
this ms handle the pet clinic history including vaccines, diseases, medicine, appointments, etc.
## Deployment in local (docker):
1) compile the project with maven:

    ```mvn clean package```
2) build the docker image:

    ```docker build -t clinic_history_ms .```
3) run the docker image:

    ```docker run -p 8080:8080 clinic_history_ms```
4) open the browser in the following url:

    ```http://localhost:8080/api/pet```
## Requests Examples:
I left a Json file with one example of all entrie points in the ms. You can import it in postman and test the ms.
## Remote access: