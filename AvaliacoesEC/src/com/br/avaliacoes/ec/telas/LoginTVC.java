package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

public class LoginTVC extends JPanel {
	private JTextField NomeUsuarioField;
	private JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	public LoginTVC() {
		
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(322, 204, 100, 50);
		add(lblNewLabel);
		
		NomeUsuarioField = new JTextField();
		NomeUsuarioField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NomeUsuarioField.setBounds(247, 290, 154, 26);
		add(NomeUsuarioField);
		NomeUsuarioField.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Us\u00FAario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(247, 265, 86, 14);
		add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(247, 365, 154, 26);
		add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(247, 340, 86, 14);
		add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(211, 327, 309, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(211, 402, 309, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(211, 252, 309, 2);
		add(separator_2);
		
		JLabel Imagem2 = new JLabel("New label");
		ImageIcon icone1 =new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\ProjectEC1.1\\src\\Img\\login.png");
		Imagem2.setBounds(411, 265, 63, 51);
		Image imagi = icone1.getImage().getScaledInstance(Imagem2.getWidth(),Imagem2.getHeight(), Image.SCALE_SMOOTH);
		
		Imagem2.setIcon(new ImageIcon(imagi));
		add(Imagem2);
		
		
		
		JButton btnConfirmarLogin = new JButton("Confirmar");
		btnConfirmarLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmarLogin.setBounds(244, 411, 230, 46);
		add(btnConfirmarLogin);
		
		JLabel Imagem1 = new JLabel("New label");
		ImageIcon icone2 =new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\ProjectEC1.1\\src\\Img\\key.png");
		Imagem1.setBounds(411, 340, 63, 51);
		Image imagi2 = icone2.getImage().getScaledInstance(Imagem1.getWidth(),Imagem1.getHeight(), Image.SCALE_SMOOTH);
		
		Imagem1.setIcon(new ImageIcon(imagi2));
		add(Imagem1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(211, 466, 309, 2);
		add(separator_3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
