package com.BD.Trabalho.Pratico.BD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	
	
	FuncionarioRepository fr;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository fr) {
		this.fr=fr;
		
	}
	
	public void addFuncionario() {
		
	}
	
	//public Funcionario getfuncionario(long id
	
	
}
