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

    @Column(name = "lv_risk", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private RiskPatternType riskLevel;

    @JoinColumn(name = "id_user",nullable = false)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;


    public InvestorInfo(InvestorInfoRegisterDto dto,  User user) {
        this.user = user;
        riskLevel = dto.riskLevel();
    }

    public void updateData(InvestorInfoUpdateDto dto) {
        if(dto.riskLevel() != null){
            riskLevel = dto.riskLevel();
        }
    }
}
