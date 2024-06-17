package com.tomaspacheco.literalura;

import com.tomaspacheco.literalura.principal.Principal;
import com.tomaspacheco.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{
	@Autowired
	//Dependency injection
	private BookRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}


	//Create the Author object and the table for the db, then un comment the row creation in Book object line 15 and 16
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Main app loaded");
		Principal principal = new Principal(repository);
		principal.showMenu();

	}

}
