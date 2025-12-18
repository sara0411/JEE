package org.tp.compteservice.services;

import org.tp.compteservice.entities.Compte;
import org.tp.compteservice.repositories.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServiceImpl implements CompteService {
    private final CompteRepository compteRepository;

    public CompteServiceImpl(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public List<Compte> listComptes() {
        return compteRepository.findAll();
    }

    @Override
    public Compte getCompte(Long id) {
        return compteRepository.findById(id).orElseThrow();
    }

    @Override
    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Compte updateCompte(Long id, Compte compte) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
