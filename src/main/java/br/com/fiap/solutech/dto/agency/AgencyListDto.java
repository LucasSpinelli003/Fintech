package br.com.fiap.solutech.dto.agency;

import br.com.fiap.solutech.model.Agency;


public record AgencyListDto(Long id, String name) {

    public AgencyListDto(Agency agency){
        this(agency.getId(), agency.getName());
    }

}
