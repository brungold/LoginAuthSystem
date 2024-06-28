package com.loginauthsystem.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    private final KeyPair keyPair;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Starting doFilter in doFilterInternal");
//        String authorization = request.getHeader("Authorization");
//        if (authorization == null) {
//            filterChain.doFilter(request, response);
//            return;
//        }
        String token = getTokenFromRequest(request);
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        JWTVerifier jwtVerifier = JWT.require(Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), null))
                .build();
//        String token = authorization.substring(7);
        DecodedJWT decodedToken = jwtVerifier.verify(token);
        String login = decodedToken.getSubject();
        List<SimpleGrantedAuthority> roles = decodedToken.getClaim("roles")
                .asList(String.class)
                .stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login, null, roles);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        // Old approach - read the Header "Authorization" +
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        // + or new approach with cookies
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("accessToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
