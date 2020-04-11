package com.microservice.msbourse.dao;

import com.microservice.msbourse.entities.Virement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VirementRepository extends JpaRepository<Virement, Long> {

}