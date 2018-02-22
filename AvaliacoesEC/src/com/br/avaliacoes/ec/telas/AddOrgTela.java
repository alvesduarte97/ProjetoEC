package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class AddOrgTela extends BaseOrgTela {
	private JButton btnAvaToOrg;
	private JButton btnOrgToAva;
	public AddOrgTela() {
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(440, 268, 191, 104);
		add(scrollPane_1);
		
		DefaultListModel modelOrg =  new DefaultListModel();
		List<Pessoa> listaOrg = FachadaImp.getInstanciaFachada().listaPessoas(TipoPessoa.ORGANIZACAO);
		for(Pessoa pessoa : listaOrg) {
			modelOrg.addElement(pessoa.getNome());
		}
		
		JList listOrganizadores = new JList(modelOrg);
		scrollPane_1.setViewportView(listOrganizadores);
		listOrganizadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		JLabel label = new JLabel("Organizadores");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(440, 233, 168, 24);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 268, 191, 104);
		add(scrollPane);
		
		DefaultListModel modelAva = new DefaultListModel();
		List<Pessoa> listAva = FachadaImp.getInstanciaFachada().listaPessoas(TipoPessoa.AVALIADOR);
		for(Pessoa pessoa : listAva) {
			modelAva.addElement(pessoa.getNome());
		}
		
		JList listAvaliadores = new JList(modelAva);
		scrollPane.setViewportView(listAvaliadores);
		listAvaliadores.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listAvaliadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		
		JLabel label_1 = new JLabel("Avaliadores");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(139, 233, 168, 24);
		add(label_1);
		
		JLabel lblConfigurao = new JLabel("Reger Organizador");
		lblConfigurao.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfigurao.setBounds(279, 185, 197, 24);
		add(lblConfigurao);
		
		btnAvaToOrg = new JButton(">>>");
		btnAvaToOrg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeAva = (String) listAvaliadores.getSelectedValue();
				for(Pessoa pessoa : listAva) {
					if(pessoa.getNome().equals(nomeAva)) {
						pessoa.setTipo(TipoPessoa.ORGANIZACAO);
						try {
							FachadaImp.getInstanciaFachada().atualizarPessoa(pessoa);
							modelAva.removeElement(pessoa.getNome());
							modelOrg.addElement(pessoa.getNome());
							listAva.remove(pessoa);
							listaOrg.add(pessoa);
							break;
						} catch (BancoException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				}
			}
		});
		btnAvaToOrg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAvaToOrg.setBounds(336, 268, 76, 45);
		add(btnAvaToOrg);
		
		btnOrgToAva = new JButton("<<<");
		btnOrgToAva.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String nomeOrg = (String) listOrganizadores.getSelectedValue();
				for(Pessoa pessoa: listaOrg) {
					if(pessoa.getNome().equals(nomeOrg)) {
						pessoa.setTipo(TipoPessoa.AVALIADOR);
						try {
							FachadaImp.getInstanciaFachada().atualizarPessoa(pessoa);
							modelOrg.removeElement(pessoa.getNome());
							modelAva.addElement(pessoa.getNome());
							listaOrg.remove(pessoa);
							listAva.add(pessoa);
							break;
						} catch (BancoException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				}
			}
		});
		btnOrgToAva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOrgToAva.setBounds(336, 327, 76, 45);
		add(btnOrgToAva);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-55, 220, 796, 2);
		add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-17, 383, 796, 2);
		add(separator);
		
		
		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 =new ImageIcon(LoginTela.class.getResource("/img/Fundo2.jpg"));
		Imagem3.setBounds(0, 17, 741, 668);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(),Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);
		
		
		
		
	}
}
