package com.BD.Trabalho.Pratico.BD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class IndividuoService {
	
	IndividuoRepository ir;
	Categoria_FuncionarioRepository cfr;
	FuncionarioRepository fr;
	HospedeRepository hs;
	@Autowired
	public IndividuoService(IndividuoRepository ir,Categoria_FuncionarioRepository cfr,FuncionarioRepository fr,HospedeRepository hs) {
		this.ir=ir;
		this.cfr=cfr;
		this.fr=fr;
		this.hs=hs;
	}

	List<Individuo> getIndividuos(){return ir.findAll();}
	Optional<Individuo> getFucionarioByName(String nome){
		
		
		   Optional<Individuo> ind=ir.findIndividuoByNome(nome);
		   
		   if(ind.isPresent())
		       return ind; 
		   throw  new IllegalStateException("Funcionario Nao existe");
		   
			   
		}
	//Hospede getHospedeByName(String nome){return hs.findHospedeByNome(nome);}
	List<Object>getHospedes(String nome){ return hs.findHospedes(nome);}
	List<Object> getNutrcionistas(){
		
		List<Object> list=fr.nutricionistas();
		 
			return list;
		   //js=new JsonFuncionario(dentro.get(0),dentro.get(1),dentro.get(3),dentro.get(4));
			}
	
	Object apagarTudo() {
		//cfr.deleteAll();
		fr.deleteAll();
		hs.deleteAll();
		ir.deleteAll();
		throw  new IllegalStateException("Apagado Tudo com Sucesso");
	}
	Object apagarAlguem(String nome) {
		
		Individuo alguem=ir.findIndividuoByNome(nome).get();
		
		if(alguem.equals(null))
			throw  new IllegalStateException("Nao existe ninguem no Sistema com esse nome");
		else {
			   if(!alguem.getFuncionario().equals(null)) {
				   
				   fr.deleteAll(alguem.getFuncionario());
				   for(int i=0;i<alguem.getFuncionario().size();i++) {
					   cfr.delete(alguem.getFuncionario().get(i).getCategoria()); 
					   
				   }
				   
				   ir.delete(alguem);
			   }
			   
			   if(!alguem.getHospede().equals(null)) {
				   hs.deleteAll(alguem.getHospede());
				   ir.delete(alguem);
			   }
			  
			  
			  throw  new IllegalStateException("Apagado: "+ nome+" com Sucesso");
		}
		 
	}
	
	void addFuncionario(Individuo individuo) {
		   Categoria_Funcionario cfu=new Categoria_Funcionario();
	       Funcionario fu=new Funcionario();
	       List <Funcionario>lfu=new ArrayList<Funcionario>();
		   Optional <Individuo> individuoByNome=ir.findIndividuoByNome(individuo.getNome());
		   Optional <Categoria_Funcionario> categoriaByNome;
		 if(individuoByNome.isPresent())
			 throw  new IllegalStateException("O Nome ja existe");
		 else {
			    
			    
			    if(individuo.getFuncionario()!=null) {
			    	lfu=individuo.getFuncionario();
			    	for(int i=0;i<lfu.size();i++) {
			    		//cfr.save(lfu.get(i).getCategoria());
			    		categoriaByNome=cfr.findCategoria_FuncionarioByNome(lfu.get(i).getCategoria().getNome());
			    		
			    		if(categoriaByNome.isPresent()) {
			    		   cfu=	categoriaByNome.get();
			    		   lfu.get(i).setCategoria(cfu);
			    		   lfu.get(i).setIndividuo(individuo);
			    		   ir.save(individuo);	
					       fr.saveAll(lfu);
			    		}
			    		else
			    			throw  new IllegalStateException("Introduza uma Categoria correcta");
			    		
			    		
			    	}
			    	
			    }
			             			 
		 } 
			 
	}
	
	
	
	void addHospede(Individuo individuo) {
		 Optional <Individuo> individuoByNome=ir.findIndividuoByNome(individuo.getNome());
		 List <Hospede>lh=new ArrayList<Hospede>();
		 if(individuoByNome.isPresent())
			 throw  new IllegalStateException("O Nome ja existe");
		 else
			 {   
			    lh=individuo.getHospede();
			 if(lh!=null) {
				  for(int i=0;i<lh.size();i++) {
					  lh.get(i).setIndividuo(individuo);
					  
				  }
				 ir.save(individuo);
				 hs.saveAll(lh);
				 
			    }
		    }
	}
	
	
	
	

}
