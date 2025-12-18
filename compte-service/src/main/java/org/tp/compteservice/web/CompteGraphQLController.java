package org.tp.compteservice.web;

import org.tp.compteservice.entities.Compte;
import org.tp.compteservice.entities.TypeCompte;
import org.tp.compteservice.repositories.CompteRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteGraphQLController {
    private final CompteRepository compteRepository;

    public CompteGraphQLController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @QueryMapping
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument Long id) {
        return compteRepository.findById(id).orElseThrow();
    }

    @MutationMapping
    public Compte createCompte(@Argument double solde, @Argument String type) {
        return compteRepository.save(
                Compte.builder()
                        .solde(solde)
                        .type(TypeCompte.valueOf(type))
                        .build()
        );
    }
}
