package com.microservice.msscolarite.Api;

import com.microservice.msscolarite.dao.EtudiantRepository;
import com.microservice.msscolarite.entities.Etudiant;
import com.microservice.msscolarite.model.Formation;
import com.microservice.msscolarite.proxy.FormationProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ScolartieApi {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    FormationProxy formationProxy;

    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantWithFornation(@PathVariable("id") Long ide) {
        Etudiant etud = etudiantRepository.findById(ide).get();

        Formation formation = formationProxy.getFormation(etud.getIdFormation());

        etud.setFormation(formation);

        return etud;
    }

}