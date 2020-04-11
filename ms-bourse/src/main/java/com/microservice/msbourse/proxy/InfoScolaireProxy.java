package com.microservice.msbourse.proxy;

import com.microservice.msbourse.model.InfoScolaire;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-scolarite", url = "localhost:8082")
public interface InfoScolaireProxy {

    @GetMapping(value = "/api/etudiants/info/{id}")
    public InfoScolaire getInfoScolaire(@PathVariable("id") Long ide);

}