package com.BD.Trabalho.Pratico.BD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RefeicaoRepository  extends JpaRepository <Refeicao,Integer> {

}
