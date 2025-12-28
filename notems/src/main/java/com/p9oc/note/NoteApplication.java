package com.p9oc.note;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;

@SpringBootApplication
public class NoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);
	}
	@Bean
	CommandLineRunner checkMongoDb(MongoDatabaseFactory factory) {
		return args -> {
			System.out.println(">>> MongoDB database: " + factory.getMongoDatabase().getName());
		};
	}
}
