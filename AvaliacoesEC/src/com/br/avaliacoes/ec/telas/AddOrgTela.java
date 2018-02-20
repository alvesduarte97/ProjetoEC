package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class AddOrgTela extends BaseOrgTela {
	public AddOrgTela() {
		setLayout(null);
		
		JList listOrganizadores = new JList();
		listOrganizadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(635, 268, 17, 104);
		add(scrollBar_1);
		
		
		listOrganizadores.setBounds(440, 268, 191, 104);
		add(listOrganizadores);
		
		
		
		JLabel label = new JLabel("Organizadores");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(440, 233, 168, 24);
		add(label);
		
		JList listAvaliadores = new JList();
		listAvaliadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(309, 268, 17, 104);
		add(scrollBar);
		listAvaliadores.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAvaliadores.setBounds(116, 268, 191, 104);
		add(listAvaliadores);
		
		
		
		JLabel label_1 = new JLabel("Avaliadores");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(139, 233, 168, 24);
		add(label_1);
		
		JLabel lblConfigurao = new JLabel("Reger Organizador");
		lblConfigurao.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfigurao.setBounds(279, 185, 197, 24);
		add(lblConfigurao);
		
		JButton btnConfirmarAvali = new JButton(">>>");
		btnConfirmarAvali.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmarAvali.setBounds(336, 268, 76, 45);
		add(btnConfirmarAvali);
		
		JButton btnRemoverOrg = new JButton("<<<");
		btnRemoverOrg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoverOrg.setBounds(336, 327, 76, 45);
		add(btnRemoverOrg);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-55, 220, 796, 2);
		add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-17, 383, 796, 2);
		add(separator);

	}

}
