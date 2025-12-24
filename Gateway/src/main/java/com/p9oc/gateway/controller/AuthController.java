package com.p9oc.gateway.controller;

import com.p9oc.gateway.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Base64;

@RestController
public class AuthController {

    private final JwtService jwtService;
    private final ReactiveAuthenticationManager authManager;

    public AuthController(JwtService jwtService,
                          ReactiveAuthenticationManager authManager) {
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(
            @RequestHeader("Authorization") String authHeader) {

        String base64 = authHeader.substring("Basic ".length());
        String credentials = new String(Base64.getDecoder().decode(base64));
        String[] values = credentials.split(":");

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(values[0], values[1]);

        return authManager.authenticate(authToken)
                .map(auth -> jwtService.generateToken(auth.getName()))
                .map(jwt -> ResponseEntity.ok(jwt));
    }
}
