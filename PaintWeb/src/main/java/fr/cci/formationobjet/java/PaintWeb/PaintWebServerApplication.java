package fr.cci.formationobjet.java.PaintWeb;

import com.github.javafaker.Faker;
import fr.cci.formationobjet.java.PaintWeb.model.companies.Company;
import fr.cci.formationobjet.java.PaintWeb.model.companies.DAO.CompanyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class PaintWebServerApplication {

    private static final Logger logger = LogManager.getLogger(PaintWebServerApplication.class);

	
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


	@Bean
	CommandLineRunner testLogger() {
		return args -> {
			for (int i = 0; i < 200; i++) {
				Faker f = new Faker();
				String name = f.harryPotter().quote();
				logger.debug("Debug " + name);
				logger.info("Info " + name);
				logger.warn("warning " + name);
				logger.error("error " + name);
				logger.fatal("fatal " + name);
			}
		};
	}
}
