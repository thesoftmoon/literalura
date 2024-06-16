package com.tomaspacheco.literalura;

import com.tomaspacheco.literalura.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Main app loaded");

		//Principal principal = new Principal(repository);
		Principal principal = new Principal();
		principal.showMenu();

	}

}
