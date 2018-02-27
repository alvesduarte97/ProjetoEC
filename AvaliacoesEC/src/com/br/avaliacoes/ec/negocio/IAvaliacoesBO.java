package com.br.avaliacoes.ec.negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.Regiao;

public interface IAvaliacoesBO extends ICrudBO<Avaliacoes, Integer>{

	List<Avaliacoes> listaAvaliacoesPorAvaliador(Pessoa pessoa) throws BancoException;
	void gerarExcelAvaliacoes(Desafios desafio) throws FileNotFoundException, IOException;

}
