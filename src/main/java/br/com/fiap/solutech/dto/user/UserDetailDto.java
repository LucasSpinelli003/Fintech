package br.com.fiap.solutech.dto.user;

import br.com.fiap.solutech.domain.RiskPatternType;
import br.com.fiap.solutech.domain.User;

public record UserDetailDto (Long id, String name, String mail, String password, Boolean notifications, RiskPatternType riskLevel) {

    public UserDetailDto(User user){
        this(user.getId(), user.getName(), user.getMail(), user.getPassword(), user.getNotifications(), user.getInvestorInfo().getRiskLevel());
    }
}
