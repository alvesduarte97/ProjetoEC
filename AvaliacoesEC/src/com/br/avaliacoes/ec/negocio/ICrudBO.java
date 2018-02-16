package com.br.avaliacoes.ec.negocio;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.BancoEntity;

public interface ICrudBO<T extends BancoEntity<TCHAVE>, TCHAVE> {
	void inserir(T entity) throws BancoException;
    T procurar(TCHAVE chave) throws BancoException;
    void atualizar(T entity) throws BancoException;
	void remover(TCHAVE chave) throws BancoException;
	
}
