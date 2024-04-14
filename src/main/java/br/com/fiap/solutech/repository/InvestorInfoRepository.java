package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.model.InvestorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorInfoRepository extends JpaRepository<InvestorInfo, Long> {}
