package com.example.auth_service.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

//Jwt utility class hare validate token ,genarate token and extrac user name token
@Component
public class JwtUtil {
      private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
      private final long exprirationMs = 3600000; // 1 h

      public String generateToken(String username) {
            return Jwts.builder()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + exprirationMs))
                        .signWith(key)
                        .compact();
      }

      public String extractUsername(String token) {
            return Jwts.parserBuilder().setSigningKey(key).build()
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
      }

      public boolean validateToken(String token) {
            try {
                  Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
                  return true;
            } catch (JwtException e) {

                  return false;
            }
      }
}
