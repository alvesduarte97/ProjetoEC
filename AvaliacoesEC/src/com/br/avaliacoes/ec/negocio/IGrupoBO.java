package com.br.avaliacoes.ec.negocio;

import java.util.List;

import com.br.avaliacoes.ec.modelo.Grupo;

public interface IGrupoBO extends ICrudBO<Grupo, Integer>{

	List<Grupo> listaGrupos();

}
