package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaRepository extends JpaRepository <Dieta,Integer>  {

	
	@Query(value="SELECT Individuo.nome FROM Individuo, Funcionario, Dieta,Categoria_Dieta WHERE Dieta.cod_categoria =Categoria_Dieta.cod AND Categoria_Dieta.nome = ?1 AND Dieta.cod_nutricionista = Funcionario.cod AND Funcionario.cod_individuo =  Individuo.cod",nativeQuery=true)
	List<Object> findNutricinistaDieta(String nome);
	
	
	
	
}
