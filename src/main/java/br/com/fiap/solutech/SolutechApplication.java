package br.com.fiap.solutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SolutechApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolutechApplication.class, args);
	}

}
