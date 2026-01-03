# master : Patient_Ms
1.  Implémentation le Microservice Patient_Ms  ( pour détails voir Readme_Patient_Ms.md)

# dev1 : Client  
1. Implémentation interface client ( ReadMe_Client.md )

# dev2 : Gateway
1. Implémentation la passerelle Gateway

# dev3 : Client
1. Diriger les requêtes vers Gateway

# dev04 : Gateway
1. Implémentation Auth Basic

# dev05 : Gateway , Client
1. Config minimale pour Auth Basic avec un login et un mot de passe

# dev06 : Client
1. Le Client (8080) relaye le header Authorization à Feign

# dev07 : Client,Gateway
1.  Relayer la page de login du Client pour l'authentification auprès de Gateway

# dev08 : Client
1. Implémenter la fonctionnalité l'affichage de page /patient/list

# dev09 : Patient_Ms, Client
1. Implémenter la fonctionnalité de la page /patient/add

# dev10 : Client, Patient_Ms
1. Implémentation de la fonctionnalité "delete" de la page /patient/list  

# dev11 : client, Patient_MS
1. Implémentation de la fonctionnalité "Edit" de la page /patient/list

# dev12 : Patient_Ms, Client
1. Implémentation de la fonctionnalité Rendez-Vous

# solution1 : Client, Gateway
1. Migrer vers une auth propre (JWT)

# solution2 : Client
1. Implémentation de la fonctionnalité logout

# solution3 : Note_Ms
1.  Implémentation du microservice Note_Ms

# solution4 : Gateway
1. Brancher Notes_MS au Gateway

# solution5 : Client
1. Relier Client au Note_Ms

# solution6 : Risk_Ms
1. Initialisation  microservice Risk_Ms

# solution7 : Risk_Ms
1. Implémentation microservice Risk_Ms

# solution8 : Client
1.  Intégration dans Client le niveau de risque.

## Solution : Dockerisation du projet Medilabo Solutions
1. Renommage Patient_Ms, Note_Ms et Risk_Ms en Patientms, Notems et Riskms
2. Implémentation fichier Dockerfile pour chaque interface.
3. Implémentation fichier docker-composer.yml pour l'ensemble du projet.
4. La commande "docker ps -a" :
<img width="1717" height="332" alt="image" src="https://github.com/user-attachments/assets/3757fbc2-75db-453f-abef-b4e73267614b" />


## Master
1 Merge de la branch Solution vers Master.  
2. GET http://localhost:8080/patient  

<img width="1378" height="504" alt="image" src="https://github.com/user-attachments/assets/80574b38-865f-4f3a-a771-d45f08e7613f" />

## Master2 : Gateway ( pour plus de détails voir le fichier ReadMe_Gateway.md dans Gateway)
1. Mise en place de Javadoc pour la Gateway  
2. Pour accéder à la page javadoc de Gateway, deux façon:   
      =>  Local (IDE Intellij ) : Gateway/target/site/apidocs/index.html   
      
   <img width="443" height="215" alt="image" src="https://github.com/user-attachments/assets/aecbed49-d147-4a70-bb3e-c09a1772b737" />

     =>  Github : "https://leangoc.github.io/MyP9MediLabo"  
   <img width="437" height="213" alt="image" src="https://github.com/user-attachments/assets/75af24ef-65dd-456f-a478-e4788faafc2a" />


# master3 : Notems, Patientms
1. Ajout la fonctionnalité de la suppression des notes liées à un patient dans la base de MongoDB
