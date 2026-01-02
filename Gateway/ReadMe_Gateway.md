# dev2
1. Implémentation de Gateway
2. Mise en place du routage GatewayConfig : /api/patient/** => http://localhost:8082
3. GET http://locahost:8081/ap/patient :  
   <img width="248" height="147" alt="image" src="https://github.com/user-attachments/assets/8b27b313-1dd8-49cd-a258-59457c1de231" />

# dev04
1. Ajout dans pom.xml : spring-boot-starter-security
   => En redémarrant Gateway : un login / mot de passe est obligatoire pour se connecter 
   => il dirige automatiquement vers http://localhost:8081/login avec la requêue get http://localhost:8081/api/patient  
 
 <img width="173" height="119" alt="image" src="https://github.com/user-attachments/assets/040082f8-6b3c-4694-ac06-b1b707cb813b" />  

 En rentrant le login=user et le mot de passe généré : xxxxxxxx =>  
 <img width="237" height="240" alt="image" src="https://github.com/user-attachments/assets/c791bb28-3473-4a36-ae39-d563c9fd94c2" />  

Mais pour la requête sur port 8080 de l'interface Client  "http://localhost:8081/api/patient" ça ne marche pas :  
- pas de redirection vers par la page de login Spring Sécurity
- même en utilisant :  curl -u user:5cb4f8dd-fc27-4a05-9f6e-ec06b8ad9836 http://localhost:8080/api/patient -v
     => Erreur : {"timestamp":"2025-12-14T15:14:55.861Z","status":500,"error":"Internal Server Error","path":"/api/patient"}
  ( curl permet d'envoyer le header Authorization )

# dev05
- Implémentation d'une config minimale avec SecurityConfig : Auth Basic avec un login "user et le mot de passe "password"
  ( non plus le mot de passe généré par Spring Secutiy)

# solution1 : migration vers JWT
1. Ajout dépendances dans fichier pom.xml : io.jsonwebtoken
2. Implémentation : classe JwtService, 
3. Implémentation : AuthController @PostMapping("/login")
4. Refactorer : SecurityWebFilterChain
5. Implémentation : JwtAuthenticationFilter
6. Refactorer : SecurityConfig.ReactiveAuthenticationManager 

# solution4 
1. Refactorisation : GatewayConfig en ajoutant la route vers http://localhost:8083
2. Refactorisation : SecurityConfig.SecurityWebFilterChain pour /api/notes/**

# solution : docker
1. renommer localhost dans la classe customRouteLocator correspondant à chaque interface en patientms, notems et riskms 

# Gateway : javadoc
1. Refactorisation des codes sources : les classes, le fichier pom.xml
2. Ajout pour chaque package le ficher  package-info.java
3. lancer la commande "mvn javadoc:javadoc"
4. Création répertoire /docs
5. copier le contenu du répertoire  Gateway/target/site/apidocs/ vers le répertoire /docs
6. Pour accéder à la page javadoc de Gateway :
  =>  Local : Gateway/target/site/apidocs/index.html en local
  =>  Github : /docs/index.html 