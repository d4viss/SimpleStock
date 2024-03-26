package com.simpleStock.sys.infra.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.simpleStock.sys.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import com.auth0.jwt.JWT;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String createToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("Simple Stock")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getIduser())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException("Error Creación de Token");
        }
    }

    public String getSubject(String token){
        if(token == null){
            throw new RuntimeException("Token nulo");
        }
        DecodedJWT decodedJWT = null;
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("Simple Stock")
                    .build();
            decodedJWT = verifier.verify(token);
        }catch (JWTVerificationException e){
            System.out.println("token inválido");
        }
        return decodedJWT.getSubject();
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
