package com.microservice.msscolarite;

import java.sql.Date;

import com.microservice.msscolarite.dao.EtablissementRepository;
import com.microservice.msscolarite.dao.EtudiantRepository;
import com.microservice.msscolarite.entities.Etablissement;
import com.microservice.msscolarite.entities.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication implements CommandLineRunner {

	@Autowired
	EtablissementRepository etablissementRepository;

	@Autowired
	EtudiantRepository etudiantRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Etablissement e1 = etablissementRepository.save(new Etablissement(null, "esi-sba", null));
		Etablissement e2 = etablissementRepository.save(new Etablissement(null, "univ-sba", null));

		etudiantRepository
				.save(new Etudiant(null, "malki", Date.valueOf("1999-01-01"), "4isi", null, e1, 1L, null, null));
		etudiantRepository
				.save(new Etudiant(null, "ali", Date.valueOf("1995-08-11"), "4siw", null, e1, 2L, null, null));
		etudiantRepository
				.save(new Etudiant(null, "karim", Date.valueOf("1996-11-22"), "MatserSiC", null, e2, 1L, null, null));
		etudiantRepository
				.save(new Etudiant(null, "fouad", Date.valueOf("2000-02-15"), "MasterSiR", null, e2, 1L, null, null));
	}

}
