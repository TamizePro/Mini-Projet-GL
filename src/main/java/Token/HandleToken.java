package Token;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleToken {
    private String SECRET_KEY;
    private long EXPIRATION_TIME_MILLIS;

    public HandleToken()
    {
        Dotenv dotenv = Dotenv.configure()
        //.directory("Mini-Projet-GL")
        .load();
        this.SECRET_KEY = dotenv.get("SECRET_KEY");
        this.EXPIRATION_TIME_MILLIS = Integer.parseInt(dotenv.get("EXPIRATION_TIME_IN_HOURS")) * 3600000;
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME_MILLIS);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        try{
            Claims claims = Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            // Token validation failed
            return null;
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Token validation failed
            return false;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Remove "Bearer "
        }
        return null;
    }

    public boolean isTokenValid(HttpServletRequest request) {
        String token = resolveToken(request);
        return (token != null && validateToken(token));
    }
}
