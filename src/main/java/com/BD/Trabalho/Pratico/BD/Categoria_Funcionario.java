package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categoria_Funcionario {

	@Id
	@SequenceGenerator(
			name="Categoria_Funcionario_sequence",
			sequenceName="Categoria_Funcionario_sequence",
			allocationSize =1
			)
	
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator ="Categoria_Funcionario_sequence"
			)
	@Column(name="cod",columnDefinition="NUMBER(7)")
	private int  cod;
	
	@Column(
			name="nome",columnDefinition="VARCHAR2(15)",nullable=false,unique=false)
	private String nome;
	
	
	
	

	public Categoria_Funcionario(String nome) {
		this.nome = nome;
	}
	
	
	public Categoria_Funcionario() {
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
	
	@JsonManagedReference(value="cat")
	@OneToMany(mappedBy="categoria")
	private List<Funcionario> funcionario;

	public List<Funcionario> getFuncionario() {
		return funcionario;}
	
	
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
