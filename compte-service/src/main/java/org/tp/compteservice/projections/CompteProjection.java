package org.tp.compteservice.projections;

import org.tp.compteservice.entities.Compte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Compte.class)
public interface CompteProjection {
    double getSolde();
}
