package com.br.avaliacoes.ec.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Panel;

public class BaseOrgTela extends JPanel {

	private JMenuBar menuBar;
	private JMenuItem mntmAddRemovOrg;
	private JMenuItem mntmTelaPrincipal;
	public BaseOrgTela() {
		setLayout(null);
		setSize(741,668);
		
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 790, 21);
		add(menuBar);
		
		JMenu mnOrganizador = new JMenu("Organizador");
		menuBar.add(mnOrganizador);
		
		mntmAddRemovOrg = new JMenuItem("Adicionar/Remover");
		mntmAddRemovOrg.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddOrgTela addOrg = new AddOrgTela();
				PrincipalTela.internalFrame.setContentPane(addOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		
		mntmTelaPrincipal = new JMenuItem("Tela Principal");
		mntmTelaPrincipal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastroEscolaTela telaOrg = new CadastroEscolaTela();
				PrincipalTela.internalFrame.setContentPane(telaOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnOrganizador.add(mntmTelaPrincipal);
		mnOrganizador.add(mntmAddRemovOrg);
		
		JMenu mnGrupos = new JMenu("Grupos");
		menuBar.add(mnGrupos);
		
		JMenuItem mntmCadastRemovGrup = new JMenuItem("Cadastrar/Remover");
		mnGrupos.add(mntmCadastRemovGrup);
		
		JMenu mnDesafios = new JMenu("Desafios");
		menuBar.add(mnDesafios);
		
		JMenuItem mntmCadastRemovDesafios = new JMenuItem("Cadastrar/Remover");
		mnDesafios.add(mntmCadastRemovDesafios);
		
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-19, 588, 796, 2);
		add(separator);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setBounds(651, 601, 80, 56);
		add(btnSair);

	}
}
