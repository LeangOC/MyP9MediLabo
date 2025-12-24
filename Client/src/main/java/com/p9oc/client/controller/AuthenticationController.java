package com.p9oc.client.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login(){
    return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ) {
        String basic = Base64.getEncoder()
                .encodeToString((username + ":" + password).getBytes());

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + basic);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(
                        "http://localhost:8081/login",
                        HttpMethod.POST,
                        request,
                        String.class
                );

        session.setAttribute("JWT", response.getBody());

    return "redirect:/patient";
    }
}
