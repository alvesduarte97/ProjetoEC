package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.SwingConstants;

import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Avaliacoes;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class OrganizadorTela extends BaseOrgTela {

		private List<Avaliacoes> listaUltimasAva;
		String textoParaTextArea= "";
	public OrganizadorTela() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 721, 457);
		add(scrollPane);
		
		JTextArea textAreaAvaliacao = new JTextArea();
		textAreaAvaliacao.setEditable(false);
		listaUltimasAva = FachadaImp.getInstanciaFachada().listaAvaliacoesOrdemDct();
		for(Avaliacoes ava : listaUltimasAva) {
			textoParaTextArea += "                                "+ava.getDesafio().getNome()+"    "+ava.getAvaliador().getNome()+"    " + ava.getGrupoAvaliado().getEscola()+"    " + ava.getGrupoAvaliado().getSerie()+"    "+
					ava.getNota1()+"   |   "+ava.getNota2()+"   |   "+ava.getNota3()+"   |   "+ava.getNota4()+"   |   "+ava.getNota5()+"\n\n";
		}
		textAreaAvaliacao.setText(textoParaTextArea);
		
		scrollPane.setViewportView(textAreaAvaliacao);
		
		JLabel lblStatus = new JLabel("Ultimas Avalia\u00E7\u00F5es");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStatus.setBounds(0, 52, 741, 24);
		add(lblStatus);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-25, 107, 796, 2);
		add(separator_1);

		
		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 = new ImageIcon(LoginTela.class.getResource("/img/Fundo2.jpg"));
		Imagem3.setBounds(0, 17, 741, 668);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(), Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);
		
		
		
		
		
	}

}
