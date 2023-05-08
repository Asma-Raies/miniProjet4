package com.asma.makeUp;

//import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.asma.makeUp.entities.MakeUp;
//import com.asma.makeUp.entities.MakeUp;
import com.asma.makeUp.service.MakeUpService;

@SpringBootApplication
public class MakeUppApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	MakeUpService makeUpService;
	public static void main(String[] args) {
	SpringApplication.run(MakeUppApplication.class, args);
	}
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(MakeUp.class);
	}


}
