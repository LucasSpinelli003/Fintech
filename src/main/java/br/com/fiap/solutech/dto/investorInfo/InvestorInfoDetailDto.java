package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.dto.user.UserDetailDto;
import br.com.fiap.solutech.model.InvestorInfo;
import br.com.fiap.solutech.model.RiskPatternType;
import br.com.fiap.solutech.model.User;


public record InvestorInfoDetailDto(Long id, UserDetailDto user, RiskPatternType riskLevel) {

    public InvestorInfoDetailDto(InvestorInfo investorInfo){
        this(
                investorInfo.getId(),
                new UserDetailDto(investorInfo.getUser()),
                investorInfo.getRiskLevel());
    }
}
