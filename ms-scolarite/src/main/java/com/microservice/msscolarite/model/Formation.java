package com.microservice.msscolarite.model;

import lombok.Data;

@Data
public class Formation {

    private Long idFormation;
    private String nom;
    private int duree;

}