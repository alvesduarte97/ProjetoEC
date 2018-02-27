package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Desafios;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GerarExcelTela extends BaseOrgTela {
	private JTextField txtNomeDesafio;

	
	public GerarExcelTela() {
		
		txtNomeDesafio = new JTextField();
		txtNomeDesafio.setBounds(43, 101, 86, 20);
		add(txtNomeDesafio);
		txtNomeDesafio.setColumns(10);
		
		JButton btnGerar = new JButton("gerar");
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
		btnGerar.setBounds(156, 100, 89, 23);
		add(btnGerar);

	}
}
