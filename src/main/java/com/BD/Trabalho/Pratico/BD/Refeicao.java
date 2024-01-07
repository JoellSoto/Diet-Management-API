package com.BD.Trabalho.Pratico.BD;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Refeicao {

	
	@Id
	@Column(
			name="cod",columnDefinition="NUMBER(7)")
	private int cod;
	
	@JsonBackReference(value="refe")
	@ManyToOne
	@JoinColumn(name="cod_dieta",nullable=false)
	private Dieta dieta;
	
	
	@Column(name="data",columnDefinition="DATE",nullable=false)
	private Date data;
	
	//@Column(name="time",columnDefinition="Timestamp",nullable=false)
	///private Timestamp time;
	
	
	
	

	public Refeicao(Dieta cDieta, Date data, Timestamp time) {
	
		this.dieta = cDieta;
		this.data = data;
		//this.time = time;
	}
	
	

	public Refeicao() {
		this(null,null,null);
	}



	public Dieta getcDieta() {
		return dieta;
	}

	public void set(Dieta cDieta) {
		this.dieta = cDieta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/*public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}*/
	
	@ManyToMany
	@JoinTable(
			name="Refeicao_Ingrediente",
			joinColumns=@JoinColumn(name="cod_refeicao"),
			inverseJoinColumns=@JoinColumn(name="cod_ingrediente")
			)
	private List<Ingrediente>ingrediente;





	public List<Ingrediente> getIngrediente() {
		return ingrediente;
	}



	public void setIngrediente(List<Ingrediente> ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	
}
