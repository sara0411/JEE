package org.tp.compteservice.web;

import org.tp.compteservice.entities.Compte;
import org.tp.compteservice.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private final CompteRepository compteRepository;

    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("/comptes")
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte getOne(@PathVariable Long id) {
        return compteRepository.findById(id).orElseThrow();
    }

    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@PathVariable Long id, @RequestBody Compte compte) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
