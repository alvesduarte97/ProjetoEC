package com.br.avaliacoes.ec.telas;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Regiao;
import com.br.avaliacoes.ec.modelo.StatusDesafio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrganizadorTela extends BaseOrgTela {
	private JTextField txtNomeEscola;
	private JTextField txtProfOrient;
	private JTextField txtNomeDesafio;
	private JComboBox cbRegiao;
	private JComboBox cbSerie;
	private JComboBox cbDesafios;

	/**
	 * Create the panel.
	 */
	public OrganizadorTela() {
		setLayout(null);
		
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
		
		txtNomeEscola = new JTextField();
		txtNomeEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeEscola.setBounds(359, 141, 132, 24);
		add(txtNomeEscola);
		txtNomeEscola.setColumns(10);
		
		cbSerie = new JComboBox();
		cbSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbSerie.setBounds(359, 250, 132, 24);
		cbSerie.addItem("Selecione");
		cbSerie.addItem("1ª Serie");
		cbSerie.addItem("2ª Serie");
		cbSerie.addItem("3ª Serie");
		cbSerie.addItem("4ª Serie");
		cbSerie.addItem("5ª Serie");
		add(cbSerie);
		
		JLabel lblNewLabel_4 = new JLabel("Professor orientador:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(191, 176, 136, 24);
		add(lblNewLabel_4);
		
		cbRegiao = new JComboBox();
		cbRegiao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbRegiao.setBounds(359, 213, 132, 24);
		cbRegiao.addItem("Selecione");
		cbRegiao.addItem("Agreste");
		cbRegiao.addItem("Sertão");
		cbRegiao.addItem("Metropolitana");
		cbRegiao.addItem("Zona da Mata");
		add(cbRegiao);
		
		txtProfOrient = new JTextField();
		txtProfOrient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtProfOrient.setColumns(10);
		txtProfOrient.setBounds(359, 176, 132, 24);
		add(txtProfOrient);
		
		JLabel lblNewLabel_5 = new JLabel("Nome do desafio:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(191, 416, 116, 24);
		add(lblNewLabel_5);
		
		txtNomeDesafio = new JTextField();
		txtNomeDesafio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeDesafio.setColumns(10);
		txtNomeDesafio.setBounds(359, 416, 132, 24);
		add(txtNomeDesafio);
		
		JLabel lblStatusDesafios = new JLabel("Desafio do momento:");
		lblStatusDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatusDesafios.setBounds(191, 451, 147, 24);
		add(lblStatusDesafios);
		
		cbDesafios = new JComboBox();
		cbDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbDesafios.setBounds(359, 451, 132, 24);
		add(cbDesafios);
		
		JButton btnAdicionarDesafi = new JButton("+");
		btnAdicionarDesafi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = txtNomeDesafio.getText();
				
				Desafios desafio = new Desafios();
				desafio.setNome(nome);
				desafio.setStatus(StatusDesafio.DESLIGADO);
				if(nome != null) {
					try {
						FachadaImp.getInstanciaFachada().inserirDesafios(desafio);
						txtNomeDesafio.setText("");
						JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
					} catch (BancoException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}else {
					JOptionPane.showMessageDialog(null, "Preencha o campo de nome");
				}
				
				
			}
			
		});
		btnAdicionarDesafi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionarDesafi.setBounds(503, 416, 46, 25);
		add(btnAdicionarDesafi);
		
		JButton btnCadastroGrupo = new JButton("Confirmar");
		btnCadastroGrupo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			String escola = txtNomeEscola.getText();
			String professor = txtProfOrient.getText();
			String serie = (String) cbSerie.getSelectedItem();
			int indexRegiao = cbRegiao.getSelectedIndex();
			Grupo grupo = new Grupo();
			grupo.setEscola(escola);
			grupo.setProfessor(professor);
			grupo.setSerie(serie);
			switch (indexRegiao) {
			case 1:
				grupo.setRegiao(Regiao.AGRESTE);
				break;
			case 2:
				grupo.setRegiao(Regiao.SERTAO);
				break;
			case 3:
				grupo.setRegiao(Regiao.METROPOLITANA);
				break;
			case 4:
				grupo.setRegiao(Regiao.ZONADAMATA);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Por favor selecione uma região");
				break;
			}
			
				try {
					if(grupo.getRegiao() != null) {
					FachadaImp.getInstanciaFachada().inserirGrupo(grupo);
					JOptionPane.showMessageDialog(null, "Escola cadastrada com sucesso");
					}
				} catch (BancoException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				limparCamposEscola();
			}
		});
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
	
	private void limparCamposEscola() {
		txtNomeEscola.setText("");
		txtProfOrient.setText("");
		cbRegiao.setSelectedIndex(0);
		cbSerie.setSelectedIndex(0);
		
	}
}
