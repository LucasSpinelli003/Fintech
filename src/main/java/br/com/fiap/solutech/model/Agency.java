package br.com.fiap.solutech.model;

import br.com.fiap.solutech.dto.agency.AgencyRegisterDto;
import br.com.fiap.solutech.dto.agency.AgencyUpdateDto;
import br.com.fiap.solutech.dto.user.UserRegisterDto;
import br.com.fiap.solutech.repository.AgencyRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "tb_agency")
public class Agency {

    @Id
    @GeneratedValue
    @Column(name = "id_agency")
    private Long id;

    @Column(length= 100,nullable = false)
    private String name;

    public Agency(AgencyRegisterDto dto) {
        name =  dto.name();
    }

    public void updateData(AgencyUpdateDto dto) {
        if(dto.name() != null){
            name = dto.name();
        }
    }
}
