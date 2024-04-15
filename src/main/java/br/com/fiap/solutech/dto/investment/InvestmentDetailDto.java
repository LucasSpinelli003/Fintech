package br.com.fiap.solutech.dto.investment;

import br.com.fiap.solutech.dto.agency.AgencyDetailDto;
import br.com.fiap.solutech.dto.user.UserDetailDto;
import br.com.fiap.solutech.model.Investment;


import java.util.List;

public record InvestmentDetailDto (Long id, String name, String type, Double value, AgencyDetailDto agency, List<UserDetailDto> users ) {

    public InvestmentDetailDto(Investment investment){
        this(
                investment.getId(),
                investment.getName(),
                investment.getType(),
                investment.getValue(),
                new AgencyDetailDto(investment.getAgency()),
                investment.getUsers().stream().map(UserDetailDto::new).toList()
        );
    }
}
