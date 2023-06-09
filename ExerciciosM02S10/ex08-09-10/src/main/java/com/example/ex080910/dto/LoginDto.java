package com.example.ex080910.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UsernamePasswordAuthenticationToken converter(){
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
