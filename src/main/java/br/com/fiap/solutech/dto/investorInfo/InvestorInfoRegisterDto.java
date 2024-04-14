package br.com.fiap.solutech.dto.investorInfo;

import br.com.fiap.solutech.model.RiskPatternType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InvestorInfoRegisterDto(

        @NotNull(message = "User id is required!")
        Long idUser,

        @NotBlank(message = "Risk level is required!")
        @Size(max = 30, min = 3, message = "The minimum risk level size is 3 and the maximum is 30!")
        RiskPatternType riskLevel

) {}
