package com.mircoservice.msformation.proxy;

import java.util.Collection;

import com.mircoservice.msformation.model.Etudiant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-scolarite", url = "localhost:8082")
public interface EtudiantProxy {

    @GetMapping(value = "api/formations/{id}/etudiants")
    public Collection<Etudiant> getEtudiantByIdFormation(@PathVariable("id") Long idf);

}