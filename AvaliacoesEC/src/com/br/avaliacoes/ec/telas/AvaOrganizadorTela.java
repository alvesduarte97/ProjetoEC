package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AvaOrganizadorTela extends AvaliacaoTela{
	private JMenuBar menuBar;
	private JMenuItem mntmTelaPrincipal;
	private BaseOrgTela baseOrg;

	/**
	 * Create the panel.
	 */
	public AvaOrganizadorTela() {
		baseOrg = new BaseOrgTela();
		baseOrg.setBounds(12, 12, 741, 667);
		add(baseOrg);

	}

}
