package com.br.avaliacoes.ec.negocio;

import java.util.List;

import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

public interface IPessoaBO extends ICrudBO<Pessoa, String> {

	List<Pessoa> listaPessoa(TipoPessoa tipoPessoa);

}
