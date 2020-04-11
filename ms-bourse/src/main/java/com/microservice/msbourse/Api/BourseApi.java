package com.microservice.msbourse.Api;

import java.util.Collection;

import com.microservice.msbourse.dao.EtudiantRepostiroy;
import com.microservice.msbourse.dao.VirementRepository;
import com.microservice.msbourse.entities.Virement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BourseApi {

    @Autowired
    VirementRepository virementRepository;

    @Autowired
    EtudiantRepostiroy etudiantRepostiroy;

    @GetMapping("/etudiants/{id}/virements")
    public Collection<Virement> getVirementsByEtudiant(@PathVariable("id") Long ide) {
        return virementRepository.findByEtudiant_idEtudiant(ide);
    }

}