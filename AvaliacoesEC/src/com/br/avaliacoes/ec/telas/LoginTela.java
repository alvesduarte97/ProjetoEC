package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;
import com.br.avaliacoes.ec.negocio.PessoaBOImp;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginTela extends JPanel {
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnConfirmarLogin;

	/**
	 * Create the panel.
	 */
	public LoginTela() {
		setSize(741, 668);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(322, 204, 100, 50);
		add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLogin.setBounds(247, 290, 154, 26);
		add(txtLogin);
		txtLogin.setColumns(10);
		
				txtSenha = new JPasswordField();
				txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtSenha.setBounds(247, 365, 154, 26);
				add(txtSenha);

		JLabel lblNewLabel_1 = new JLabel("Us\u00FAario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(247, 265, 86, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(247, 340, 86, 14);
		add(lblNewLabel_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-24, 252, 877, 2);
		add(separator_2);

		JLabel Imagem2 = new JLabel("New label");
		ImageIcon icone1 = new ImageIcon(LoginTela.class.getResource("/img/login.png"));
		Imagem2.setBounds(411, 266, 63, 51);
		Image imagi = icone1.getImage().getScaledInstance(Imagem2.getWidth(), Imagem2.getHeight(), Image.SCALE_SMOOTH);
		Imagem2.setIcon(new ImageIcon(imagi));
		add(Imagem2);

		btnConfirmarLogin = new JButton("Confirmar");
		btnConfirmarLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String login = txtLogin.getText();
				String senha = new String(txtSenha.getPassword());
				String senhaCrip = PessoaBOImp.criptografar(senha);
				try {
					Pessoa pessoa = FachadaImp.getInstanciaFachada().procurarPessoa(login);
					if (!pessoa.getSenha().equals(senhaCrip)) {
						txtSenha.setText("");
						JOptionPane.showMessageDialog(null, "Senha incorreta");
					} else {
						PrincipalTela.pessoa = pessoa;
						String desafioAtivo = FachadaImp.getInstanciaFachada().desafioAtivo().getNome();
						if (pessoa.getDesafioAvaliado() == null || pessoa.getSerie() == null|| !pessoa.getDesafioAvaliado().equals(desafioAtivo)) {

							JDialog.setDefaultLookAndFeelDecorated(true);
							String[] selectionValues = { "1ª Serie", "2ª Serie", "3ª Serie", "4ª Serie", "5ª Serie" };
							String selection = null;
							while (selection == null || selection.equals("")) {
								String initialSelection = "1ª Serie";
								selection = (String) JOptionPane.showInputDialog(null, "Selecione uma serie", "Series",
										JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
								if (selection == null || selection.equals("")) {
									JOptionPane.showMessageDialog(null, "Escolha uma serie");
									
								}
							}
							pessoa.setSerie((String) selection);
							pessoa.setDesafioAvaliado(desafioAtivo);
							FachadaImp.getInstanciaFachada().atualizarPessoa(pessoa);

						}
						if (pessoa.getTipo().equals(TipoPessoa.ORGANIZACAO)) {
							OrganizadorTela telaOrg = new OrganizadorTela();
							PrincipalTela.internalFrame.setContentPane(telaOrg);
							PrincipalTela.internalFrame.revalidate();
						} else {
							List<Grupo> listaGrupos = null;
							try {
								listaGrupos = FachadaImp.getInstanciaFachada().listaGruposPorSerie
										(PrincipalTela.pessoa.getSerie(), PrincipalTela.desafioAtivo.getNome());
							} catch (BancoException e1) {
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							AvaliacaoTela telaAva = new AvaliacaoTela(0, listaGrupos);
							PrincipalTela.internalFrame.setContentPane(telaAva);
							PrincipalTela.internalFrame.revalidate();

						}

					}
				} catch (BancoException e) {
					txtLogin.setText("");
					txtSenha.setText("");
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnConfirmarLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmarLogin.setBounds(244, 411, 230, 46);
		add(btnConfirmarLogin);

		JLabel Imagem1 = new JLabel("New label");
		ImageIcon icone2 = new ImageIcon(LoginTela.class.getResource("/img/key.png"));
		Imagem1.setBounds(411, 340, 63, 51);
		Image imagi2 = icone2.getImage().getScaledInstance(Imagem1.getWidth(), Imagem1.getHeight(), Image.SCALE_SMOOTH);
		Imagem1.setIcon(new ImageIcon(imagi2));
		add(Imagem1);

		JSeparator separator = new JSeparator();
		separator.setBounds(-74, 402, 877, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-74, 468, 877, 2);
		add(separator_1);

		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 = new ImageIcon(LoginTela.class.getResource("/img/Fundo2.jpg"));
		Imagem3.setBounds(0, 0, 741, 668);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(), Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);

	}
	
	
}
