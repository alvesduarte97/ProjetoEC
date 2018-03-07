package com.br.avaliacoes.ec.telas;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.servidor.IServidor;

public class AvaOrgTela extends JPanel {
	List<Grupo> listaGrupo;
	AvaliacaoTela telaAva;
	public AvaOrgTela(IServidor servidor) {
		try {
			listaGrupo = servidor.listaGruposPorSerie
					(PrincipalTela.pessoa.getSerie(), PrincipalTela.desafioAtivo.getNome());
			telaAva = new AvaliacaoTela(0, listaGrupo,null, servidor);
		} catch (BancoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		telaAva.setVisible(true);
		add(telaAva);
		
	}

}
