package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Desafios;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class GerarExcelTela extends BaseOrgTela {

	
	public GerarExcelTela() {
		
		JButton btnGerar = new JButton("Gerar Lista");
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeDesafio = txtNomeDesafio.getText();
				Desafios desafio;
				try {
					desafio = FachadaImp.getInstanciaFachada().procurarDesafios(nomeDesafio);
					FachadaImp.getInstanciaFachada().gerarExcelAvaliacoes(desafio);

				} catch (BancoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		
		JList list = new JList();
		list.setBounds(260, 186, 198, 203);
		add(list);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-68, 469, 877, 2);
		add(separator_1);
		
		JLabel lblSelecioneUmDesafio = new JLabel("Selecione um desafio para gerar a lista.");
		lblSelecioneUmDesafio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUmDesafio.setBounds(260, 391, 198, 14);
		add(lblSelecioneUmDesafio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-68, 169, 877, 2);
		add(separator);
		btnGerar.setBounds(260, 416, 198, 42);
		add(btnGerar);
		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 = new ImageIcon(LoginTela.class.getResource("/img/Fundo2.jpg"));
		Imagem3.setBounds(0, 17, 741, 668);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(), Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);
	}
}
