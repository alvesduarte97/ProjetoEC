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

public class Avaliaçao2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Avaliaçao2() {
		setLayout(null);
		
		JTextArea textAreaComentario = new JTextArea();
		textAreaComentario.setBounds(183, 527, 376, 63);
		add(textAreaComentario);
		
		JLabel lblNewLabel = new JLabel("Comentario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(183, 502, 86, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nota 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(183, 383, 46, 14);
		add(lblNewLabel_1);
		
		JComboBox comboBoxNota1 = new JComboBox();
		comboBoxNota1.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		comboBoxNota1.setBounds(183, 426, 46, 20);
		add(comboBoxNota1);
		
		JComboBox comboBoxNota2 = new JComboBox();
		comboBoxNota2.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		comboBoxNota2.setBounds(299, 426, 46, 20);
		add(comboBoxNota2);
		
		JComboBox comboBoxNota3 = new JComboBox();
		comboBoxNota3.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		comboBoxNota3.setBounds(411, 426, 46, 20);
		add(comboBoxNota3);
		
		JComboBox comboBoxNota4 = new JComboBox();
		comboBoxNota4.setModel(new DefaultComboBoxModel(new String[] {"0,1", "0,2", "0,3", "0,4"}));
		comboBoxNota4.setBounds(513, 426, 46, 20);
		add(comboBoxNota4);
		
		JLabel label = new JLabel("Nota 2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(299, 383, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Nota 3");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(411, 383, 46, 14);
		add(label_1);
		
		JLabel label_3 = new JLabel("Nota 4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(513, 383, 46, 14);
		add(label_3);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setBounds(183, 601, 376, 56);
		add(btnConfirmar);
		
		JInternalFrame internalFrame = new JInternalFrame("                                                                                                            Video");
		internalFrame.setBorder(null);
		internalFrame.setEnabled(false);
		internalFrame.setBounds(10, 11, 721, 361);
		add(internalFrame);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-27, 594, 796, 8);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 497, 796, 8);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-27, 375, 796, 8);
		add(separator_2);
		internalFrame.setVisible(true);

	}
}
