package com.br.avaliacoes.ec.fachada;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.br.avaliacoes.ec.DAO.AvaliacoesDAOImp;
import com.br.avaliacoes.ec.DAO.DesafiosDAOImp;
import com.br.avaliacoes.ec.DAO.GrupoDAOImp;
import com.br.avaliacoes.ec.DAO.IAvaliacoesDAO;
import com.br.avaliacoes.ec.DAO.IDesafiosDAO;
import com.br.avaliacoes.ec.DAO.IGrupoDAO;
import com.br.avaliacoes.ec.DAO.IPessoaDAO;
import com.br.avaliacoes.ec.DAO.PessoaDAOImp;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.Regiao;
import com.br.avaliacoes.ec.modelo.TipoPessoa;
import com.br.avaliacoes.ec.negocio.AvaliacoesBOImp;
import com.br.avaliacoes.ec.negocio.DesafioBOImp;
import com.br.avaliacoes.ec.negocio.GrupoBOImp;
import com.br.avaliacoes.ec.negocio.IAvaliacoesBO;
import com.br.avaliacoes.ec.negocio.IDesafioBO;
import com.br.avaliacoes.ec.negocio.IGrupoBO;
import com.br.avaliacoes.ec.negocio.IPessoaBO;
import com.br.avaliacoes.ec.negocio.PessoaBOImp;
import com.br.avaliacoes.ec.servidor.IServidor;
import com.br.avaliacoes.ec.servidor.ServidorImp;

public class FachadaImp implements IFachada {
//	private IPessoaBO negocioPessoa;
//	private IDesafioBO negocioDesafio;
//	private IGrupoBO negocioGrupo;
//	private IAvaliacoesBO negocioAvaliacao;
	IServidor server;

	private static FachadaImp instanciaFachada;

	public static FachadaImp getInstanciaFachada(IServidor meuServidor) {
		
		if (instanciaFachada == null) {
			instanciaFachada = new FachadaImp(meuServidor);
		}

		return instanciaFachada;
	}

	private FachadaImp(IServidor meuServidor) {
//		IPessoaDAO repositorioPessoa = new PessoaDAOImp();
//		IDesafiosDAO repositorioDesafio = new DesafiosDAOImp();
//		IGrupoDAO repositoriooGrupo = new GrupoDAOImp();
//		IAvaliacoesDAO repositorioAvaliacao = new AvaliacoesDAOImp();
//
//		negocioPessoa = new PessoaBOImp(repositorioPessoa);
//		negocioGrupo = new GrupoBOImp(repositoriooGrupo);
//		negocioDesafio = new DesafioBOImp(repositorioDesafio);
//		negocioAvaliacao = new AvaliacoesBOImp(repositorioAvaliacao);
		server = meuServidor;

	}

	@Override
	public void inserirPessoa(Pessoa pessoa) throws BancoException {
//		negocioPessoa.inserir(pessoa);
		server.inserirPessoa(pessoa);
		
	}

	@Override
	public Pessoa procurarPessoa(String login) throws BancoException {
//		return negocioPessoa.procurar(login);
		return server.procurarPessoa(login);
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) throws BancoException {
//		negocioPessoa.atualizar(pessoa);
		server.atualizarPessoa(pessoa);
	}

	@Override
	public void removerPessoa(String login) throws BancoException {
//		negocioPessoa.remover(login);
		server.removerPessoa(login);
	}

	@Override
	public void inserirDesafios(Desafios desafio) throws BancoException {
//		negocioDesafio.inserir(desafio);
		server.inserirDesafios(desafio);
	}

	@Override
	public Desafios procurarDesafios(String nome) throws BancoException {
//		return negocioDesafio.procurar(nome);
		return server.procurarDesafios(nome);
	}

	@Override
	public void atualizarDesafios(Desafios desafio) throws BancoException {
//		negocioDesafio.atualizar(desafio);
		server.atualizarDesafios(desafio);
	}

	@Override
	public void removerDesafios(String nome) throws BancoException {
//		negocioDesafio.remover(nome);
		server.removerDesafios(nome);
	}

	@Override
	public void inserirGrupo(Grupo grupo) throws BancoException {
//		negocioGrupo.inserir(grupo);
		server.inserirGrupo(grupo);
	}

	@Override
	public Grupo procurarGrupo(Integer idGrupo) throws BancoException {
//		return negocioGrupo.procurar(idGrupo);
		return server.procurarGrupo(idGrupo);
	}

	@Override
	public void atualizarGrupo(Grupo grupo) throws BancoException {
//		negocioGrupo.atualizar(grupo);
		server.atualizarGrupo(grupo);
	}

	@Override
	public void removerGrupo(Integer idGrupo) throws BancoException {
//		negocioGrupo.remover(idGrupo);
		server.removerGrupo(idGrupo);
	}

	@Override
	public void inserirAvaliacoes(Avaliacoes avaliacao) throws BancoException {
//		negocioAvaliacao.inserir(avaliacao);
		server.atualizarAvaliacoes(avaliacao);
	}

	@Override
	public Avaliacoes procurarAvaliacoes(Integer idAvaliacao) throws BancoException {
//		return negocioAvaliacao.procurar(idAvaliacao);
		return server.procurarAvaliacoes(idAvaliacao);
	}

	@Override
	public void atualizarAvaliacoes(Avaliacoes avaliacao) throws BancoException {
//		negocioAvaliacao.atualizar(avaliacao);
		server.atualizarAvaliacoes(avaliacao);
	}

	@Override
	public void removerAvaliacoes(Integer idAvaliacao) throws BancoException {
//		negocioAvaliacao.remover(idAvaliacao);
		server.removerAvaliacoes(idAvaliacao);
	}

	@Override
	public List<Pessoa> listaPessoas(TipoPessoa tipoPessoa) {
//		return negocioPessoa.listaPessoa(tipoPessoa);
		return server.listaPessoas(tipoPessoa);
	}

	@Override
	public List<Grupo> listaGrupos() {
//		return negocioGrupo.listaGrupos();
		return server.listaGrupos();
	}

	@Override
	public List<Desafios> listaDesafios() {
//		return negocioDesafio.listaDesafios();
		return server.listaDesafios();
	}

	@Override
	public List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException{
//		return negocioAvaliacao.listaAvaliacoesPorAvaliador(pessoa);
		return server.listaAvaliacoesPorAvaliador(pessoa);
	}

	@Override
	public Desafios desafioAtivo() {
//		Desafios desafio = negocioDesafio.desafioAtivo();
//		if (desafio != null)
//			return desafio;
//		return null;
		return server.desafioAtivo();
	}

	@Override
	public List<Grupo> listaGruposPorSerie(String serie, String desafioAtivo) throws BancoException {
//		return negocioGrupo.listaGruposPorSerie(serie, desafioAtivo);
		return server.listaGruposPorSerie(serie, desafioAtivo);
	}

	@Override
	public void gerarExcelAvaliacoes(Desafios desafio) throws FileNotFoundException, IOException {
//		negocioAvaliacao.gerarExcelAvaliacoes(desafio);
		server.gerarExcelAvaliacoes(desafio);
	}

	@Override
	public List<Desafios> listaDesafiosAvaliados() {
//		return negocioDesafio.listaDesafiosAvaliados();
		return server.listaDesafios();
	}

	@Override
	public List<Avaliacoes> listaAvaliacoesOrdemDct() {
//		return negocioAvaliacao.listaAvaliacoesOrdemDct();
		return server.listaAvaliacoesOrdemDct();
	}

}
