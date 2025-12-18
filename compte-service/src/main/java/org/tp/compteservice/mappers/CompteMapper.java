package org.tp.compteservice.mappers;

import org.tp.compteservice.dtos.CompteDTO;
import org.tp.compteservice.entities.Compte;
import org.tp.compteservice.entities.TypeCompte;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteDTO toDTO(Compte compte) {
        CompteDTO dto = new CompteDTO();
        dto.setId(compte.getId());
        dto.setSolde(compte.getSolde());
        dto.setType(compte.getType().name());
        return dto;
    }

    public Compte toEntity(CompteDTO dto) {
        return Compte.builder()
                .id(dto.getId())
                .solde(dto.getSolde())
                .type(TypeCompte.valueOf(dto.getType()))
                .build();
    }
}
