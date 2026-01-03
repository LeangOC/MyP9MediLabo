package com.p9oc.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.p9oc.patient.proxies")
public class PatientMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMsApplication.class, args);
	}

}
