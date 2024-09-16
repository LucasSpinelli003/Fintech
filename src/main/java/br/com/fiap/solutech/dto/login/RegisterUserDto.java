package br.com.fiap.solutech.dto.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserDto(
        @NotBlank
        @Size(max = 15)
        String username,

        @NotBlank
        String password) {
}
