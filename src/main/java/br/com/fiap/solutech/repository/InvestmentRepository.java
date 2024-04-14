package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {}
