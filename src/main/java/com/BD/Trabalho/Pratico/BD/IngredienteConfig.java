package com.BD.Trabalho.Pratico.BD;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IngredienteConfig {

	
	
	@Bean
	CommandLineRunner comandLinerRunner(IngredienteRepository repository) {
		
		
		return args ->{ 
			List<Ingrediente> list=new ArrayList<Ingrediente>();
			//list.add(new Ingrediente("Nutricionista"));
			//list.add(new Ingrediente("Outros"));
			
		    //repository.saveAll(list);
		};
	}

}
