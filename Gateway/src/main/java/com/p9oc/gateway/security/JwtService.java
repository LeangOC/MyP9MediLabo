package com.p9oc.gateway.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * Service de gestion des tokens JWT.
 * <p>
 * Gère la création et la validation des tokens JWT
 * utilisés pour sécuriser les communications.
 * </p>
 */
@Component
public class JwtService {

    private static final String SECRET =
            "MEDILABO_SUPER_SECRET_KEY_32_CHARS_MIN";

    private static final long EXPIRATION = 60 * 60 * 1000; // 1h
    /**
     * Génère un token JWT pour un utilisateur.
     *
     * @param username nom d’utilisateur
     * @return token JWT
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
    /**
     * Extrait le nom d’utilisateur depuis un token JWT.
     *
     * @param token token JWT
     * @return nom d’utilisateur
     */
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
