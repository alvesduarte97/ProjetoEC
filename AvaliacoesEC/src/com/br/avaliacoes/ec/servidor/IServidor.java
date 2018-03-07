package com.br.avaliacoes.ec.servidor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

public interface IServidor extends Remote {
	
	void inserirPessoa(Pessoa pessoa) throws BancoException, RemoteException;
	Pessoa procurarPessoa(String login) throws BancoException,RemoteException;
    void atualizarPessoa(Pessoa pessoa) throws BancoException,RemoteException;
	void removerPessoa(String login) throws BancoException,RemoteException;
	List<Pessoa> listaPessoas(TipoPessoa tipoPessoa) throws RemoteException;
	
	
	void inserirDesafios(Desafios desafio) throws BancoException, RemoteException;
    Desafios procurarDesafios(String nome) throws BancoException, RemoteException;
    void atualizarDesafios(Desafios desafio) throws BancoException, RemoteException;
	void removerDesafios(String nome) throws BancoException,RemoteException;
	List<Desafios> listaDesafios()throws RemoteException;
	List<Desafios> listaDesafiosAvaliados()throws RemoteException;
	Desafios desafioAtivo()throws RemoteException;
	
	void inserirGrupo(Grupo grupo) throws BancoException, RemoteException;
	Grupo procurarGrupo(Integer idGrupo) throws BancoException, RemoteException;
    void atualizarGrupo(Grupo grupo) throws BancoException, RemoteException;
	void removerGrupo(Integer idGrupo) throws BancoException, RemoteException;
	List<Grupo> listaGrupos()throws RemoteException;
	List<Grupo> listaGruposPorSerie(String serie, String desafioAtivo) throws BancoException, RemoteException;
	
	void inserirAvaliacoes(Avaliacoes avaliacao) throws BancoException, RemoteException;
	Avaliacoes procurarAvaliacoes(Integer idAvaliacao) throws BancoException, RemoteException;
    void atualizarAvaliacoes(Avaliacoes avaliacao) throws BancoException, RemoteException;
	void removerAvaliacoes(Integer idAvaliacao) throws BancoException, RemoteException;
	List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException, RemoteException;
	void gerarExcelAvaliacoes(Desafios desafio) throws FileNotFoundException, IOException, RemoteException;
	List<Avaliacoes> listaAvaliacoesOrdemDct()throws RemoteException, RemoteException;

}
