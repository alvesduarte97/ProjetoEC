package com.br.avaliacoes.ec.fachada;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.Regiao;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

public interface IFachada {

	void inserirPessoa(Pessoa pessoa) throws BancoException;
	Pessoa procurarPessoa(String login) throws BancoException;
    void atualizarPessoa(Pessoa pessoa) throws BancoException;
	void removerPessoa(String login) throws BancoException;
	List<Pessoa> listaPessoas(TipoPessoa tipoPessoa);
	Desafios desafioAtivo();
	
	void inserirDesafios(Desafios desafio) throws BancoException;
    Desafios procurarDesafios(String nome) throws BancoException;
    void atualizarDesafios(Desafios desafio) throws BancoException;
	void removerDesafios(String nome) throws BancoException;
	List<Desafios> listaDesafios();
	List<Desafios> listaDesafiosAvaliados();
	
	void inserirGrupo(Grupo grupo) throws BancoException;
	Grupo procurarGrupo(Integer idGrupo) throws BancoException;
    void atualizarGrupo(Grupo grupo) throws BancoException;
	void removerGrupo(Integer idGrupo) throws BancoException;
	List<Grupo> listaGrupos();
	List<Grupo> listaGruposPorSerie(String serie, String desafioAtivo) throws BancoException;
	
	void inserirAvaliacoes(Avaliacoes avaliacao) throws BancoException;
	Avaliacoes procurarAvaliacoes(Integer idAvaliacao) throws BancoException;
    void atualizarAvaliacoes(Avaliacoes avaliacao) throws BancoException;
	void removerAvaliacoes(Integer idAvaliacao) throws BancoException;
	List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException;
	void gerarExcelAvaliacoes(Desafios desafio) throws FileNotFoundException, IOException;
	List<Avaliacoes> listaAvaliacoesOrdemDct();
}
