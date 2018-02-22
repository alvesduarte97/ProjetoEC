package com.br.avaliacoes.ec.negocio;

import java.util.List;

import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Pessoa;

public interface IAvaliacoesBO extends ICrudBO<Avaliacoes, Integer>{

	List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa);

}
