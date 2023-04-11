package com.example.ex080910.controller;

import com.example.ex080910.dto.LoginDto;
import com.example.ex080910.dto.TokenDto;
import com.example.ex080910.model.Usuario;
import com.example.ex080910.repository.UsuarioRepository;
import com.example.ex080910.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AutenticadorController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public AutenticadorController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioRepository repository, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto loginDto){
        var login = loginDto.converter();
        try {
            var authentication = authenticationManager.authenticate(login);
            var token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Usuário e/ou senha incorretos");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Validated Usuario usuario) {
//        perfilRepository.save(usuario.getPerfil());

        var novoUsuario = Usuario.builder()
                .username(usuario.getUsername())
                .password(encoder.encode(usuario.getPassword()))
                .build();
        repository.save(novoUsuario);
        return ResponseEntity.created(URI.create("/auth/cadastrar")).build();
    }
}
