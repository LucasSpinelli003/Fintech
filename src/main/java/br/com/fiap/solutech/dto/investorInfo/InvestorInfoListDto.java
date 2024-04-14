package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.model.InvestorInfo;
import br.com.fiap.solutech.model.RiskPatternType;


public record InvestorInfoListDto(Long id, Long idUser, RiskPatternType riskLevel) {
    public InvestorInfoListDto(InvestorInfo investorInfo){
        this(investorInfo.getId(), investorInfo.getIdUser(), investorInfo.getRiskLevel());
    }

}
