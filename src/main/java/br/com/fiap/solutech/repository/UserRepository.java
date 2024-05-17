package br.com.fiap.solutech.repository;

import br.com.fiap.solutech.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
