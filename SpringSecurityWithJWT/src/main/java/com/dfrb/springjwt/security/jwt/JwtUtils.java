package com.dfrb.springjwt.security.jwt;

import com.dfrb.springjwt.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import java.util.Date;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class JwtUtils {
    public String generateJwtToken(Authentication a) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) a.getPrincipal();
        return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiresIn)).signWith(SIGNATURE_ALRORITHM, secretKey)
                .compact();
    }
    
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Firma JWT Inválida: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("JWT Token Inválido: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("El JWT Token ha expirado: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT Token no soportado: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("La Cadena de Reclamos del JWT Token está vacía: {}", e.getMessage());
        }
        return false;
    }
    
    // Campos de Clase
    @Value("${jwt.auth.secret_key}")
    private String secretKey;
    
    @Value("${jwt.auth.expires_in}")
    private int expiresIn;
    
    private final SignatureAlgorithm SIGNATURE_ALRORITHM = SignatureAlgorithm.HS256;
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
}
