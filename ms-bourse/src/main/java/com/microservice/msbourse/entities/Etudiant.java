package com.microservice.msbourse.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.microservice.msbourse.model.InfoScolaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    private Long idEtudiant;

    private Long nComptCCP;

    private Float salaireParent;

    private Boolean situationImpot;

    // @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    private Collection<Virement> virements;

    @Transient
    private InfoScolaire info;
}