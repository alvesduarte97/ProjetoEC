package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.servidor.IServidor;

public class BaseOrgTela extends JPanel {

	private JMenuBar menuBar;
	private JMenuItem mntmAddRemovOrg;
	private JMenuItem mntmTelaPrincipal;
	
	public BaseOrgTela(IServidor servidor) {
		setLayout(null);
		setSize(741,695);
		
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 790, 21);
		add(menuBar);
		
		JMenu mnOrganizador = new JMenu("Organizador");
		menuBar.add(mnOrganizador);
		 
		mntmAddRemovOrg = new JMenuItem("Adicionar/Remover");
		mntmAddRemovOrg.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddOrgTela addOrg = new AddOrgTela(servidor);
				PrincipalTela.internalFrame.setContentPane(addOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		
		mntmTelaPrincipal = new JMenuItem("Tela Principal");
		mntmTelaPrincipal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				OrganizadorTela telaOrg = new OrganizadorTela(servidor);
				PrincipalTela.internalFrame.setContentPane(telaOrg);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnOrganizador.add(mntmTelaPrincipal);
		mnOrganizador.add(mntmAddRemovOrg);
		
		JMenu mnGrupos = new JMenu("Grupos");
		menuBar.add(mnGrupos);
		
		JMenuItem mntmCadastRemovGrup = new JMenuItem("Cadastrar/Remover");
		mntmCadastRemovGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GrupoTela cadGru  = new GrupoTela(servidor);
				PrincipalTela.internalFrame.setContentPane(cadGru);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnGrupos.add(mntmCadastRemovGrup);
		
		JMenu mnDesafios = new JMenu("Desafios");
		menuBar.add(mnDesafios);
		
		JMenuItem mntmCadastRemovDesafios = new JMenuItem("Cadastrar/Remover");
		mntmCadastRemovDesafios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesafiosTela desTela = new DesafiosTela(servidor);
				PrincipalTela.internalFrame.setContentPane(desTela);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnDesafios.add(mntmCadastRemovDesafios);
		
		JMenu mnAvaliao = new JMenu("Avalia\u00E7\u00E3o");
		menuBar.add(mnAvaliao);
		
		JMenuItem mntmAvaliar = new JMenuItem("Avaliar");
		mntmAvaliar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				List<Grupo> listaGrupos = null;
				try {
					listaGrupos = servidor.listaGruposPorSerie
							(PrincipalTela.pessoa.getSerie(), PrincipalTela.desafioAtivo.getNome(), PrincipalTela.pessoa.getLogin());
					AvaliacaoTela telaAva = new AvaliacaoTela(0, listaGrupos,null,servidor);
					PrincipalTela.frmTorneioVirtualDe.setContentPane(telaAva);
					PrincipalTela.frmTorneioVirtualDe.revalidate();
				} catch (BancoException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (RemoteException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
//				AvaOrgTela telaAva = new AvaOrgTela();
//				PrincipalTela.internalFrame.setContentPane(telaAva);
//				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnAvaliao.add(mntmAvaliar);
		
		JMenuItem mntmGerarExcel = new JMenuItem("Gerar Excel");
		mntmGerarExcel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				GerarExcelTela gerar = new GerarExcelTela(servidor);
				PrincipalTela.internalFrame.setContentPane(gerar);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnAvaliao.add(mntmGerarExcel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 615, 790, 2);
		add(separator);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginTela logTela = new LoginTela(servidor);
				PrincipalTela.internalFrame.setContentPane(logTela);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		//btnSair.setBounds(7, 601, 80, 56);
		btnSair.setBounds(10, 628, 80, 56);
		add(btnSair);
		ImageIcon icone3 =new ImageIcon(LoginTela.class.getResource("/img/Fundo2.jpg"));
		
	}


}
