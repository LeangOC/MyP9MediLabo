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
- GET http://localhost:8080/api/patient ( Le routage fonctionne au niveau de Gateway malgré l'existence de Spring Security )
  
  <img width="225" height="160" alt="image" src="https://github.com/user-attachments/assets/986d9fb4-6f2d-4389-a5a9-01df7396cb14" />

# dev06
- Refactoriser la classe FeignClientConfigureation prendre en compte le header Authorization
  curl -u user:password http://localhost:8080/api/patient => envoie le header :
  _Authorization: Basic dXNlcjpwYXNzd29yZA==_
  
# dev07
1.  Refactoriser le  @Controller AuthenticationController 
2. Reimplémenter la classe FeignClientConfiguration

http://localhost:8080/login   => http://localhost:8080/api/patient  
<img width="215" height="162" alt="image" src="https://github.com/user-attachments/assets/2cfdf0aa-e169-4c6e-a63c-cb79a4552e23" />   =>   <img width="225" height="120" alt="image" src="https://github.com/user-attachments/assets/00923045-e49c-4153-8cff-9e39bd20cfd5" />

# dev08
1. Implémentation de la page /patient/list.html : juste pour afficher la liste des patients
2. GET http://localhost:8080/api/patient  
   
   <img width="388" height="197" alt="image" src="https://github.com/user-attachments/assets/bc14af28-63bb-4e05-8aa6-eb8990ae9c8d" />

# dev09
1. Ajout la fonctionnalité de la page /patient/add.html
2. Modifier en Integer PatientBean_id (Client ) sinon
   - [Request processing failed: feign.FeignException$BadRequest: [400 Bad Request] 
   during [POST] to [http://localhost:8081/api/patient]
   - JSON parse error côté Microservice Patient_Ms
3. http://locahost:8080/patient/add :
<img width="572" height="328" alt="image" src="https://github.com/user-attachments/assets/a719a9d4-860e-498d-bc1f-f2a9228c8234" />

# dev10
1.  Implémenter l'action "delete" dans la page /patient/list.html
2.  Ajouter dans le contrôleur ClientController : @GetMapping("/patient/delete/{id}")
3.  Ajouter dans PatientsProxy : @DeleteMapping( value = "/api/patient/{id}")
4.  http://localhost:8080/api/patient  
    <img width="368" height="235" alt="image" src="https://github.com/user-attachments/assets/fd0f45a2-3f14-4896-9db8-1bceb0aaadf1" />
   
# dev11
1. Implémenter l'action "Edit" dans la page /patient/list.html
2. Ajouter dans le contrôleur ClientController : @GetMapping("/patients/update/{id}")
3. Ajouter dans PatientsProxy : @GetMapping( value = "/api/patient/{id}"
4. Ajouter dans le contrôleur ClientController : PatientsProxy.updatePatient(patientBean);
5. Ajouter dans PatientsProxy : @PutMapping(value= "/api/patients")