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

public class AddOrgTela extends BaseOrgTela {
	public AddOrgTela() {
		setLayout(null);
		
		JList listOrganizadores = new JList();
		listOrganizadores.setBounds(360, 268, 132, 90);
		add(listOrganizadores);
		
		JLabel label = new JLabel("Organizadores");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(360, 233, 132, 24);
		add(label);
		
		JList listAvaliadores = new JList();
		listAvaliadores.setBounds(213, 268, 132, 90);
		add(listAvaliadores);
		
		JLabel label_1 = new JLabel("Avaliadores");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(213, 233, 132, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("Tornar ORG:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(208, 198, 99, 24);
		add(label_2);
		
		JButton btnConfirmarAvali = new JButton("Confirmar");
		btnConfirmarAvali.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmarAvali.setBounds(213, 369, 132, 25);
		add(btnConfirmarAvali);
		
		JButton btnRemoverOrg = new JButton("Remover");
		btnRemoverOrg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoverOrg.setBounds(360, 369, 132, 25);
		add(btnRemoverOrg);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVoltar.setBounds(284, 424, 132, 25);
		add(btnVoltar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-55, 189, 796, 8);
		add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-32, 405, 796, 8);
		add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-15, 460, 796, 8);
		add(separator_2);

	}

}
