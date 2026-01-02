package com.p9oc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Application principale du Gateway MédiLabo.
 * <p>
 * Ce composant joue le rôle de point d’entrée unique du système
 * et assure le routage sécurisé des requêtes vers les microservices
 * (patient, notes, risque).
 * </p>
 *
 * @author OpenClassrooms
 * @version 1.0
 * @since 2025
 */
@SpringBootApplication
public class GatewayApplication {

	/**
	 * Point d’entrée de l’application Spring Boot.
	 *
	 * @param args arguments de lancement
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
