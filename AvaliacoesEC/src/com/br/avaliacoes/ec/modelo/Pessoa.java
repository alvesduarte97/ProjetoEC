package com.br.avaliacoes.ec.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa extends BancoEntity<String>{
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "avaliador")
	Set<Avaliacoes> listaAvaliacoes;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private AreaAtuacao area;
	
	@Id
	private String login;
	
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoPessoa getTipo() {
		return tipo;
	}
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	@Override
	public String getChave() {
		// TODO Auto-generated method stub
		return this.login;
	}
	public Set<Avaliacoes> getListaAvaliacoes() {
		return listaAvaliacoes;
	}
	public void setListaAvaliacoes(Set<Avaliacoes> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}
	public AreaAtuacao getArea() {
		return area;
	}
	public void setArea(AreaAtuacao area) {
		this.area = area;
	}

	
}
