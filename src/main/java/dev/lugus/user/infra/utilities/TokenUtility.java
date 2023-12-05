package dev.lugus.user.infra.utilities;

import io.smallrye.jwt.build.Jwt;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TokenUtility {

    private TokenUtility(){}

    public static String generateToken(String email, String role){
        return Jwt
                .claim("email", email)
                .claim("role", role)
                .expiresIn(Duration.of(1, TimeUnit.DAYS.toChronoUnit()))
                .sign();
    }

}
