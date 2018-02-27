package com.br.avaliacoes.ec.DAO;

import java.util.List;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.Regiao;

public interface IAvaliacoesDAO extends ICrudDAO<Avaliacoes, Integer>{

	List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException;
	List<Avaliacoes> listaAvaliacoes(Regiao regiao, Desafios desafio);

}
