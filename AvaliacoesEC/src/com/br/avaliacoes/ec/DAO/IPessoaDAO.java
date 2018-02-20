package com.br.avaliacoes.ec.DAO;

import java.util.List;

import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

public interface IPessoaDAO extends ICrudDAO<Pessoa, String>{


	List<Pessoa> listaPessoas(TipoPessoa tipoPessoa);
		
		
}
