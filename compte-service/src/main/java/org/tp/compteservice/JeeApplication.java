package org.tp.compteservice;

import org.tp.compteservice.entities.Compte;
import org.tp.compteservice.entities.TypeCompte;
import org.tp.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JeeApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, 9000, TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 12000, TypeCompte.EPARGNE));
            compteRepository.findAll().forEach(System.out::println);
        };
    }
}
