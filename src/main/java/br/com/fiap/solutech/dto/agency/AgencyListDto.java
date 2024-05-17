package br.com.fiap.solutech.dto.agency;

import br.com.fiap.solutech.domain.Agency;


public record AgencyListDto(Long id, String name) {

    public AgencyListDto(Agency agency){
        this(agency.getId(), agency.getName());
    }

}
