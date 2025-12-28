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
9.  docker-compose down : tout arrêté et puis docker rmi $(docker images -q)
10. docker system prune -a --volumes
11. docker system df
10. $ docker volume rm medilabop9_mysql-data
10. docker rmi mysql:8.3
11. mysql => Maria
12. Connection refused executing GET http://localhost:8081/api/patient] with root cause
13. PatientsProxy client : localhost => gateway:8081
14. gateway : [35e1c3a5-1]  500 Server Error for HTTP GET "/api/patient"
15. Gateway :  GatewayConfig : "http://localhost:8082 => "http://patient_ms:8082
16. mvn clean package : Erreur , il cherche à tester : Could not create URI object: Expected scheme-specific part at index 5: http 
17. => mvn clean package -DskipTests
14. Conclusion: ça fonctionne => Ne pas utiliser les "_" : http://patient_ms:8082 => http://patientms:8082

