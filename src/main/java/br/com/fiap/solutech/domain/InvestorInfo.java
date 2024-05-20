package br.com.fiap.solutech.domain;

import br.com.fiap.solutech.dto.user.UserRegisterDto;
import br.com.fiap.solutech.dto.user.UserUpdateDto;
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


    public InvestorInfo(UserRegisterDto dto) {
        riskLevel = dto.riskLevel();
    }

}
