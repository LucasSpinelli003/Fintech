package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.domain.RiskPatternType;

public record InvestorInfoUpdateDto(

        Long userId,
        RiskPatternType riskLevel


) {}
