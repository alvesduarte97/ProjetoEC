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
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class CadastroGrupoTela extends BaseOrgTela {
	private JTextField txtNomeGrupo;
	private JTextField txtProfOrient;
	private JComboBox cbRegiao;
	private JComboBox cbSerie;

	/**
	 * Create the panel.
	 */
	public CadastroGrupoTela() {
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(322, 5, 0, 0);
		add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Escola:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(223, 83, 127, 24);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Serie:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(223, 190, 46, 24);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Regi\u00E3o:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(223, 155, 73, 24);
		add(lblNewLabel_3);
		
		txtNomeGrupo = new JTextField();
		txtNomeGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeGrupo.setBounds(384, 83, 132, 24);
		add(txtNomeGrupo);
		txtNomeGrupo.setColumns(10);
		
		cbSerie = new JComboBox();
		cbSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbSerie.setBounds(384, 192, 132, 24);
		cbSerie.addItem("Selecione");
		cbSerie.addItem("1ª Serie");
		cbSerie.addItem("2ª Serie");
		cbSerie.addItem("3ª Serie");
		cbSerie.addItem("4ª Serie");
		cbSerie.addItem("5ª Serie");
		add(cbSerie);
		
		JLabel lblNewLabel_4 = new JLabel("Professor orientador:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(223, 118, 136, 24);
		add(lblNewLabel_4);
		
		cbRegiao = new JComboBox();
		cbRegiao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbRegiao.setBounds(384, 155, 132, 24);
		cbRegiao.addItem("Selecione");
		cbRegiao.addItem("Agreste");
		cbRegiao.addItem("Sertão");
		cbRegiao.addItem("Metropolitana");
		cbRegiao.addItem("Zona da Mata");
		add(cbRegiao);
		
		txtProfOrient = new JTextField();
		txtProfOrient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtProfOrient.setColumns(10);
		txtProfOrient.setBounds(384, 118, 132, 24);
		add(txtProfOrient);
		
		JButton btnCadastroGrupo = new JButton("Confirmar");
		btnCadastroGrupo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			String escola = txtNomeGrupo.getText();
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
		btnCadastroGrupo.setBounds(223, 253, 293, 25);
		add(btnCadastroGrupo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-38, 70, 796, 2);
		add(separator_1);
		
		JLabel lblNewLabel_6 = new JLabel("Cadastro Grupo");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(0, 35, 751, 24);
		add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-23, 289, 796, 2);
		add(separator);
		
		JLabel lblRemoverEscola = new JLabel("Remover Grupo");
		lblRemoverEscola.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverEscola.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRemoverEscola.setBounds(0, 302, 751, 24);
		add(lblRemoverEscola);
		
		JLabel lblEscolasCadastradas = new JLabel("Grupos cadastradas");
		lblEscolasCadastradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolasCadastradas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscolasCadastradas.setBounds(0, 350, 741, 24);
		add(lblEscolasCadastradas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 385, 293, 133);
		add(scrollPane);
		
		JList listGrupoCadastrada = new JList();
		scrollPane.setViewportView(listGrupoCadastrada);
		listGrupoCadastrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRemovEscola = new JButton("Remover");
		btnRemovEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemovEscola.setBounds(223, 529, 293, 25);
		add(btnRemovEscola);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-23, 337, 796, 2);
		add(separator_2);
		

	}


	private void limparCamposEscola() {
		txtNomeGrupo.setText("");
		txtProfOrient.setText("");
		cbRegiao.setSelectedIndex(0);
		cbSerie.setSelectedIndex(0);
		
	}
}
