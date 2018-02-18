package com.br.avaliacoes.ec.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BaseOrgTela extends JPanel {

	private JMenuBar menuBar;
	private JMenuItem mntmAdicionarOrganizador;
	private JMenuItem mntmTelaPrincipal;
	public BaseOrgTela() {
		setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 790, 21);
		add(menuBar);
		
		JMenu mnOrganizador = new JMenu("Organizador");
		menuBar.add(mnOrganizador);
		
		mntmAdicionarOrganizador = new JMenuItem("Adicionar Organizador");
		mntmAdicionarOrganizador.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddOrgTela addOrg = new AddOrgTela();
				PrincipalTela.internalFrame.setContentPane(addOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		
		mntmTelaPrincipal = new JMenuItem("Tela Principal");
		mntmTelaPrincipal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				OrganizadorTela telaOrg = new OrganizadorTela();
				PrincipalTela.internalFrame.setContentPane(telaOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnOrganizador.add(mntmTelaPrincipal);
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
		
		JMenuItem mntmAvaliar = new JMenuItem("Avaliar");
		mntmAvaliar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AvaOrganizadorTela telaAva = new AvaOrganizadorTela();
				PrincipalTela.internalFrame.setContentPane(telaAva);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnAvaliao.add(mntmAvaliar);
		
		JMenuItem mntmGerarPdf = new JMenuItem("Gerar PDF");
		mnAvaliao.add(mntmGerarPdf);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrincipalTela.pessoa = null;
				LoginTela telaLogin = new LoginTela();
				PrincipalTela.internalFrame.setContentPane(telaLogin);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		btnSair.setBounds(619, 39, 89, 23);
		add(btnSair);

	}

}
