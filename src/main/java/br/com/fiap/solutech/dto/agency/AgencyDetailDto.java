package br.com.fiap.solutech.dto.agency;

import br.com.fiap.solutech.model.Agency;
import br.com.fiap.solutech.model.Investment;

public record AgencyDetailDto (Long id, String name ) {
    public AgencyDetailDto(Agency agency){
        this(agency.getId(), agency.getName());
    }
}
