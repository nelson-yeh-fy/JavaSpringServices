package com.example.spring.services.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.spring.services.model.Auth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "https://localhost:8081")
@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("auth")
    public Auth login(@RequestParam("loginName") String loginName, @RequestParam("password") String pwd) {

        String token = getJWTToken(loginName);
        Auth auth = new Auth();
        auth.setLoginName(loginName);
        auth.setToken(token);
        return auth;
    }

    private String getJWTToken(String loginName) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("JavaSpringServicesJWT")
                .setSubject(loginName)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}