package com.BD.Trabalho.Pratico.BD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Categoria_FuncionarioService {

	Categoria_FuncionarioRepository cfr;
	@Autowired
	public Categoria_FuncionarioService(Categoria_FuncionarioRepository cfr) {
		
		this.cfr=cfr;
	}
	
	
	public void addCategoria(Categoria_Funcionario cf) {
		cfr.save(cf);
	}
	
	
}
