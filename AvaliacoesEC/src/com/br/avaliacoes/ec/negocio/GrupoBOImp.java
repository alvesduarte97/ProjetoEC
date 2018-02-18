package com.br.avaliacoes.ec.negocio;

import com.br.avaliacoes.ec.DAO.IGrupoDAO;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Grupo;

public class GrupoBOImp implements IGrupoBO {

	IGrupoDAO repositorio;
	
	public GrupoBOImp(IGrupoDAO repositorio) {
	
		this.repositorio = repositorio;
	}
	
	@Override
	public void inserir(Grupo entity) throws BancoException {
		Grupo grupo = repositorio.procurar(entity.getChave());
		if(grupo != null) {
			throw new BancoException("Grupo ja cadastrado");
		}
		
		repositorio.inserir(entity);
	}

	@Override
	public Grupo procurar(Integer chave) throws BancoException {
		Grupo grupo = repositorio.procurar(chave);
		if(grupo == null) {
			throw new BancoException("Grupo não encontrado");
		}
		
		return grupo;
	}

	@Override
	public void atualizar(Grupo entity) throws BancoException {
		Grupo grupo = procurar(entity.getChave());
		if(grupo == null) {
			throw new BancoException("Grupo não encontrado");
		}
		repositorio.atualizar(entity);
	}

	@Override
	public void remover(Integer chave) throws BancoException {
		Grupo grupo = procurar(chave);
		if(grupo == null) {
			throw new BancoException("Grupo não existe");
		}
		repositorio.remover(chave);
		
	}

}
