package com.mircoservice.msformation.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import com.mircoservice.msformation.Entities.Formation;
import com.mircoservice.msformation.dao.FormationRepository;
import com.mircoservice.msformation.model.Etudiant;
import com.mircoservice.msformation.proxy.EtudiantProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api")
public class FormationApi {

    @Autowired
    EtudiantProxy etudiantProxy;

    @Autowired
    FormationRepository formationRepository;

    @GetMapping(value = "formations/{id}/etudiants")
    public Formation getEtudiantsByFormation(@PathVariable("id") Long idf) {
        Formation formation = formationRepository.findById(idf).get();
        Collection<Etudiant> etudiants = etudiantProxy.getEtudiantByIdFormation(idf);

        formation.setEtudiants(etudiants);

        return formation;
    }

}