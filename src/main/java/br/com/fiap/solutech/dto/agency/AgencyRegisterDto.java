package br.com.fiap.solutech.dto.agency;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AgencyRegisterDto(

        @NotBlank(message = "Name field cannot be empty!")
        @Size(max = 100, min = 5, message = "The minimum name size is 5 and the maximum is 100!")
        String name

) {}
