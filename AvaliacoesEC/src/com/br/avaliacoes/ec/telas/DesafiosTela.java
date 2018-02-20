package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JList;

public class DesafiosTela extends BaseOrgTela {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public DesafiosTela() {
		setSize(741, 668);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-25, 167, 796, 2);
		add(separator);
		
		JLabel label_1 = new JLabel("Nome do desafio:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(209, 180, 116, 24);
		add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(377, 180, 142, 24);
		add(textField);
		
		JButton btnAdicionar = new JButton("Ativar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionar.setBounds(209, 467, 310, 25);
		add(btnAdicionar);
		
		JButton btnAdicionarDesafio = new JButton("Adicionar Desafio");
		btnAdicionarDesafio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionarDesafio.setBounds(377, 215, 142, 25);
		add(btnAdicionarDesafio);
		
		JLabel lblCadastroDesafio = new JLabel("Cadastro Desafio");
		lblCadastroDesafio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDesafio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastroDesafio.setBounds(0, 132, 741, 24);
		add(lblCadastroDesafio);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-25, 251, 796, 2);
		add(separator_1);
		
		JLabel lblConfigurarDesafios = new JLabel("Configurar");
		lblConfigurarDesafios.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfigurarDesafios.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfigurarDesafios.setBounds(0, 264, 741, 24);
		add(lblConfigurarDesafios);
		
		JTextPane txtRenomear = new JTextPane();
		txtRenomear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRenomear.setBounds(209, 499, 310, 24);
		add(txtRenomear);
		
		JList listDesafios = new JList();
		listDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listDesafios.setBounds(209, 347, 310, 109);
		add(listDesafios);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-15, 299, 796, 2);
		add(separator_2);
		
		JLabel lblDesafios = new JLabel("Desafios:");
		lblDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesafios.setBounds(209, 312, 74, 24);
		add(lblDesafios);
		
		JButton btnRenomear = new JButton("Renomear");
		btnRenomear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRenomear.setBounds(209, 534, 310, 25);
		add(btnRenomear);
	}
}
