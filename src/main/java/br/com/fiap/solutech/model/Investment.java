package br.com.fiap.solutech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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




}
