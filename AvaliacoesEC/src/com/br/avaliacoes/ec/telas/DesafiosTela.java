package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.StatusDesafio;
import com.br.avaliacoes.ec.servidor.IServidor;

public class DesafiosTela extends BaseOrgTela {
	private JTextField txtNomeDesafio;
	private String desafioAtivo;
	private List<Desafios> desafios;
	private JButton btnAtualizar;
	private JTextField txtDesafioDoMomento;
	private JButton btnRemover;

	/**
	 * Create the panel.
	 */
	public DesafiosTela(IServidor servidor) {
		super(servidor);

		JSeparator separator = new JSeparator();
		separator.setBounds(-25, 167, 796, 2);
		add(separator);

		JLabel label_1 = new JLabel("Nome do desafio:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(209, 180, 116, 24);
		add(label_1);

		txtNomeDesafio = new JTextField();
		txtNomeDesafio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeDesafio.setColumns(10);
		txtNomeDesafio.setBounds(377, 180, 153, 24);
		add(txtNomeDesafio);

		// JButton btnAdicionar = new JButton("Ativar");
		// btnAdicionar.addActionListener(new ActionListener() {
		//
		// public void actionPerformed(ActionEvent arg0) {
		// String nome =
		// Desafios desafio = FachadaImp.getInstanciaFachada().procurarDesafios(nome);
		// }
		// });
		// btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		// btnAdicionar.setBounds(209, 467, 310, 25);
		// add(btnAdicionar);

		JButton btnAdicionarDesafio = new JButton("Adicionar Desafio");
		btnAdicionarDesafio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNomeDesafio.getText();
				Desafios desafio = new Desafios();

				desafio.setNome(nome);
				desafio.setStatus(StatusDesafio.DESLIGADO);

				try {
					servidor.inserirDesafios(desafio);
					txtNomeDesafio.setText("");
					JOptionPane.showMessageDialog(null, "Desafio adicionado com sucesso");
				} catch (BancoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (RemoteException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnAdicionarDesafio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionarDesafio.setBounds(377, 215, 153, 25);
		add(btnAdicionarDesafio);

		JLabel lblCadastroDesafio = new JLabel("Cadastro Desafio");
		lblCadastroDesafio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDesafio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastroDesafio.setBounds(0, 132, 741, 24);
		add(lblCadastroDesafio);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-25, 251, 796, 2);
		add(separator_1);

		JLabel lblConfigurarDesafios = new JLabel("Configurar");
		lblConfigurarDesafios.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfigurarDesafios.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfigurarDesafios.setBounds(0, 264, 741, 24);
		add(lblConfigurarDesafios);

		JTextPane txtRenomear = new JTextPane();
		txtRenomear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRenomear.setBounds(209, 529, 310, 24);
		add(txtRenomear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 347, 310, 109);
		add(scrollPane);

		DefaultListModel modelDesafios = new DefaultListModel();
		try {
			desafios = servidor.listaDesafios();
		} catch (RemoteException e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

		for (Desafios desafio : desafios) {
			if (desafio.getStatus().equals(StatusDesafio.DESLIGADO)) {
				modelDesafios.addElement(desafio.getNome());
			} else {
				desafioAtivo = desafio.getNome();
			}
		}

		JList listDesafios = new JList(modelDesafios);
		scrollPane.setViewportView(listDesafios);
		listDesafios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-15, 299, 796, 2);
		add(separator_2);

		JLabel lblDesafios = new JLabel("Desafios desativos:");
		lblDesafios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesafios.setBounds(209, 312, 144, 24);
		add(lblDesafios);

		JButton btnRenomear = new JButton("Renomear");
		btnRenomear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nomeDesafio = (String) listDesafios.getSelectedValue();
				try {
					Desafios desafio =  servidor.procurarDesafios(nomeDesafio);
					desafio.setNome(txtRenomear.getText());
					servidor.removerDesafios(nomeDesafio);
					servidor.inserirDesafios(desafio);
					modelDesafios.removeElement(nomeDesafio);
					modelDesafios.addElement(desafio.getNome());
					txtRenomear.setText("");
					
				} catch (BancoException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (RemoteException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnRenomear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRenomear.setBounds(209, 564, 310, 25);
		add(btnRenomear);

		JButton btnAdicionar = new JButton("Ativar");
		btnAdicionar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String nome = (String) listDesafios.getSelectedValue();
				Date data = new Date();
				DateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
				String dataFormatada = formatarData.format(data);

				try {

					// Capturando o desafio a ser desligado e atualizando ele no banco
					if (desafioAtivo != null) {
						Desafios desativar = servidor.procurarDesafios(desafioAtivo);
						desativar.setStatus(StatusDesafio.DESLIGADO);
						desativar.setDataFim(dataFormatada);
						servidor.atualizarDesafios(desativar);
						modelDesafios.addElement(desativar.getNome());
						
					}
					
					// capturando o desafio a ser ativado e atualizando ele no banco
					Desafios desafio = servidor.procurarDesafios(nome);
					desafio.setStatus(StatusDesafio.ATIVO);
					desafio.setDataInicio(dataFormatada);
					servidor.atualizarDesafios(desafio);
					desafioAtivo = desafio.getNome();

					// Atualizando jlist e txtDesafioAtivo
					modelDesafios.removeElement(desafio.getNome());
					txtDesafioDoMomento.setText(desafioAtivo);
					//desafios = FachadaImp.getInstanciaFachada().listaDesafios();
					JOptionPane.showMessageDialog(null, "Desafio ativado");
				} catch (BancoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (RemoteException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionar.setBounds(209, 497, 310, 25);
		add(btnAdicionar);
		ImageIcon icone1 = new ImageIcon("C:/Users/PC/git/ProjetoEC/AvaliacoesEC/src/img/Fundo2.jpg");
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				DesafiosTela desTela = new DesafiosTela(servidor);
				PrincipalTela.internalFrame.setContentPane(desTela);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		btnAtualizar.setBounds(640, 28, 89, 23);
		add(btnAtualizar);
		
		JLabel lblDesafioDoMomento = new JLabel("Desafio do momento:");
		lblDesafioDoMomento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesafioDoMomento.setBounds(209, 49, 321, 14);
		add(lblDesafioDoMomento);
		
		txtDesafioDoMomento = new JTextField();
		txtDesafioDoMomento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDesafioDoMomento.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtDesafioDoMomento.setEditable(false);
		txtDesafioDoMomento.setBounds(209, 75, 321, 22);
		txtDesafioDoMomento.setText(desafioAtivo);
		add(txtDesafioDoMomento);
		
		btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String desafio = (String) listDesafios.getSelectedValue();
				try {
					int resposta = JOptionPane.showConfirmDialog
						(null, "Tem certeza que deseja remover?", "Confirmação", JOptionPane.YES_NO_OPTION);
					if(resposta == JOptionPane.YES_OPTION) {
						servidor.removerDesafios(desafio);
						modelDesafios.removeElement(desafio);
						JOptionPane.showMessageDialog(null, "Desafio removido");
					}
				} catch (BancoException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (RemoteException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRemover.setBounds(209, 467, 310, 25);
		add(btnRemover);

		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 =new ImageIcon(LoginTela.class.getResource("/imgfundo.jpg"));
		Imagem3.setBounds(0, 17, 741, 678);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(),Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);
	}
}
