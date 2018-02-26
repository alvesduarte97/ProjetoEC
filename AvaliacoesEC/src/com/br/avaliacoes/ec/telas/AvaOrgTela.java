package com.br.avaliacoes.ec.telas;

import java.util.List;

import javax.swing.JOptionPane;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Grupo;

public class AvaOrgTela extends BaseOrgTela {
	List<Grupo> listaGrupo;
	AvaliacaoTela telaAva;
	public AvaOrgTela() {
		
		try {
			listaGrupo = FachadaImp.getInstanciaFachada().listaGruposPorSerie(PrincipalTela.pessoa.getSerie());
			telaAva = new AvaliacaoTela(0, listaGrupo);
		} catch (BancoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		telaAva.setVisible(true);
		add(telaAva);
		
	}

}