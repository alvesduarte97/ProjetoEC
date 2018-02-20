package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		txtComentario = new JTextArea();
		txtComentario.setBounds(178, 527, 376, 63);
		add(txtComentario);
		
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
		
		frameVideo = new JInternalFrame("                                                                                                            Video");
		frameVideo.setBorder(null);
		frameVideo.setEnabled(false);
		frameVideo.setBounds(36, 58, 675, 325);
		frameVideo.getContentPane().setLayout(null);
		frameVideo.getContentPane().setEnabled(false);
		add(frameVideo);
		
		
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
		frameVideo.setVisible(true);

	}
}
