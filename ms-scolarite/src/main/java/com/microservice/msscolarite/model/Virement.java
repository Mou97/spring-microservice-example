package com.microservice.msscolarite.model;

import java.util.Date;

import lombok.Data;

@Data
public class Virement {

    private Long idVirement;
    private int nCompteCCP;
    private Date dateVirement;

}