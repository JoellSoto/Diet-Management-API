package com.BD.Trabalho.Pratico.BD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="*")
@RestController
@RequestMapping(path= "bd")
public class IndividuoController {
   
	IndividuoService is; 

	@Autowired
	public IndividuoController(IndividuoService is) {
		this.is=is;
		
	}
	
	
	@PostMapping(path="newIndividuo/hospede")
	public void  registerNewHospede(@RequestBody Individuo individuo) {
		is.addHospede(individuo);
	}
	
	@PostMapping(path="newIndividuo/funcionario")
	public void  registerNewFuncionario(@RequestBody Individuo individuo) {
		is.addFuncionario(individuo);
	}
	
	
	
	@GetMapping(path= "getIndividuos")
	public List<Individuo> getIndividuo() {
		return is.getIndividuos();
	}
	
	@GetMapping(path= "getNutricionistas")
	public List<Object> getNutricionistas() {
		return is.getNutrcionistas();
		
	}
	
	@GetMapping(path="ApagarTodos")
	 public Object apagar() {
		return is.apagarTudo();
	}
	
	@GetMapping(path="ApagarAlguem/{nome}")
	public Object apagarAlguem(@PathVariable("nome") String nome) {
		return is.apagarAlguem(nome);
	}
	
	@GetMapping(path= "getFuncionario/{nome}")
	public Optional<Individuo> getFuncionario(@PathVariable("nome") String nome) {
		return is.getFucionarioByName(nome);
	}
	
	/*@GetMapping(path= "getHospede/{nome}")
	public Hospede getHospede(@PathVariable("nome") String nome) {
		return is.getHospedeByName(nome);
	}*/
	
	@GetMapping(path= "getHospedes/{nome}")
	public List<Object> getHospede(@PathVariable("nome") String nome) {
		return is.getHospedes(nome);
	}
	
}

