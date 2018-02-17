package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Avaliaçao extends JPanel {

	/**
	 * Create the panel.
	 */
	public Avaliaçao() {
		setLayout(null);
		
		JButton btnIniciarAvaliacao = new JButton("Iniciar Avalia\u00E7\u00E3o");
		btnIniciarAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIniciarAvaliacao.setBounds(228, 374, 279, 64);
		add(btnIniciarAvaliacao);
		
		JLabel lblNewLabel = new JLabel("Serie:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(228, 210, 76, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Desafio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(228, 288, 76, 14);
		add(lblNewLabel_1);
		
		JLabel lblDesafio = new JLabel("");
		lblDesafio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesafio.setBounds(228, 313, 114, 14);
		add(lblDesafio);
		
		JLabel lblSerie = new JLabel("");
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSerie.setBounds(228, 235, 114, 14);
		add(lblSerie);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-20, 449, 796, 8);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-20, 355, 796, 8);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-20, 191, 796, 8);
		add(separator_2);

	}
}
