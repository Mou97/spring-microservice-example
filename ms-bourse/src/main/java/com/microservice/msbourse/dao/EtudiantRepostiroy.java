package com.microservice.msbourse.dao;

import com.microservice.msbourse.entities.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EtudiantRepostiroy extends JpaRepository<Etudiant, Long> {

}