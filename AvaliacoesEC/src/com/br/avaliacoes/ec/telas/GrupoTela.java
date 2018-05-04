package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.modelo.Regiao;
import com.br.avaliacoes.ec.servidor.IServidor;

public class GrupoTela extends BaseOrgTela {
	private JTextField txtNomeGrupo;
	private JTextField txtProfOrient;
	private JComboBox cbRegiao;
	private JComboBox cbSerie;
	List<Grupo> listaGrupos;

	/**
	 * Create the panel.
	 */
	public GrupoTela(IServidor servidor) {
		super(servidor);
		setLayout(null);
		
		listaGrupos = null;
		
		JLabel label = new JLabel("");
		label.setBounds(322, 5, 0, 0);
		add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Escola:");
		lblNewLabel_1.setBounds(219, 107, 127, 24);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("S\u00E9rie:");
		lblNewLabel_2.setBounds(219, 214, 46, 24);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_2);
		 
		JLabel lblNewLabel_3 = new JLabel("Regi\u00E3o:");
		lblNewLabel_3.setBounds(219, 179, 73, 24);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_3);
		
		txtNomeGrupo = new JTextField();
		txtNomeGrupo.setBounds(380, 107, 132, 24);
		txtNomeGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(txtNomeGrupo);
		txtNomeGrupo.setColumns(10);
		
		cbSerie = new JComboBox();
		cbSerie.setBounds(380, 216, 132, 24);
		cbSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//cbSerie.addItem("Selecione");
		cbSerie.addItem("8 Ano");
		cbSerie.addItem("9 Ano");
		cbSerie.addItem("1 Ano");
		cbSerie.addItem("2 Ano");
		cbSerie.addItem("3 Ano");
		add(cbSerie);
		
		JLabel lblNewLabel_4 = new JLabel("Professor orientador:");
		lblNewLabel_4.setBounds(219, 142, 136, 24);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_4);
		
		cbRegiao = new JComboBox();
		cbRegiao.setBounds(380, 179, 132, 24);
		cbRegiao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbRegiao.addItem("Selecione");
		cbRegiao.addItem("Agreste");
		cbRegiao.addItem("Sertão");
		cbRegiao.addItem("Metropolitana");
		cbRegiao.addItem("Zona da Mata");
		add(cbRegiao);
		
		txtProfOrient = new JTextField();
		txtProfOrient.setBounds(380, 142, 132, 24);
		txtProfOrient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtProfOrient.setColumns(10);
		add(txtProfOrient);
		
		JButton btnCadastroGrupo = new JButton("Confirmar");
		btnCadastroGrupo.setBounds(219, 277, 293, 25);
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
						servidor.inserirGrupo(grupo);
					JOptionPane.showMessageDialog(null, "Escola cadastrada com sucesso");
					}
				} catch (BancoException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (RemoteException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				limparCamposEscola();
			}
		});
		btnCadastroGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnCadastroGrupo);
		
		JLabel lblNewLabel_6 = new JLabel("Cadastro Grupo");
		lblNewLabel_6.setBounds(-4, 67, 751, 24);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNewLabel_6);
		
		JLabel lblRemoverEscola = new JLabel("Remover Grupo");
		lblRemoverEscola.setBounds(-4, 326, 751, 24);
		lblRemoverEscola.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverEscola.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblRemoverEscola);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 385, 293, 133);
		add(scrollPane);
		
		DefaultListModel modelGrupos = new DefaultListModel();
//		List<Grupo> listaGrupos = null;
		try {
			listaGrupos = servidor.listaGrupos();
		} catch (RemoteException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		for(Grupo grupo : listaGrupos) {
			modelGrupos.addElement(grupo.getEscola() +"   |   "+ grupo.getSerie());
		}
		JList listGrupoCadastrada = new JList(modelGrupos);
		scrollPane.setViewportView(listGrupoCadastrada);
		listGrupoCadastrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRemovEscola = new JButton("Remover");
		btnRemovEscola.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String selecao = (String) listGrupoCadastrada.getSelectedValue();
				
				//Para pegar apenas o nome da escola que esta na string de selecao
				String escola = selecao.substring(0, selecao.indexOf("|")-3);
				String serie = selecao.substring(selecao.indexOf("|")+4, selecao.length());
				
				for(Grupo grupo : listaGrupos) {
					if(grupo.getEscola().equals(escola) && grupo.getSerie().equals(serie)) {
						try {
							servidor.removerGrupo(grupo.getIdGrupo());
							listaGrupos.remove(grupo);
							modelGrupos.removeElement(selecao);
						} catch (BancoException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage());
						} catch (RemoteException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				}
				
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 91, 741, 2);
		add(separator_2);
		btnRemovEscola.setBounds(219, 553, 293, 25);
		btnRemovEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnRemovEscola);
		
		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 =new ImageIcon(LoginTela.class.getResource("/imgfundo.jpg"));
		Imagem3.setBounds(0, 17, 741, 678);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(),Imagem3.getHeight(), Image.SCALE_SMOOTH);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-4, 313, 772, 2);
		add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 372, 741, 2);
		add(separator);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);

	}


	private void limparCamposEscola() {
		txtNomeGrupo.setText("");
		txtProfOrient.setText("");
		cbRegiao.setSelectedIndex(0);
		cbSerie.setSelectedIndex(0);
		
	}
}
