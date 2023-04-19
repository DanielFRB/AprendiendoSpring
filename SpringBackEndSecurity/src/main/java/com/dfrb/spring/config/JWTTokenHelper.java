package com.dfrb.spring.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class JWTTokenHelper {
    // Obtiene el cuerpo del Token JWT
    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            claims = null;
        }
        return claims;
    }
    
    // Extrae el valor del username del Token JWT
    public String getUserNameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    
    // Metodo que permite generar el Token JWT
    public String generateToken(String username) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return Jwts.builder().setIssuer(appName).setSubject(username)
                .setIssuedAt(new Date()).setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALRORITHM, secretKey).compact();
    }
    
    // Metodo que genera la fecha de expiracion del Token JWT
    private Date generateExpirationDate() {
        return new Date(new Date().getTime() + (expiresIn * 1000));
    }
    
    // Metodo que permite hacer una validacion del Token JWT
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserNameFromToken(token);
        return (username != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    // Metodo que devuelve Verdadero si el Token JWT a expirado
    public boolean isTokenExpired(String token) {
        Date expireDate = getExpirationDate(token);
        return expireDate.before(new Date());
    }
    
    // Metodo que extrae la fecha de expiracion del Token JWT
    private Date getExpirationDate(String token) {
        Date expireDate;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            expireDate = claims.getExpiration();
        } catch (Exception e) {
            expireDate = null;
        }
        return expireDate;
    }
    
    // Metodo que obtiene la fecha de creacion del Token JWT
    public Date getIssuedAtDateFromToken(String token) {
        Date issuedAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issuedAt = claims.getIssuedAt();
        } catch (Exception e) {
            issuedAt = null;
        }
        return issuedAt;
    }
    
    // Metodo que obtiene la cadena especifica de caracteres del Token JWT
    public String getToken(HttpServletRequest request) {
        String authHeader = getAuthHeaderFromHeader(request);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }
    
    // Metodo que obtiene la cabecera de autorizacion de la solicitud HTTP
    private String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }
    
    // Campos de Clase
    @Value("${jwt.auth.app}") // El Valor por defecto se encuentra en el application.properties
    private String appName;
    
    @Value("${jwt.auth.secret_key}") // El Valor por defecto se encuentra en el application.properties
    private String secretKey;
    
    @Value("${jwt.auth.expires_in}") // El Valor por defecto se encuentra en el application.properties
    private int expiresIn;
    
    // Se escoje el tipo de algoritmo de firma de seguridad HS256
    private final SignatureAlgorithm SIGNATURE_ALRORITHM = SignatureAlgorithm.HS256;
}
