package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.model.RiskPatternType;
import br.com.fiap.solutech.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InvestorInfoRegisterDto(

        @NotNull(message = "User id is required!")
        Long userId,

        @NotNull
        RiskPatternType riskLevel

) {}
