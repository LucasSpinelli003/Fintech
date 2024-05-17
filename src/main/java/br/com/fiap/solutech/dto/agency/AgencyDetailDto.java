package br.com.fiap.solutech.dto.agency;

import br.com.fiap.solutech.domain.Agency;

public record AgencyDetailDto (Long id, String name ) {
    public AgencyDetailDto(Agency agency){
        this(agency.getId(), agency.getName());
    }
}
