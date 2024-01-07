package com.BD.Trabalho.Pratico.BD;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository <Hospede,Integer> {
	
	
	@Query(value="Select h from individuo i, hospede h where i.nome=?1 AND i.cod = h.cod_individuo ",nativeQuery=true)
	Hospede findHospedeByNome(String nome);
	
	@Query(value="Select i  from individuo i, hospede h where  i.nome=?1 AND i.cod = h.cod_individuo  ",nativeQuery=true)
	List<Object>findHospedes(String nome);

}
