package com.BD.Trabalho.Pratico.BD;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Categoria_FuncionarioConfig {
	
	@Bean
	CommandLineRunner comandLinerRunnerCat_Fun(Categoria_FuncionarioRepository repository) {
		
		
		return args ->{ 
			List<Categoria_Funcionario> list=new ArrayList<Categoria_Funcionario>();
			list.add(new Categoria_Funcionario("Nutricionista"));
			list.add(new Categoria_Funcionario("Outros"));
			
		    repository.saveAll(list);
		};
	}


}
