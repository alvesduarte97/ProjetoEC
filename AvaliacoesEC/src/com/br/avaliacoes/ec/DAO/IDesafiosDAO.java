package com.br.avaliacoes.ec.DAO;

import java.util.List;

import com.br.avaliacoes.ec.modelo.Desafios;

public interface IDesafiosDAO extends ICrudDAO<Desafios, String>{

	List<Desafios> listaDesafios();

	Desafios desafioAtivo();

	List<Desafios> listaDesafiosAvaliados();

}
