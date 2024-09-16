package br.com.fiap.solutech.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record DataLoginDto(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
