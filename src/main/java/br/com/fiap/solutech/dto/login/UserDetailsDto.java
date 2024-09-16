package br.com.fiap.solutech.dto.login;

import br.com.fiap.solutech.domain.Login;

public record UserDetailsDto(Long id, String username) {

    public UserDetailsDto(Login login) {
        this(login.getId(),login.getUsername());
    }

}
