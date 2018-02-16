package com.br.avaliacoes.ec.negocio;

import com.br.avaliacoes.ec.DAO.IAvaliacoesDAO;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;

public class AvaliacoesBOImp implements IAvaliacoesBO {

	private IAvaliacoesDAO repositorio;
	
	public AvaliacoesBOImp(IAvaliacoesDAO repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public void inserir(Avaliacoes entity) throws BancoException {
		repositorio.inserir(entity);
	}

	@Override
	public Avaliacoes procurar(Integer chave) throws BancoException {
		return repositorio.procurar(chave);
	}

	@Override
	public void atualizar(Avaliacoes entity) throws BancoException {
		repositorio.atualizar(entity);
	}

	@Override
	public void remover(Integer chave) throws BancoException {
		repositorio.remover(chave);
	}

}
