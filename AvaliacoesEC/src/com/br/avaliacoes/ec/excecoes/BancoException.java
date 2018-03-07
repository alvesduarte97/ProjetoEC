package com.br.avaliacoes.ec.excecoes;

import java.rmi.RemoteException;

public class BancoException extends Exception {

	private static final long serialVersionUID = 3211428250570958507L;
	
	public BancoException(String mensagem) {
		super(mensagem);
	}
}
