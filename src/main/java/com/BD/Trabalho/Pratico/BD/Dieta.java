package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Dieta {
	
	
	@Id
	@Column(
			name="cod",columnDefinition="NUMBER(7)")
	private int cod;
	
	
	@JsonManagedReference(value="refe")
	@OneToMany(mappedBy="dieta")
	private List<Refeicao> refeicao;
	
	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public List<Refeicao> getRefeicao() {
		return refeicao;
	}


	public void setRefeicao(List<Refeicao> refeicao) {
		this.refeicao = refeicao;
	}


	@ManyToOne
	@JoinColumn(name="cod_hospede",nullable=false)
	private Hospede hospede;
	
	@ManyToOne
	@JoinColumn(name="cod_categoria",nullable=false)
	private Categoria_Dieta cDieta;
	
	
	@ManyToOne
	@JoinColumn(name="cod_nutricionista",nullable=false)
	private Funcionario  funcionario;


	public Dieta(Hospede hospede, Categoria_Dieta cDieta, Funcionario funcionario) {
		this.hospede = hospede;
		this.cDieta = cDieta;
		this.funcionario = funcionario;
	}


	public Dieta() {
		this(null,null,null);
	}


	public Hospede getHospede() {
		return hospede;
	}


	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}


	public Categoria_Dieta getcDieta() {
		return cDieta;
	}


	public void setcDieta(Categoria_Dieta cDieta) {
		this.cDieta = cDieta;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	

}
