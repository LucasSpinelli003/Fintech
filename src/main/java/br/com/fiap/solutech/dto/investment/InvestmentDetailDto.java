package br.com.fiap.solutech.dto.investment;

import br.com.fiap.solutech.model.Investment;
import br.com.fiap.solutech.model.User;

public record InvestmentDetailDto (Long id, String name, String type, Double value, Long idAgency, Long idUser ) {

    public InvestmentDetailDto(Investment investment){
        this(investment.getId(), investment.getName(), investment.getType(), investment.getValue(), investment.getIdAgency(), investment.getIdUser());
    }
}
