package com.microservice.msscolarite.dao;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

import com.microservice.msscolarite.entities.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Collection<Etudiant> findByIdFormation(Long idFormation);

}