package br.com.fiap.solutech.service;

import br.com.fiap.solutech.domain.Login;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.token.secret}")
    private String password;

    public String getSubject(String tokenJwt){
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            return JWT.require(algorithm)
                    .withIssuer("SOLUTECH")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Não foi possivel validar o token JWT");
        }
    }

    public String gerarToken(Login login) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            return JWT.create()
                    .withIssuer("SOLUTECH")
                    .withSubject(login.getLogin())
                    .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao criar o token JWT");
        }
    }

}
