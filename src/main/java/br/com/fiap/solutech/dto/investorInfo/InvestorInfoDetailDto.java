package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.model.InvestorInfo;
import br.com.fiap.solutech.model.RiskPatternType;


public record InvestorInfoDetailDto(Long id, Long idUser, RiskPatternType riskLevel) {

    public InvestorInfoDetailDto(InvestorInfo investorInfo){
        this(investorInfo.getId(), investorInfo.getIdUser(), investorInfo.getRiskLevel());
    }
}
