package com.br.avaliacoes.ec.negocio;

import java.util.List;

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
		Grupo grupoRepetido = repositorio.procurarGrupo(entity.getEscola(), entity.getSerie());
		//List<Grupo> listaGrupos = repositorio.listaGrupos();
		
		if(grupo != null) {
			throw new BancoException("Este grupo já esta cadastrado");
		}else if(grupoRepetido != null) {
			throw new BancoException("Este grupo já esta cadastrado");
		}else if(entity.getEscola() == null) {
			throw new BancoException("Preencha o nome da escola");
		}else if(entity.getProfessor() == null) {
			throw new BancoException("Preencha o professor orientador");
		}
		
//		for(Grupo g : listaGrupos) {
//			if(g.getEscola().equals(entity.getEscola()) && g.getSerie().equals(entity.getSerie())) {
//				throw new BancoException("Este grupo já esta cadastrado.");
//			}
//		}
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

	@Override
	public List<Grupo> listaGrupos() {
		return repositorio.listaGrupos();
	}

	@Override
	public List<Grupo> listaGruposPorSerie(String serie, String desafioAtivo) throws BancoException {
		List<Grupo> lista = repositorio.listaGruposPorSerie(serie, desafioAtivo);
		
		if(lista == null || lista.size() < 1) {
			throw new BancoException("Não existem grupos da: "+serie+" para avaliar");
		}
		return lista;
	}

}
