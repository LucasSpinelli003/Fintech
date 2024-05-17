package br.com.fiap.solutech.dto.user;

import br.com.fiap.solutech.domain.User;

public record UserListDto(Long id, String name, String mail, String password, Boolean notifications) {
    public UserListDto(User user){
        this(user.getId(), user.getName(), user.getMail(), user.getPassword(), user.getNotifications());
    }

}
