package br.com.fiap.solutech.dto.user;

import br.com.fiap.solutech.domain.RiskPatternType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserInvestorInfoUpdate(
        @NotNull
        RiskPatternType riskLevel
) { }
