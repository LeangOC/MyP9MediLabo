# master : Patient_Ms
1.  Implémentation le Microservice Patient_Ms  ( pour détails voir Readme_Patient_Ms.md)

# dev1 : Client  
1. Implémentation interface client ( ReadMe_Client.md )

# dev2 : Gateway
1. Implémentation la passerelle Gateway

# dev3 : Client
1. Diriger les requêtes vers Gateway

# dev04 <= dev3 : Gateway
1. Implémentation Auth Basic

# dev05 : Gateway , Client
1. Config minimale pour Auth Basic avec un login et un mot de passe

# dev06 : Client
1. Le Client (8080) relaye le header Authorization à Feign

# dev07 : Client,Gateway
1.  Relayer la page de login du Client pour l'authentification auprès de Gateway

# dev08 : Client
1. Implémenter la page /api/patient/list.html 