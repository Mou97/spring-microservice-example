package com.microservice.msscolarite.Api;

import java.util.ArrayList;
import java.util.Collection;

import com.microservice.msscolarite.dao.EtudiantRepository;
import com.microservice.msscolarite.entities.Etudiant;
import com.microservice.msscolarite.model.Formation;
import com.microservice.msscolarite.model.Virement;
import com.microservice.msscolarite.proxy.FormationProxy;
import com.microservice.msscolarite.proxy.VirementProxy;

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

    @Autowired
    VirementProxy virementProxy;

    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantWithFornation(@PathVariable("id") Long ide) {
        Etudiant etud = etudiantRepository.findById(ide).get();

        Formation formation = formationProxy.getFormation(etud.getIdFormation());

        Collection<Virement> virements = virementProxy.getVirements(ide);

        etud.setFormation(formation);
        etud.setVirements(virements);

        return etud;
    }

    @GetMapping(value = "/formations/{id}/etudiants")
    public Collection<Etudiant> gEtudiantsByFormation(@PathVariable("id") Long idf) {

        return etudiantRepository.findByIdFormation(idf);
    }

    @GetMapping("/etudiants/info/{id}")
    public Etudiant getInfoScolare(@PathVariable("id") Long ide) {
        Etudiant etud = etudiantRepository.findById(ide).get();

        return etud;
    }

}
