package fr.cci.formationobjet.java.PaintWeb;

import com.github.javafaker.Faker;
import fr.cci.formationobjet.java.PaintWeb.model.companies.Company;
import fr.cci.formationobjet.java.PaintWeb.model.companies.DAO.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class PaintWebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaintWebServerApplication.class, args);
	}

	// pour initialiser le service
	@Bean
	CommandLineRunner start(CompanyRepository cRepo) {
		return args -> {
			for (int i = 0; i < 200; i++) {
				Faker f = new Faker();
				String name = f.harryPotter().character();
				cRepo.save(new Company(name, 100+Math.random()*900));
			}
				cRepo.findAll().forEach(System.out::println);
		};
	}
}
