package com.microservice.msscolarite.proxy;

import com.microservice.msscolarite.model.Formation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-formation", url = "localhost:8081")
public interface FormationProxy {

    @GetMapping(value = "/formations/{id}")
    public Formation getFormation(@RequestParam("id") Long id);

}
