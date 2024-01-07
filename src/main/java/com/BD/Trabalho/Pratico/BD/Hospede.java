package com.BD.Trabalho.Pratico.BD;


import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Hospede {

	@Id
	@SequenceGenerator(
			name="Hospede_sequence",
			sequenceName="Hospede_sequence",
			allocationSize =1
			)
	
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator ="Hospede_sequence"
			)
	@Column(name="cod",columnDefinition="NUMBER(7)")
	private int  cod;
	
	
	@JsonBackReference(value="hosp")
	@ManyToOne
	@JoinColumn(name="cod_individuo")
	private Individuo individuo;
	
	public Individuo individuo() {
		return individuo;
	}

	
	@OneToMany(mappedBy="hospede")
	private List<Dieta> dieta;
	

	public List<Dieta> getDieta() {
		return dieta;
	}


	public void setDieta(List<Dieta> dieta) {
		this.dieta = dieta;
	}


	public void setCod_individuo(Individuo individuo) {
		this.individuo =individuo;
	}


	@Column(
			name="data_chegada",columnDefinition="DATE",nullable=false)
	private Date data_chegada;
	
	@Column(
			name="data_partida",columnDefinition="DATE",nullable=false)
	private Date data_partida;
	
	
	
	

	public Hospede(Individuo individuo, Date data_chegada, Date data_partida) {
		this.individuo = individuo;
		this.data_chegada = data_chegada;
		this.data_partida = data_partida;
	}
    
	
	public Hospede() {
		this(null,null,null);
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}

	public Individuo getindividuo() {
		return individuo;
	}

	public void setIndividuo(Individuo individuo) {
		this.individuo = individuo;
	}

	public Date getData_chegada() {
		return data_chegada;
	}

	public void setData_chegada(Date data_chegada) {
		this.data_chegada = data_chegada;
	}

	public Date getData_partida() {
		return data_partida;
	}

	public void setData_partida(Date data_partida) {
		this.data_partida = data_partida;
	}


	@Transient
	public String toString() {
		return "{ cod:" + cod + ", individuo:" + individuo + ", data_chegada:" + data_chegada + ", data_partida:"
				+ data_partida + "}";
	}
	
	
	
	
}
