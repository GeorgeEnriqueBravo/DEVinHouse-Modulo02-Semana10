package com.example.ex080910.service;

import com.example.ex080910.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class TokenService {
    @Value("${security.jwt.expiration}")
    private Long tempoExpiracao;

    @Value("${security.jwt.secret}")
    @Getter
    private String secret;

    public String gerarToken(Authentication authentication){
        var user = (Usuario) authentication.getPrincipal();
        var hoje = new Date();
        var expiracao = new Date();
        expiracao.setTime(hoje.getTime() + tempoExpiracao);

        return Jwts.builder()
                .setIssuer("Security JWT")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(hoje)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        var claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
