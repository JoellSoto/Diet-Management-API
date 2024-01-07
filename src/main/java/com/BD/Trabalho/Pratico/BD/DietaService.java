package com.BD.Trabalho.Pratico.BD;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietaService {

	
	DietaRepository dr;
	Categoria_DietaRepository cdr;
	HospedeRepository hs;
	RefeicaoRepository rr;
	@Autowired
	DietaService(DietaRepository dr,Categoria_DietaRepository cdr,HospedeRepository hs,RefeicaoRepository rr){
		this.dr=dr;
		this.cdr=cdr;
		this.hs=hs;
		this.rr=rr;
	}
	
	public List <Object> getNbyName(String nome){ return  dr.findNutricinistaDieta(nome);}
	
	public void addDieta(Dieta d) {
		Hospede h = null;
		Funcionario f;
		Categoria_Dieta cd=new Categoria_Dieta();
		List <Refeicao>cdl=new ArrayList<Refeicao>();
		
		if(d.getHospede()!=null) {
			
			h=d.getHospede();
		
		}
			
		if(d.getFuncionario()!=null)
		   f=d.getFuncionario();
		
	       cd=d.getcDieta();
	       
	      for(int i=0;i<d.getRefeicao().size();i++) {
	    	  cdl=d.getRefeicao();
	    	  cdl.get(i).set(d);  
	      } 
	      
	      //nao funciona funcionario
	      if(hs.findHospedeByNome(h.getindividuo().getNome()).equals(null))
	    	  hs.save(h);
	      d.setHospede((Hospede)hs.findHospedeByNome(h.getindividuo().getNome()));
	      rr.saveAll(cdl);
	      dr.save(d);
		 
		
		
		
		
		
	}
}
