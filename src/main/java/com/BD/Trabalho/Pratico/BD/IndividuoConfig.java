package com.BD.Trabalho.Pratico.BD;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IndividuoConfig {

	
	
	
	@Bean
	CommandLineRunner comandLinerRunnerIndividuo(IndividuoRepository repository) {
		
		
		return args ->{ 
			List<Individuo> list=new ArrayList<Individuo>();
			list.add(new Individuo("Joao Marcelo",LocalDate.of(1986,9,11),"123496289009Q","123,Samuel,Matador"));
			list.add(new Individuo("Antonio Midos",LocalDate.of(1980,12,11),"123451789009Q","123,Samuel,Matador"));
			list.add(new Individuo("Junior Mato",LocalDate.of(1999,12,12),"123456719009Q","123,Samuel,Matador"));
			
			
		    repository.saveAll(list);
		};
	}

}
