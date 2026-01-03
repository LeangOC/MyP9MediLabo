# solution3
1.  Spring initializr du projet Note_Ms (Spring boot 4.0.1, Spring Web,Spring Data MongoDB et Lombok)
2.  Implémentation model MVC
3.  remplacer dans pom.xml par : Spring boot 3.2.3, spring-boot-starter-web 
    => car lors de démarrage , on se retrouve avec une base nommée "test"
4. Implémentation de DataLoader pour charger les données.

# solution
1. renommage du projet en notems

# master3 
1. Ajouter l'endpoint @DeleteMapping("/patient/{id}") dans la classe NoteController
2. Ajouter la methode deleteByPatientId(Integer patientId) dans classe NoteRepository
3. Implémentation de Logger SLF4J dans la classe NoteController : 