package br.com.fiap.solutech.dto.user;

import br.com.fiap.solutech.domain.RiskPatternType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegisterDto(
        @NotBlank
        @Size(max=100, min = 3, message = "Min name size is 3 and max 100!")
        String name,
        @NotBlank
        @Size(max=150, min = 13, message = "Min mail size is 13 and max 150!")
        String mail,
        @NotBlank
        @Size(max=30, min = 6, message = "Min password size is  and max 30!")
        String password,
        @NotNull(message = "This fiels cannot be empty!")
        boolean notifications,
        @NotNull
        RiskPatternType riskLevel


) {}
