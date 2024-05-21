package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.domain.Agency;
import br.com.fiap.solutech.domain.Investment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    @Query("from Investment i where i.name like %:name%")
    Page<Investment> searchByName(@Param("name") String name, Pageable page);

}
