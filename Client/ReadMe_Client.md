# dev1
1.  Initier le projet interface Client
2.  Port server.port=8081
3. Démarrage OK à vide ( mais page error status=404 => http://localhost:8081/ )
4. Implémentation page login

# dev3
1. Implémenter la  classe PatientsProxy pour diriger la requête ves le Gateway :
    - @FeignClient(name = "patient-gateway", url = "localhost:8081")
2. Exposer l'Endpoint  dans la classe MyClientController : 
   -  @GetMapping("/api/patients")
3.  Implémentation la classe PatientBean , une copie celle du Microservice Patients :
   - Feign récupère la liste des patients et nous retourne sous forme de JSON brute.
     (On  stocke chaque patient dans  un objet de type Patient pour pouvoir les manipuler facilement plus tard) 
      

