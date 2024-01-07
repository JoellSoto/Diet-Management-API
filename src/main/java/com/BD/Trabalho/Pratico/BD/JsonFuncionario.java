package com.BD.Trabalho.Pratico.BD;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class JsonFuncionario {

	
	@Id
	private int cod_funcionario;
	private  String nome ;
	private float salario;
	private  String Categoria ;
	
	
	
	
	public JsonFuncionario(int cod_funcionario,String nome, String categoria, float salario) {
		
		this.cod_funcionario=cod_funcionario;
		this.nome = nome;
		Categoria = categoria;
		this.salario = salario;
	}
	public int getCod_funcionario() {
		return cod_funcionario;
	}
	public void setCod_funcionario(int cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
}
