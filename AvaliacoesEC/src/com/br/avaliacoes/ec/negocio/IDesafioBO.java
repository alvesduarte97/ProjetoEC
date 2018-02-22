package com.br.avaliacoes.ec.negocio;

import java.util.List;

import com.br.avaliacoes.ec.modelo.Desafios;

public interface IDesafioBO extends ICrudBO<Desafios, String> {

	List<Desafios> listaDesafios();

}
