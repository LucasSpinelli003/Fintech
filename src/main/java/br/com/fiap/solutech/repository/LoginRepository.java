package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginRepository extends JpaRepository<Login, Long>  {

    UserDetails findByLogin(String login);

}
