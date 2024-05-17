package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.name like %:name%")
        Page<User> searchByName(@Param("name") String name, Pageable page);

    @Query("SELECT DISTINCT u FROM User u JOIN u.investment i WHERE i.name LIKE %:name%")
    Page<User> searchByInvestmentName(@Param("name") String name, Pageable page);

}
