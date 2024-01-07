package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Funcionario {
	@Id
	@Column(
			name="cod",columnDefinition="NUMBER(7)")
	private int cod;
	
	
	@JsonBackReference(value="ind")
	@ManyToOne
	@JoinColumn(name="cod_individuo",nullable=false,unique=false)
	private Individuo individuo;
	
	
	@JsonBackReference(value="cat")
	@ManyToOne
	@JoinColumn(name="cod_categoria",nullable=false,unique=false)
	private Categoria_Funcionario categoria;
	
	@OneToMany(mappedBy="funcionario")
	  private List<Dieta> dieta;
	
	@Column(
			name="salario_base",columnDefinition="NUMBER(12,2)",nullable=false)
	private float salario_base;

	
	
	
	
	public Funcionario(Individuo individuo, Categoria_Funcionario categoria, float salario_base) {
		this.individuo = individuo;
		this.categoria = categoria;
		this.salario_base = salario_base;
	}

	public Funcionario() {
		this(null,null,0);
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Individuo getIndividuo() {
		return individuo;
	}

	public void setIndividuo(Individuo individuo) {
		this.individuo = individuo;
	}

	public Categoria_Funcionario getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria_Funcionario cod_categoria) {
		this.categoria = cod_categoria;
	}

	public float getSalario_base() {
		return salario_base;
	}

	public void setSalario_base(float salario_base) {
		this.salario_base = salario_base;
	}

	public List<Dieta> getDieta() {
		return dieta;
	}

	public void setDieta(List<Dieta> dieta) {
		this.dieta = dieta;
	}
	
	

}
