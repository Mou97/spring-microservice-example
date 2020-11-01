package com.microservice.msscolarite.entities.Projection;

import com.microservice.msscolarite.entities.Etudiant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

// TODO: complete projection to return all students to ms-formation
// cast with heatos 

@Projection(name = "toformation", types = Etudiant.class)
public interface EtudiantProjectionF {
    @Value("#{target.nom}")
    public String getNomEtudiant();

    @Value("#{target.etablissement.nom}")
    public String getNomEtablissement();
}