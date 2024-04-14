package br.com.fiap.solutech.dto.user;

import br.com.fiap.solutech.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDetailDto (Long id, String name, String mail, String password, Boolean notifications) {

    public UserDetailDto(User user){
        this(user.getId(), user.getName(), user.getMail(), user.getPassword(), user.getNotifications());
    }
}
