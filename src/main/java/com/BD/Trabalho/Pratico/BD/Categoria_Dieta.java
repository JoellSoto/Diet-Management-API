package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import javax.persistence.*;

@Entity
public class Categoria_Dieta {

	
	
	@Id
	@Column(name="cod",columnDefinition="NUMBER(7)", insertable=false,updatable=false)
	private int  cod;
	
	public List<Dieta> getDieta() {
		return dieta;
	}


	public void setDieta(List<Dieta> dieta) {
		this.dieta = dieta;
	}

	@Column(
			name="nome",columnDefinition="VARCHAR2(15)",nullable=false,unique=true)
	private String nome;
   
	
	@OneToMany(mappedBy="cDieta")
	private List<Dieta> dieta;
	
	
	
	public Categoria_Dieta(String nome) {
		
		this.nome = nome;
	}
	
	
	public Categoria_Dieta() {
		this("");
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
