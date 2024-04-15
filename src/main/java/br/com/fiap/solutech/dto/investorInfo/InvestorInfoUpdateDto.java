package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.model.RiskPatternType;
import br.com.fiap.solutech.model.User;
import jakarta.validation.constraints.Size;

public record InvestorInfoUpdateDto(

        Long userId,
        RiskPatternType riskLevel


) {}
