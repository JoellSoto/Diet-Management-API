package com.BD.Trabalho.Pratico.BD;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface Categoria_FuncionarioRepository  extends JpaRepository <Categoria_Funcionario,Integer>{

	
	//@Query("Select s from Categoria_Funcionario s Where s.nome =  ?1")
	Optional <Categoria_Funcionario> findCategoria_FuncionarioByNome(String nome);
}
