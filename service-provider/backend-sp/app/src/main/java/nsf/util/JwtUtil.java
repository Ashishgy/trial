package nsf.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.vertx.ext.web.RoutingContext;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    // what is this secret key and should it be unique
    private static final String SECRET_KEY = "KFd9smHs8gNfxUhyyOUAjkszBJdXrZJxUP9IvVMyAmY="; // Use a secure key in production
    private static final int ACCESS_TOKEN_VALIDITY = 10 * 60 * 1000; // 10 minutes

    private static Key getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    // Generate Access Token
    public static String generateAccessToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate Token
    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract User ID from Token
    public static String getSPIdFromToken(RoutingContext ctx) {
        String token = ctx.request().getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove "Bearer "
        } else {
            return null; // Return null or throw an exception if the token is not present
        }

        try {
            // Parse the token and retrieve the claims
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            // Extract the user ID from the claims
            return claims.getSubject(); // The subject should contain the user ID
        } catch (Exception e) {
            return null; // Return null if the token is invalid or any exception occurs
        }
    }
    public static String getSPIdFromToken1(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject(); // Assuming the user ID is set as the subject
        } catch (Exception e) {
            return null; // Return null if token parsing fails
        }
    }
}
