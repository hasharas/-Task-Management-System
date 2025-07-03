package com.example.task_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;

// jwtfilter to validate JWT tokens
@Component
public class JwtFilter implements Filter {

      private final Key key;

      public JwtFilter(@Value("${jwt.secret}") String secret) {
            this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
      }

      @Override
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                  throws IOException, ServletException {

            HttpServletRequest req = (HttpServletRequest) request;
            String authHeader = req.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                  ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                              "Missing or invalid Authorization header");
                  return;
            }

            String token = authHeader.substring(7);
            System.out.println("Authorization header: " + authHeader);
            try {
                  Claims claims = Jwts.parserBuilder()
                              .setSigningKey(key)
                              .build()
                              .parseClaimsJws(token)
                              .getBody();

                  request.setAttribute("username", claims.getSubject());

            } catch (Exception e) {
                  System.err.println("JWT validation error: " + e.getMessage());
                  ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
                  return;
            }

            chain.doFilter(request, response);
      }
}
