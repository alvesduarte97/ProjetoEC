package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Desafios;
import javax.swing.JScrollPane;

public class GerarExcelTela extends BaseOrgTela {
	private JList list;
	private List<Desafios> listaDesafios;
	
	public GerarExcelTela() {
		
		JButton btnGerar = new JButton("Gerar Excel");
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indexSec = list.getSelectedIndex();
				Desafios desafio = listaDesafios.get(indexSec);
				String nomeDesafio = (String) list.getSelectedValue();
				
				try {
					FachadaImp.getInstanciaFachada().gerarExcelAvaliacoes(desafio);
					JOptionPane.showMessageDialog(null, "Excel gerado com sucesso");
				} catch (IOException e) {
					e.printStackTrace();
					e.getMessage();
				}
				
			}
		});
		
		DefaultListModel modelDesafios = new DefaultListModel();
		listaDesafios = FachadaImp.getInstanciaFachada().listaDesafios();
		for(Desafios desafio : listaDesafios) {
			modelDesafios.addElement(desafio.getNome());
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 186, 433, 203);
		add(scrollPane);
		list = new JList(modelDesafios);
		scrollPane.setViewportView(list);
		
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
		ImageIcon icone3 =new ImageIcon(LoginTela.class.getResource("/imgfundo.jpg"));
		Imagem3.setBounds(0, 17, 741, 673);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(),Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);
	}
}
