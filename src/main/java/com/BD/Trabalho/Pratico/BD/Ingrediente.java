package com.BD.Trabalho.Pratico.BD;

import java.util.List;

import javax.persistence.*;

@Entity
public class Ingrediente {
	
	@Id
	@SequenceGenerator(
			name="Ingrediente_sequence",
			sequenceName="Ingrediente_sequence",
			allocationSize =1
			)
	
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator ="Ingrediente_sequence"
			)
	@Column(name="cod",columnDefinition="NUMBER(7)")
	private int  cod;
	
	@Column(
			name="nome",columnDefinition="VARCHAR2(30)",nullable=false)
	private String nome;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(
			name="descricao",columnDefinition="VARCHAR2(100)",nullable=false)
	private String descricao;
	
	@ManyToMany(mappedBy="ingrediente")
	private List<Refeicao>refeicao;

}
