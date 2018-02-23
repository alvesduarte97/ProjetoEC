package com.br.avaliacoes.ec.DAO;

import java.util.List;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Pessoa;

public interface IAvaliacoesDAO extends ICrudDAO<Avaliacoes, Integer>{

	List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException;

}
