package com.BD.Trabalho.Pratico.BD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "bd")
public class Categoria_FuncionarioController {

	
	private final Categoria_FuncionarioService cfs;
	
	@Autowired
	public Categoria_FuncionarioController(Categoria_FuncionarioService cfs) {
		this.cfs=cfs;
	}
       
	
	
	@PostMapping(path="newcatFuncionario")
	public void  registerNewCategoria_Funcionario(@RequestBody Categoria_Funcionario cf) {
		  cfs.addCategoria(cf);
	}
	
	
}
