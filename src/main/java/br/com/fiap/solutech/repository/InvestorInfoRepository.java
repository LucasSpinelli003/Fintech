package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.domain.InvestorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorInfoRepository extends JpaRepository<InvestorInfo, Long> {}
