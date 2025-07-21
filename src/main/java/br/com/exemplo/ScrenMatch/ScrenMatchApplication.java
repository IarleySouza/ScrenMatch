package br.com.exemplo.ScrenMatch;

import br.com.exemplo.ScrenMatch.principal.Principal;
import br.com.exemplo.ScrenMatch.principal.Principal_one;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  ScrenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Principal principal = new Principal();
		//principal.exibeMenu();
		Principal_one princ = new Principal_one();
		princ.exibeMenu();

	}
}
