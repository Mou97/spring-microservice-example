package com.microservice.msbourse.model;

import java.util.Date;

import lombok.Data;

@Data
public class InfoScolaire {

    private String nom;
    private Date dateInscription;
    private String promo;
    private Etablissement etablissement;

}