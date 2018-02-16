package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.AreaAtuacao;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroTVC extends JPanel {
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmaçãoSenha;
	private JComboBox cbArea;

	/**
	 * Create the panel.
	 */
	public CadastroTVC() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		
		JLabel label = new JLabel("\u00C1rea de atua\u00E7\u00E3o:");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(10, 266, 126, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Cadastro");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_1.setBounds(64, 11, 182, 37);
		add(label_1);
		
		JLabel label_2 = new JLabel("Nome e sobrenome:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(10, 72, 160, 14);
		add(label_2);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 97, 299, 20);
		add(txtNome);
		
		JLabel label_3 = new JLabel("Nome do usu\u00E1rio:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(10, 128, 144, 14);
		add(label_3);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLogin.setColumns(10);
		txtLogin.setBounds(10, 153, 299, 20);
		add(txtLogin);
		
		JLabel label_4 = new JLabel("Senha:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(10, 197, 70, 14);
		add(label_4);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSenha.setBounds(10, 222, 126, 20);
		add(txtSenha);
		
		JLabel label_5 = new JLabel("Confirmar senha:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(165, 197, 144, 14);
		add(label_5);
		
		txtConfirmaçãoSenha = new JPasswordField();
		txtConfirmaçãoSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtConfirmaçãoSenha.setBounds(165, 222, 144, 20);
		add(txtConfirmaçãoSenha);
		
		JLabel label_6 = new JLabel("Serie a ser avalida:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(165, 266, 153, 14);
		add(label_6);
		
		JButton button_1 = new JButton("Confirmar");
		button_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String login = txtLogin.getText();
				int indexArea = cbArea.getSelectedIndex();
				String senha;
				
				if(new String(txtSenha.getPassword()).equals(new String(txtConfirmaçãoSenha.getPassword()))) {
					senha = new String(txtSenha.getPassword());
					Pessoa avaliador = new Pessoa();
					avaliador.setLogin(login);
					avaliador.setNome(nome);
					avaliador.setSenha(senha);
					avaliador.setTipo(TipoPessoa.AVALIADOR);
					switch (indexArea) {
					case 0:
						avaliador.setArea(AreaAtuacao);
						break;
						
					case 1:
						avaliador.setArea(AreaAtuacao);
						break;
					case 2:
						avaliador.setArea(AreaAtuacao);
						break;
					case 3:
						avaliador.setArea(AreaAtuacao);
						break;
					case 4:
						avaliador.setArea(AreaAtuacao);
						break;
					default:
						break;
					}
					
					limparCampos();
					try {
						FachadaImp.getInstanciaFachada().inserirPessoa(avaliador);
					} catch (BancoException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}else {
					txtSenha.setText("");
					txtConfirmaçãoSenha.setText("");
					JOptionPane.showMessageDialog(null, "Senhas diferentes");
				}

				
				//avaliador.setArea();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(10, 419, 299, 41);
		add(button_1);
		
		cbArea = new JComboBox();
		//cbArea.setModel(new DefaultComboBoxModel(new String[] {"Biologia", "Cordena\u00E7\u00E3o", "F\u00EDsica", "Geografia", "Histor\u00EDa", "Matem\u00E1tica", "Qu\u00EDmica", "Recep\u00E7\u00E3o", "Rob\u00F3tica"}));
		cbArea.setMaximumRowCount(5);
		cbArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbArea.setBounds(7, 291, 129, 20);
		cbArea.addItem("Selecionar area");
		add(cbArea);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-20, 253, 600, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-89, 184, 600, 2);
		add(separator_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3\u00BA ano", "2\u00BA ano", "1\u00BA ano", "9\u00BA ano", "8\u00BA ano", "7\u00BA ano"}));
		comboBox.setMaximumRowCount(5);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(165, 291, 129, 20);
		add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-20, 59, 600, 2);
		add(separator);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(-20, 406, 600, 2);
		add(separator_3);

	}
	private void limparCampos() {
		txtConfirmaçãoSenha.setText("");
		txtLogin.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		cbArea.setSelectedIndex(0);
	}

}
