package com.BD.Trabalho.Pratico.BD;


import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Individuo {

	
	//DateFormat dateFormat = new SimpleDateFormat("dd/mmm/yyyy");
	@Id
	@SequenceGenerator(
			name="Individuo_sequence",
			sequenceName="Individuo_sequence",
			allocationSize =1
			)
	
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator ="Individuo_sequence"
			)
	@Column(
			name="cod",columnDefinition="NUMBER(7)")
	private int cod;
	
	
	@Column(
			name="nome",columnDefinition="VARCHAR2(30)",nullable=false,unique=true)
	private String nome;
	
	@Column(
			name="data_nascimento",columnDefinition="DATE",nullable=false)
	private LocalDate data_nascimento;
	
	@Column(
			name="numero_BI",columnDefinition="VARCHAR2(25)",nullable=false)
	private String numero_BI;
	
	@Column(
			name="morada",columnDefinition="VARCHAR2(50)",nullable=false)
	private String morada;
	
	
	public Individuo(String nome, LocalDate data_nascimento, String numero_BI, String morada) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.numero_BI = numero_BI;
		this.morada = morada;
	}
	
	//new SimpleDateFormat("yyyy-MM-dd").parse(""+LocalDate.now()

	@JsonManagedReference(value="hosp")
	@OneToMany(mappedBy="individuo")
	private List<Hospede> hospede;

	public List<Hospede> getHospede() {
		return hospede;
	}
	
	public void setHospede(List<Hospede> hospede) {
		this.hospede = hospede;
	}
	
	@JsonManagedReference(value="ind")
	@OneToMany(mappedBy="individuo", fetch=FetchType.EAGER)
	private List<Funcionario> funcionario;

	public List<Funcionario> getFuncionario() {
		return funcionario;}
	
	
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	



	public Individuo()  {
	
		 
		this("",null ,"","");
        		
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

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNumero_BI() {
		return numero_BI;
	}

	public void setNumero_BI(String numero_BI) {
		this.numero_BI = numero_BI;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	@Override
	@Transient
	public String toString() {
		return "{cod:" + cod + ", nome:" + nome + ", data_nascimento:" + data_nascimento + ", numero_BI:"
				+ numero_BI + ", morada:" + morada + ", hospede:" + hospede +"}";
	}
    

	
	
}

