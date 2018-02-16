package com.br.avaliacoes.ec.fachada;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;

public interface IFachada {

	void inserirPessoa(Pessoa pessoa) throws BancoException;
	Pessoa procurarPessoa(String login) throws BancoException;
    void atualizarPessoa(Pessoa pessoa) throws BancoException;
	void removerPessoa(String login) throws BancoException;
	
	void inserirDesafios(Desafios desafio) throws BancoException;
    Desafios procurarDesafios(String nome) throws BancoException;
    void atualizarDesafios(Desafios desafio) throws BancoException;
	void removerDesafios(String nome) throws BancoException;
	
	void inserirGrupo(Grupo grupo) throws BancoException;
	Grupo procurarGrupo(Integer idGrupo) throws BancoException;
    void atualizarGrupo(Grupo grupo) throws BancoException;
	void removerGrupo(Integer idGrupo) throws BancoException;
	
	void inserirAvaliacoes(Avaliacoes avaliacao) throws BancoException;
	Avaliacoes procurarAvaliacoes(Integer idAvaliacao) throws BancoException;
    void atualizarAvaliacoes(Avaliacoes avaliacao) throws BancoException;
	void removerAvaliacoes(Integer idAvaliacao) throws BancoException;
}
