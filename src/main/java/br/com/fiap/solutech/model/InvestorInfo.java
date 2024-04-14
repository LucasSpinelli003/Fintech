package br.com.fiap.solutech.model;


import br.com.fiap.solutech.dto.investorInfo.InvestorInfoRegisterDto;
import br.com.fiap.solutech.dto.investorInfo.InvestorInfoUpdateDto;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "tb_investor_info")
public class InvestorInfo {

    @Id
    @GeneratedValue
    @Column(name = "id_investor_info")
    private Long id;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "lv_risk", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private RiskPatternType riskLevel;

    public InvestorInfo(InvestorInfoRegisterDto dto) {
        idUser = dto.idUser();
        riskLevel = dto.riskLevel();
    }

    public void updateData(InvestorInfoUpdateDto dto) {
        if(dto.idUser() != null){
            idUser = dto.idUser();
        }
        if(dto.riskLevel() != null){
            riskLevel = dto.riskLevel();
        }
    }
}
