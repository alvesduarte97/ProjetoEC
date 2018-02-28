package com.br.avaliacoes.ec.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="desafios")
public class Desafios extends BancoEntity<String> {
	@Id
	private String nome;
	
	private String dataInicio;
	private String dataFim;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "Desafio")
	Set<Avaliacoes> listaAvaliacoes;
	
	@Enumerated(EnumType.STRING)
	private StatusDesafio status;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public Set<Avaliacoes> getListaAvaliacoes() {
		return listaAvaliacoes;
	}
	public void setListaAvaliacoes(Set<Avaliacoes> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}
	@Override
	public String getChave() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	public StatusDesafio getStatus() {
		return status;
	}
	public void setStatus(StatusDesafio status) {
		this.status = status;
	}
}
