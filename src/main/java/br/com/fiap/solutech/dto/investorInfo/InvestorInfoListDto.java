package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.model.InvestorInfo;
import br.com.fiap.solutech.model.RiskPatternType;
import br.com.fiap.solutech.model.User;


public record InvestorInfoListDto(Long id, User idUser, RiskPatternType riskLevel) {
    public InvestorInfoListDto(InvestorInfo investorInfo){
        this(investorInfo.getId(), investorInfo.getUser(), investorInfo.getRiskLevel());
    }

}
