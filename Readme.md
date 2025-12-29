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

# Solution : Dockerisation du projet Medilabo Solutions
1. Renommage Patient_Ms, Note_Ms et Risk_Ms en Patient, Note et Risk
2. Implémentation fichier Dockerfile pour chaque interface.
3. Implémentation fichier docker-composer.yml pour l'ensemble du projet.

# Master
1 Merge de la branch Solution vers Master.
