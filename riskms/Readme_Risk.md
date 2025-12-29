# Solution6
1. Refactorisation : application.properties port 8084
    => Démarrage Application Risk_Ms OK

# Solution7
1. Refactorisation : RiskApplication @EnableFeignClients
2. Implémentation : entité RiskLevel
3. Implémentation : Entité DTO RiskAssessment
4. Impémentation : PatientProxy, NoteProxy
5. Implémentation : PatientBean, NoteBean
6. Implémentation : service RiskTriggers, RiskService
7. Démarrage KO : Could not resolve dependencies for project com.p9oc:risk:jar:0.0.1-SNAPSHOT
    => Solution remplacer la version Spring-boot 3.5.9 par 3.2.3
8. Implémentation : FeignAuthInterceptor ( Risk_MS récupère le JWT entrant et le renvoie)
9. Test OK sous POSTMAN de GET /api/risk/patient/1 =>  { "patientId": 1, "riskLevel": "NONE" }

# solution
1. Renommer le projet en riskms