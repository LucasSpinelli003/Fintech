package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.model.Agency;
import br.com.fiap.solutech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long> {}
