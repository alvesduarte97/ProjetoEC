package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Organizador extends JPanel {
	private JTextField textFieldNomeEscola;
	private JTextField textFieldProfOrient;
	private JTextField textFieldNomeDesafio;

	/**
	 * Create the panel.
	 */
	public Organizador() {
		setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setToolTipText("Menu");
		popupMenu.setBounds(715, 5, 83, 16);
		addPopup(this, popupMenu);
		
		JMenuItem mntmAdicionarOrganizador = new JMenuItem("Adicionar  ou remover organizador");
		popupMenu.add(mntmAdicionarOrganizador);
		
		JMenuItem mntmPaginarDeAvaliao = new JMenuItem("Pagina de avalia\u00E7\u00E3o");
		popupMenu.add(mntmPaginarDeAvaliao);
		
		JLabel label = new JLabel("");
		label.setBounds(322, 5, 0, 0);
		add(label);
		
		JLabel lblNewLabel = new JLabel("Cadastrar grupo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(191, 88, 157, 24);
		add(lblNewLabel);
		
		JLabel lblCadastrarDesafio_1 = new JLabel("Cadastrar desafio:");
		lblCadastrarDesafio_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrarDesafio_1.setBounds(191, 362, 157, 24);
		add(lblCadastrarDesafio_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da escola:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(191, 141, 127, 24);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Serie:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(191, 248, 46, 24);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Regi\u00E3o:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(191, 213, 73, 24);
		add(lblNewLabel_3);
		
		textFieldNomeEscola = new JTextField();
		textFieldNomeEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNomeEscola.setBounds(359, 141, 132, 24);
		add(textFieldNomeEscola);
		textFieldNomeEscola.setColumns(10);
		
		JComboBox comboBoxSerie = new JComboBox();
		comboBoxSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxSerie.setBounds(359, 250, 132, 24);
		add(comboBoxSerie);
		
		JLabel lblNewLabel_4 = new JLabel("Professor orientador:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(191, 176, 136, 24);
		add(lblNewLabel_4);
		
		JComboBox comboBoxRegiao = new JComboBox();
		comboBoxRegiao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxRegiao.setBounds(359, 213, 132, 24);
		add(comboBoxRegiao);
		
		textFieldProfOrient = new JTextField();
		textFieldProfOrient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldProfOrient.setColumns(10);
		textFieldProfOrient.setBounds(359, 176, 132, 24);
		add(textFieldProfOrient);
		
		JLabel lblNewLabel_5 = new JLabel("Nome do desafio:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(191, 416, 116, 24);
		add(lblNewLabel_5);
		
		textFieldNomeDesafio = new JTextField();
		textFieldNomeDesafio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNomeDesafio.setColumns(10);
		textFieldNomeDesafio.setBounds(359, 416, 132, 24);
		add(textFieldNomeDesafio);
		
		JLabel lblStatusDesafios = new JLabel("Desafio do momento:");
		lblStatusDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatusDesafios.setBounds(191, 451, 147, 24);
		add(lblStatusDesafios);
		
		JComboBox comboBoxDesafios = new JComboBox();
		comboBoxDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxDesafios.setBounds(359, 451, 132, 24);
		add(comboBoxDesafios);
		
		JButton btnAdicionarDesafi = new JButton("+");
		btnAdicionarDesafi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionarDesafi.setBounds(503, 416, 46, 25);
		add(btnAdicionarDesafi);
		
		JButton btnCadastroGrupo = new JButton("Confirmar");
		btnCadastroGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastroGrupo.setBounds(359, 311, 132, 25);
		add(btnCadastroGrupo);
		
		JButton btnCadastroDesafi = new JButton("Confirmar");
		btnCadastroDesafi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastroDesafi.setBounds(359, 512, 132, 25);
		add(btnCadastroDesafi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-37, 343, 796, 8);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-37, 69, 796, 8);
		add(separator_1);
		
		JLabel lblNewLabel_6 = new JLabel("Cadastro");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(322, 34, 106, 24);
		add(lblNewLabel_6);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 548, 796, 8);
		add(separator_2);

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
