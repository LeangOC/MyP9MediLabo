# Initier le  projet Patient_Ms et Demarrage à vide : KO

# master : Patient_Ms  
1. Ajout url mysql dans application.properties
2. Creation schema plus charger les data.sql
3. Implémentation du model MVC de base pour visualiser le contenu de la table
4. url http://localhost:8080/api/patient OK : Affichage les 4 lignes en Json

<img width="280" height="135" alt="image" src="https://github.com/user-attachments/assets/1e83d65a-d1a0-4e62-bd0a-0309a4a1ace0" />

# dev09
1. Modifier en Integer Patient_id : Sinon JSON parse error ici
2. Implémenter PatientService.createPatient

# dev10
1. Ajout dans PatientController : @DeleteMapping("/{id}")
2. Ajout dans PatientService : getPatientById(int id) et deletePatient(int id)

# dev11
1. Ajout dans PatientControll@PutMappinger : @GetMapping("/{id}")
2. Ajout dans PatientController : @PutMapping 
3. Ajout dans PatientService : patientService.updatePatient