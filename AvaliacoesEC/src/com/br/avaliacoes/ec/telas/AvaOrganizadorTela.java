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

	/**
	 * Create the panel.
	 */
	public AvaOrganizadorTela() {
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 834, 21);
		add(menuBar);
		
		JMenu mnOrganizador = new JMenu("Organizador");
		menuBar.add(mnOrganizador);
		
		mntmTelaPrincipal = new JMenuItem("Tela Principal");
		mntmTelaPrincipal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastroEscolaTela telaOrg = new CadastroEscolaTela();
				PrincipalTela.internalFrame.setContentPane(telaOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnOrganizador.add(mntmTelaPrincipal);
		
		JMenuItem mntmAdicionarOrganizador = new JMenuItem("Adicionar Organizador");
		mntmAdicionarOrganizador.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddOrgTela addOrg = new AddOrgTela();
				PrincipalTela.internalFrame.setContentPane(addOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnOrganizador.add(mntmAdicionarOrganizador);
		
		
		JMenuItem mntmRemoverOrganizador = new JMenuItem("Remover Organizador");
		mnOrganizador.add(mntmRemoverOrganizador);
		
		JMenu mnGrupos = new JMenu("Grupos");
		menuBar.add(mnGrupos);
		
		JMenuItem mntmCadastrarGrupo = new JMenuItem("Cadastrar Grupo");
		mnGrupos.add(mntmCadastrarGrupo);
		
		JMenuItem mntmRemoverGrupo = new JMenuItem("Remover Grupo");
		mnGrupos.add(mntmRemoverGrupo);
		
		JMenu mnDesafios = new JMenu("Desafios");
		menuBar.add(mnDesafios);
		
		JMenuItem mntmAtivardesativarDesafio = new JMenuItem("Ativar/Desativar Desafio");
		mnDesafios.add(mntmAtivardesativarDesafio);
		
		JMenuItem mntmCadastrarDesafio = new JMenuItem("Cadastrar Desafio");
		mnDesafios.add(mntmCadastrarDesafio);
		
		JMenuItem mntmRemoverDesafio = new JMenuItem("Remover Desafio");
		mnDesafios.add(mntmRemoverDesafio);
		
		JMenu mnAvaliao = new JMenu("Avalia\u00E7\u00E3o");
		menuBar.add(mnAvaliao);
		
		JMenuItem mntmGerarPdf = new JMenuItem("Gerar PDF");
		mnAvaliao.add(mntmGerarPdf);

	}

}
