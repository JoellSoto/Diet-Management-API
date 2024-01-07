package com.BD.Trabalho.Pratico.BD;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IndividuoRepository extends JpaRepository <Individuo,Integer> {
	
	
	Optional<Individuo> findIndividuoByNome(String nome);
}
