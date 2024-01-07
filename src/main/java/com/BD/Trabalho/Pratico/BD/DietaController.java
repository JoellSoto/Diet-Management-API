package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path= "bd")
public class DietaController {

	DietaService ds;
	DietaController(DietaService ds){
		this.ds=ds;
	}
	
	@GetMapping(path= "getNomeInd/{nome}")
	public List <Object> getNomeIndividuo(@PathVariable("nome") String nome) {
		return 	ds.getNbyName(nome);
	}
	
}
