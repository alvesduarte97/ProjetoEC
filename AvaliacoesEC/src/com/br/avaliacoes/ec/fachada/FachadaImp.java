package com.br.avaliacoes.ec.fachada;

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
import com.br.avaliacoes.ec.modelo.TipoPessoa;
import com.br.avaliacoes.ec.negocio.AvaliacoesBOImp;
import com.br.avaliacoes.ec.negocio.DesafioBOImp;
import com.br.avaliacoes.ec.negocio.GrupoBOImp;
import com.br.avaliacoes.ec.negocio.IAvaliacoesBO;
import com.br.avaliacoes.ec.negocio.IDesafioBO;
import com.br.avaliacoes.ec.negocio.IGrupoBO;
import com.br.avaliacoes.ec.negocio.IPessoaBO;
import com.br.avaliacoes.ec.negocio.PessoaBOImp;

public class FachadaImp implements IFachada{
	private IPessoaBO negocioPessoa;
	private IDesafioBO negocioDesafio;
	private IGrupoBO negocioGrupo;
	private IAvaliacoesBO negocioAvaliacao;
	
	private static FachadaImp instanciaFachada;
	
	public static FachadaImp getInstanciaFachada() {
		if(instanciaFachada == null) {
			instanciaFachada = new FachadaImp();
		}
		
		return instanciaFachada;
	}
	
	private FachadaImp() {
		IPessoaDAO repositorioPessoa = new PessoaDAOImp();
		IDesafiosDAO repositorioDesafio = new DesafiosDAOImp();
		IGrupoDAO repositoriooGrupo = new GrupoDAOImp();
		IAvaliacoesDAO repositorioAvaliacao = new AvaliacoesDAOImp();
		
		negocioPessoa = new PessoaBOImp(repositorioPessoa);
		negocioGrupo = new GrupoBOImp(repositoriooGrupo);
		negocioDesafio = new DesafioBOImp(repositorioDesafio);
		negocioAvaliacao = new AvaliacoesBOImp(repositorioAvaliacao);
	
	}

	@Override
	public void inserirPessoa(Pessoa pessoa) throws BancoException {
		negocioPessoa.inserir(pessoa);
	}

	@Override
	public Pessoa procurarPessoa(String login) throws BancoException {
		return negocioPessoa.procurar(login);
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) throws BancoException {
		negocioPessoa.atualizar(pessoa);
	}

	@Override
	public void removerPessoa(String login) throws BancoException {
		negocioPessoa.remover(login);
	}

	@Override
	public void inserirDesafios(Desafios desafio) throws BancoException {
		negocioDesafio.inserir(desafio);
	}

	@Override
	public Desafios procurarDesafios(String nome) throws BancoException {
		return negocioDesafio.procurar(nome);
	}

	@Override
	public void atualizarDesafios(Desafios desafio) throws BancoException {
		negocioDesafio.atualizar(desafio);
	}

	@Override
	public void removerDesafios(String nome) throws BancoException {
		negocioDesafio.remover(nome);
	}

	@Override
	public void inserirGrupo(Grupo grupo) throws BancoException {
		negocioGrupo.inserir(grupo);
	}

	@Override
	public Grupo procurarGrupo(Integer idGrupo) throws BancoException {
		return negocioGrupo.procurar(idGrupo);
	}

	@Override
	public void atualizarGrupo(Grupo grupo) throws BancoException {
		negocioGrupo.atualizar(grupo);
	}

	@Override
	public void removerGrupo(Integer idGrupo) throws BancoException {
		negocioGrupo.remover(idGrupo);
	}

	@Override
	public void inserirAvaliacoes(Avaliacoes avaliacao) throws BancoException {
		negocioAvaliacao.inserir(avaliacao);
	}

	@Override
	public Avaliacoes procurarAvaliacoes(Integer idAvaliacao) throws BancoException {
		return negocioAvaliacao.procurar(idAvaliacao);
	}

	@Override
	public void atualizarAvaliacoes(Avaliacoes avaliacao) throws BancoException {
		negocioAvaliacao.atualizar(avaliacao);
	}

	@Override
	public void removerAvaliacoes(Integer idAvaliacao) throws BancoException {
		negocioAvaliacao.remover(idAvaliacao);
	}

	@Override
	public List<Pessoa> listaPessoas(TipoPessoa tipoPessoa) {
		return negocioPessoa.listaPessoa(tipoPessoa);
	}

	@Override
	public List<Grupo> listaGrupos() {
		return negocioGrupo.listaGrupos();
	}

}
