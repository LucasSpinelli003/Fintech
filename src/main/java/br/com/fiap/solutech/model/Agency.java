package br.com.fiap.solutech.model;

import br.com.fiap.solutech.dto.agency.AgencyRegisterDto;
import br.com.fiap.solutech.dto.agency.AgencyUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "agency")
    private List<Investment> investiment;

    public Agency(AgencyRegisterDto dto) {
        name =  dto.name();
    }

    public void updateData(AgencyUpdateDto dto) {
        if(dto.name() != null){
            name = dto.name();
        }
    }
}
