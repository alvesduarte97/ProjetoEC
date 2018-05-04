package com.br.avaliacoes.ec.DAO;

import java.util.List;

import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

public interface IPessoaDAO extends ICrudDAO<Pessoa, String>{


	List<Pessoa> listaPessoas(TipoPessoa tipoPessoa);
	public Pessoa buscarPessoaNome(String nome);
	public List<Pessoa> listaDePessasNaSerie(String serie);
		
}
