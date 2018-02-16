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
	
	private Date dataInicio;
	private Date dataFim;
	
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
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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
