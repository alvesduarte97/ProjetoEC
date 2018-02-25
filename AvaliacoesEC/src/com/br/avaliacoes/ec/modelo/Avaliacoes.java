package com.br.avaliacoes.ec.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avaliacoes")
public class Avaliacoes extends BancoEntity<Integer>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAvaliacao;
	
	@ManyToOne
	@JoinColumn(name = "avaliador")
	private Pessoa avaliador;
	
	@ManyToOne
	@JoinColumn(name = "grupoavaliado")
	private Grupo grupoAvaliado;
	
	@ManyToOne
	@JoinColumn(name = "desafio")
	private Desafios Desafio;
	
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private double nota5;
	
	private String comentario;

	
	@Override
	public Integer getChave() {
		return this.idAvaliacao;
	}
	public int getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Desafios getDesafio() {
		return Desafio;
	}
	public void setDesafio(Desafios desafio) {
		Desafio = desafio;
	}
	public Pessoa getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(Pessoa avaliador) {
		this.avaliador = avaliador;
	}
	public Grupo getGrupoAvaliado() {
		return grupoAvaliado;
	}
	public void setGrupoAvaliado(Grupo grupoAvaliado) {
		this.grupoAvaliado = grupoAvaliado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getNota4() {
		return nota4;
	}
	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	public double getNota5() {
		return nota5;
	}
	public void setNota5(double nota5) {
		this.nota5 = nota5;
	}


	
}
