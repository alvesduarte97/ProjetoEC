package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class AvaliacaoTela extends JPanel {
	private JTextArea txtComentario;
	private JButton btnConfirmar;
	private JComboBox cbNota1;
	private JComboBox cbNota2;
	private JComboBox cbNota3;
	private JComboBox cbNota4;
	private JInternalFrame frameVideo;
	private TextField txtEscola;
	private TextField txtSerie;
	private TextField txtDesafio;

	/**
	 * Create the panel.
	 */
	public AvaliacaoTela() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 527, 376, 63);
		add(scrollPane);
		
		txtComentario = new JTextArea();
		scrollPane.setViewportView(txtComentario);
		txtComentario.setLineWrap(true);
		
		JLabel lblNewLabel = new JLabel("Comentario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(178, 502, 86, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nota 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 411, 46, 14);
		add(lblNewLabel_1);
		
		cbNota1 = new JComboBox();
		cbNota1.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		cbNota1.setBounds(178, 450, 46, 20);
		add(cbNota1);
		
		cbNota2 = new JComboBox();
		cbNota2.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		cbNota2.setBounds(294, 450, 46, 20);
		add(cbNota2);
		
		cbNota3 = new JComboBox();
		cbNota3.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		cbNota3.setBounds(406, 450, 46, 20);
		add(cbNota3);
		
		cbNota4 = new JComboBox();
		cbNota4.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		cbNota4.setBounds(508, 450, 46, 20);
		add(cbNota4);
		
		JLabel label = new JLabel("Nota 2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(294, 411, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Nota 3");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(406, 411, 46, 14);
		add(label_1);
		
		JLabel label_3 = new JLabel("Nota 4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(508, 411, 46, 14);
		add(label_3);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setBounds(178, 601, 376, 56);
		add(btnConfirmar);
		

		
		JSeparator separator = new JSeparator();
		separator.setBounds(-27, 594, 796, 8);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 497, 796, 8);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-27, 392, 796, 8);
		add(separator_2);
		
		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setBounds(294, 33, 36, 14);
		add(lblEscola);
		
		txtEscola = new TextField();
		txtEscola.setBounds(340, 30, 198, 22);
		add(txtEscola);
		txtEscola.setEditable(false);
		txtEscola.setEnabled(false);
		
		JLabel lblSerie = new JLabel("Serie:");
		lblSerie.setBounds(565, 33, 36, 14);
		add(lblSerie);
		
		txtSerie = new TextField();
		txtSerie.setBounds(607, 30, 63, 22);
		add(txtSerie);
		txtSerie.setEditable(false);
		txtSerie.setEnabled(false);
		
		JLabel lblDesafio = new JLabel("Desafio:");
		lblDesafio.setBounds(36, 33, 46, 14);
		add(lblDesafio);
		
		txtDesafio = new TextField();
		txtDesafio.setEnabled(false);
		txtDesafio.setEditable(false);
		txtDesafio.setBounds(88, 30, 186, 22);
		add(txtDesafio);
		
		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginTela logTela = new LoginTela();
				PrincipalTela.internalFrame.setContentPane(logTela);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(650, 601, 80, 56);
		add(button);
		//frameVideo.setVisible(true);

		
		//JLabel Imagem2 = new JLabel("New label");
		//ImageIcon icone1 =new ImageIcon("C:/Users/PC/git/ProjetoEC/AvaliacoesEC/src/img/Fundo2.jpg");
		//Imagem2.setBounds(0, 21, 741, 647);
		//Image imagi = icone1.getImage().getScaledInstance(Imagem2.getWidth(),Imagem2.getHeight(), Image.SCALE_SMOOTH);
		
		//Imagem2.setIcon(new ImageIcon(imagi));
		//add(Imagem2);
		
		//Panel panel = new Panel();
		//panel.setBounds(83, 45, 589, 340);
		//add(panel);

	}

	}

