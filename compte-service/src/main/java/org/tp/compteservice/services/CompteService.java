package org.tp.compteservice.services;

import org.tp.compteservice.entities.Compte;
import java.util.List;

public interface CompteService {
    List<Compte> listComptes();
    Compte getCompte(Long id);
    Compte saveCompte(Compte compte);
    Compte updateCompte(Long id, Compte compte);
    void deleteCompte(Long id);
}
