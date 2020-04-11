package com.microservice.msscolarite.proxy;

import java.util.Collection;

import com.microservice.msscolarite.model.Virement;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-bourse", url = "localhost:8080")
public interface VirementProxy {

    @GetMapping(value = "api/etudiants/{id}/virements")
    public Collection<Virement> getVirements(@PathVariable("id") Long idv);

}