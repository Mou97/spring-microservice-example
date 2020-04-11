package com.mircoservice.msformation;

import com.mircoservice.msformation.dao.FormationRepository;
import com.mircoservice.msformation.Entities.Formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	FormationRepository formationRepository;

	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Formation.class);

		Formation f1 = formationRepository.save(new Formation(null, "Java", 30));
		Formation f2 = formationRepository.save(new Formation(null, "Angular", 40));

	}
}