package com.microservice.msbourse;

import java.sql.Date;
import java.util.Collection;

import com.microservice.msbourse.dao.EtudiantRepostiroy;
import com.microservice.msbourse.dao.VirementRepository;
import com.microservice.msbourse.entities.Etudiant;
import com.microservice.msbourse.entities.Virement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication implements CommandLineRunner {

	@Autowired
	EtudiantRepostiroy etudiantRepostiroy;

	@Autowired
	VirementRepository virementRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Etudiant etud1 = etudiantRepostiroy.save(new Etudiant(1l, (long) 122, 500.79f, false, null, null));
		Etudiant etud2 = etudiantRepostiroy.save(new Etudiant(2l, (long) 433, 800.33f, false, null, null));

		virementRepository.save(new Virement(null, 130.45f, Date.valueOf("2019-01-31"), etud1));
		virementRepository.save(new Virement(null, 894.96f, Date.valueOf("2019-05-18"), etud1));
		virementRepository.save(new Virement(null, 500.55f, Date.valueOf("2020-02-15"), etud2));
		virementRepository.save(new Virement(null, 300.84f, Date.valueOf("2020-03-12"), etud2));

	}

}
