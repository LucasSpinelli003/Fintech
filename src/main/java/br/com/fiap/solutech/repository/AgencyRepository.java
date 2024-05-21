package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.domain.Agency;
import br.com.fiap.solutech.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
    @Query("from Agency a where a.name like %:name%")
    Page<Agency> searchByName(@Param("name") String name, Pageable page);
}
