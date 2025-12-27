# master : Patient_Ms
1.  Implémentation le Microservice Patient_Ms  ( pour détails voir Readme_Patient_Ms.md)

# dev1 : Client  
1. Implémentation interface client ( ReadMe_Client.md )

# dev2 : Gateway
1. Implémentation la passerelle Gateway

# dev3 : Client
1. Diriger les requêtes vers Gateway

# dev3Docker
1. docker-compose up --build
2. patient_ms ne veut pas démarré :
   pring.datasource.url=jdbc:mysql://localhost:3306/patientdb?createDatabaseIfNotExist=true => localhost par mysql
3. docker ps -a 
4. docker rm dccf4a85875c
5. docker images
6. docker rmi medilabop9-patient_ms:latest
7. $ mvn clean package -DskipTests
8. patient_ms  |org.hibernate.orm.jdbc.error: Access denied for user 'root'@'172.18.0.3' (using password: YES)
9.  docker-compose down : tout arrêté
10. docker rmi mysql:8.3

