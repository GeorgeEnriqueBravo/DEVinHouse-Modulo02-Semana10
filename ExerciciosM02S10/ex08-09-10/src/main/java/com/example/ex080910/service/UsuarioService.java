package com.example.ex080910.service;

import com.example.ex080910.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromUser(Long id){
        var user = this.repository.findById(id).orElse(null);
        return user != null ? user.getAuthorities() : null;
    }
}
