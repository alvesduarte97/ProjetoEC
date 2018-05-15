package com.br.avaliacoes.ec.DAO;

import java.util.List;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Grupo;

public interface IGrupoDAO extends ICrudDAO<Grupo,Integer>{

	List<Grupo> listaGrupos();

	List<Grupo> listaGruposPorSerie(String serie, String desafioAtivo, String login) throws BancoException;
	
	public Grupo procurarGrupo(String escola, String serie);

}
