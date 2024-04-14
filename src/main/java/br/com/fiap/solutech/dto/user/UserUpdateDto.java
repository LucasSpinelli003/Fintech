package br.com.fiap.solutech.dto.user;

import jakarta.validation.constraints.Size;

public record UserUpdateDto(

        @Size(max=100, min = 3, message = "Min name size is 3 and max 100!")
        String name,
        @Size(max=150, min = 13, message = "Min mail size is 13 and max 150!")
        String mail,
        @Size(max=30, min = 6, message = "Min password size is  and max 30!")
        String password,
        boolean notifications

) {
}
