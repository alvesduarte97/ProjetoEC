package com.br.avaliacoes.ec.negocio;

import java.util.List;

import com.br.avaliacoes.ec.DAO.IDesafiosDAO;
import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Desafios;

public class DesafioBOImp implements IDesafioBO {
	
	private IDesafiosDAO repositorio;
	
	public DesafioBOImp(IDesafiosDAO repositorio) {
		this.repositorio= repositorio;
		
	}
	
	@Override
	public void inserir(Desafios entity) throws BancoException {
		Desafios desafio = repositorio.procurar(entity.getChave());
		if(desafio != null) {
			throw new BancoException("Desafio ja existe");
		}
		repositorio.inserir(entity);
		
	}

	@Override
	public Desafios procurar(String chave) throws BancoException {
		Desafios desafio = repositorio.procurar(chave);
		if(desafio == null) {
			throw new BancoException("Desafio não encontrado");
		}
		
		return desafio;
	}

	@Override
	public void atualizar(Desafios entity) throws BancoException {
		Desafios desafio = procurar(entity.getChave());
		if(desafio == null) {
			throw new BancoException("Desafio não encontrado");
		}
		repositorio.atualizar(entity);
	}

	@Override
	public void remover(String chave) throws BancoException {
		Desafios desafio = procurar(chave);
		if(desafio == null) {
			throw new BancoException("Desafio não encontrado");
		}
		repositorio.remover(chave);
	}

	@Override
	public List<Desafios> listaDesafios() {
		return repositorio.listaDesafios();
	}

	@Override
	public Desafios desafioAtivo() {
		return repositorio.desafioAtivo();
	}

}
