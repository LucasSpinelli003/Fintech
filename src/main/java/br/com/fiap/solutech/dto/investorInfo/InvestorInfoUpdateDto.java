package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.model.RiskPatternType;
import br.com.fiap.solutech.model.User;
import jakarta.validation.constraints.Size;

public record InvestorInfoUpdateDto(

        Long userId,

        @Size(max = 30, min = 3, message = "The minimum risk level size is 3 and the maximum is 30!")
        RiskPatternType riskLevel


) {}
