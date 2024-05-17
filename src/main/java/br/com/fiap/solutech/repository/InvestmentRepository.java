package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.domain.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {}
