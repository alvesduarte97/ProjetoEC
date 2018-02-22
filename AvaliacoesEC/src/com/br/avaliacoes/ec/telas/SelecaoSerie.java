package com.br.avaliacoes.ec.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class SelecaoSerie extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelecaoSerie dialog = new SelecaoSerie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelecaoSerie() {
		setBounds(100, 100, 285, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 139, 139));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecione a serie a ser avaliada:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 34, 251, 14);
		contentPanel.add(lblNewLabel);
		
		JComboBox escolhaSerie = new JComboBox();
		escolhaSerie.setModel(new DefaultComboBoxModel(new String[] {"Selecione a serie"}));
		escolhaSerie.setMaximumRowCount(5);
		escolhaSerie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		escolhaSerie.addItem("1ª Serie");
		escolhaSerie.addItem("2ª Serie");
		escolhaSerie.addItem("3ª Serie");
		escolhaSerie.addItem("4ª Serie");
		escolhaSerie.addItem("5ª Serie");
		escolhaSerie.setBounds(74, 59, 125, 20);
		contentPanel.add(escolhaSerie);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				
			}
		}
	}
}
