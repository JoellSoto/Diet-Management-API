package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario,Integer>{

	
	@Query(value="Select  f.cod as codigo,  i.nome as nome, f.salario_base as salario, cf.nome as Categoria from individuo i, funcionario f, Categoria_Funcionario cf where i.cod = f.cod_individuo AND cf.cod = f.cod_categoria ",nativeQuery=true)
	 
	//@Query("select   f.cod,  i.nome, f.salario_base, cf.nome as Categoria from funcionario f inner join i.individuo  AND funcionario f Categoria_Funcionario cf")
	List<Object> nutricionistas();
	
	@Query(value="Select  f.cod as codigo,  i.nome as nome, f.salario_base as salario, cf.nome as Categoria from individuo i, funcionario f, Categoria_Funcionario cf where i.nome=?1 AND i.cod = f.cod_individuo AND cf.cod = f.cod_categoria ",nativeQuery=true)
	List<Object> findFuncionarioByName(String name);
	
	
	
	
}
