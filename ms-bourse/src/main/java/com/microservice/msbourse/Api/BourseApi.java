package com.microservice.msbourse.Api;

import java.util.Collection;

import com.microservice.msbourse.dao.EtudiantRepostiroy;
import com.microservice.msbourse.dao.VirementRepository;
import com.microservice.msbourse.entities.Etudiant;
import com.microservice.msbourse.entities.Virement;
import com.microservice.msbourse.model.InfoScolaire;
import com.microservice.msbourse.proxy.InfoScolaireProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api")
public class BourseApi {

    @Autowired
    VirementRepository virementRepository;

    @Autowired
    EtudiantRepostiroy etudiantRepostiroy;

    @Autowired
    InfoScolaireProxy infoScolaireProxy;

    @GetMapping("/etudiants/{id}/virements")
    public Collection<Virement> getVirementsByEtudiant(@PathVariable("id") Long ide) {
        return virementRepository.findByEtudiant_idEtudiant(ide);
    }

    @GetMapping(value = "/etudiants/{id}/info")
    public Etudiant getInfoEtudiant(@PathVariable("id") Long ide) {
        Etudiant etudiant = etudiantRepostiroy.findById(ide).get();

        // TODO: add personal info from the api of the scolarite service
        InfoScolaire info = infoScolaireProxy.getInfoScolaire(ide);

        etudiant.setInfo(info);

        return etudiant;
    }

}