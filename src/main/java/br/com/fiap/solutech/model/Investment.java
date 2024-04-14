package br.com.fiap.solutech.model;

import br.com.fiap.solutech.dto.investment.InvestmentRegisterDto;
import br.com.fiap.solutech.dto.investment.InvestmentUpdateDto;
import br.com.fiap.solutech.dto.user.UserUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.zip.CheckedOutputStream;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "tb_investment")
public class Investment {

    @Id
    @GeneratedValue
    @Column(name = "id_investment")
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String type;

    @Column(precision = 9, scale = 3, nullable = false)
    private Double value;

    @Column(name = "id_agency",nullable = false)
    private Long idAgency;

    @Column(name = "id_user",nullable = false)
    private Long idUser;


    public Investment(InvestmentRegisterDto dto) {
        name = dto.name();
        type = dto.type();
        value = dto.value();
        idAgency = dto.idAgency();
        idUser = dto.idUser();
    }

    public void updateData(InvestmentUpdateDto dto) {
        if(dto.name() != null){
            name = dto.name();
        }
        if(dto.type() != null){
            type = dto.type();
        }
        if(dto.value() != null){
            value = dto.value();
        }
        if(dto.idAgency() != null){
            idAgency = dto.idAgency();
        }
        if(dto.idUser() != null){
            idUser = dto.idUser();
        }
    }
}
