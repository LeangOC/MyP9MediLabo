# dev1
1.  Initier le projet interface Client
2.  Port server.port=8080
3. Démarrage OK à vide ( mais page error status=404 => http://localhost:8080/ )
4. Implémentation page login  : http://localhost:8080/login  

    <img width="217" height="166" alt="image" src="https://github.com/user-attachments/assets/bf9aac81-b4aa-40e3-bf3c-449df8e0e2c8" />

# dev3
1. Implémenter la  classe PatientsProxy pour diriger la requête ves le Gateway :
    - @FeignClient(name = "patient-gateway", url = "localhost:8081")
2. Exposer l'Endpoint  dans la classe MyClientController : 
   -  @GetMapping("/api/patient")
3.  Implémentation la classe PatientBean , une copie celle du Microservice Patients :
   - Feign récupère la liste des patients et nous retourne sous forme de JSON brute.
     (On  stocke chaque patient dans  un objet de type Patient pour pouvoir les manipuler facilement plus tard)
4.   GET http://localhost:8080/api/patient  
      
   <img width="274" height="151" alt="image" src="https://github.com/user-attachments/assets/8c83c9ea-ff9e-409a-92f8-6f66d33f566b" />

# dev05
- L'utilisateur ne saisit pas pour le moment le login et le mot passe : données en dur dans le nouvelle classe FeignClientConfiguration.
  