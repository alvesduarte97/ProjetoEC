package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import com.br.avaliacoes.ec.fachada.FachadaImp;

public class AvaOrganizadorTela extends JPanel{
	private JMenuBar menuBar;
	private JMenuItem mntmAddRemovOrg;
	private JMenuItem mntmTelaPrincipal;
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
	private String desafioAtivo = "";
	
	
	public AvaOrganizadorTela() {
		setLayout(null);
		setSize(741,685);
		
		
	
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 790, 21);
		add(menuBar);
		
		JMenu mnOrganizador = new JMenu("Organizador");
		menuBar.add(mnOrganizador);
		
		mntmAddRemovOrg = new JMenuItem("Adicionar/Remover");
		mntmAddRemovOrg.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//AddOrgTela addOrg = new AddOrgTela();
//				PrincipalTela.internalFrame.setContentPane(addOrg);
//				PrincipalTela.internalFrame.revalidate();
			}
		});
		
		mntmTelaPrincipal = new JMenuItem("Tela Principal");
		mntmTelaPrincipal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//OrganizadorTela telaOrg = new OrganizadorTela();
//				PrincipalTela.internalFrame.setContentPane(telaOrg);
//				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnOrganizador.add(mntmTelaPrincipal);
		mnOrganizador.add(mntmAddRemovOrg);
		
		JMenu mnGrupos = new JMenu("Grupos");
		menuBar.add(mnGrupos);
		
		JMenuItem mntmCadastRemovGrup = new JMenuItem("Cadastrar/Remover");
		mntmCadastRemovGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GrupoTela cadGru  = new GrupoTela();
				PrincipalTela.internalFrame.setContentPane(cadGru);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnGrupos.add(mntmCadastRemovGrup);
		
		JMenu mnDesafios = new JMenu("Desafios");
		menuBar.add(mnDesafios);
		
		JMenuItem mntmCadastRemovDesafios = new JMenuItem("Cadastrar/Remover");
		mntmCadastRemovDesafios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesafiosTela desTela = new DesafiosTela();
				PrincipalTela.internalFrame.setContentPane(desTela);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnDesafios.add(mntmCadastRemovDesafios);
		
		JMenu mnAvaliao = new JMenu("Avalia\u00E7\u00E3o");
		menuBar.add(mnAvaliao);
		
		JMenuItem mntmAvaliar = new JMenuItem("Avaliar");
		mntmAvaliar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AvaOrganizadorTela telaAva = new AvaOrganizadorTela();
				PrincipalTela.internalFrame.setContentPane(telaAva);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		mnAvaliao.add(mntmAvaliar);
		
		JMenuItem mntmGerarPdf = new JMenuItem("Gerar PDF");
		mnAvaliao.add(mntmGerarPdf);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginTela logTela = new LoginTela();
				PrincipalTela.internalFrame.setContentPane(logTela);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		//btnSair.setBounds(7, 601, 80, 56);
		btnSair.setBounds(10, 601, 80, 56);
		add(btnSair);
		ImageIcon icone3 =new ImageIcon(LoginTela.class.getResource("/img/Fundo2.jpg"));
		
		setLayout(null);
		setSize(741, 668);

		desafioAtivo = FachadaImp.getInstanciaFachada().desafioAtivo().getNome();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 527, 376, 63);
		add(scrollPane);

		txtComentario = new JTextArea();
		scrollPane.setViewportView(txtComentario);
		txtComentario.setLineWrap(true);

		JLabel lblNewLabel = new JLabel("Comentario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(178, 502, 86, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nota 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(157, 424, 46, 14);
		add(lblNewLabel_1);

		cbNota1 = new JComboBox();
		cbNota1.setModel(new DefaultComboBoxModel(new String[] { "0,1", "0,2", "0,3", "0,4" }));
		cbNota1.setBounds(157, 449, 46, 20);
		add(cbNota1);

		cbNota2 = new JComboBox();
		cbNota2.setModel(new DefaultComboBoxModel(new String[] { "0,1", "0,2", "0,3", "0,4" }));
		cbNota2.setBounds(255, 449, 46, 20);
		add(cbNota2);

		cbNota3 = new JComboBox();
		cbNota3.setModel(new DefaultComboBoxModel(new String[] { "0,1", "0,2", "0,3", "0,4" }));
		cbNota3.setBounds(347, 449, 46, 20);
		add(cbNota3);

		cbNota4 = new JComboBox();
		cbNota4.setModel(new DefaultComboBoxModel(new String[] { "0,1", "0,2", "0,3", "0,4" }));
		cbNota4.setBounds(438, 449, 46, 20);
		add(cbNota4);

		JLabel label = new JLabel("Nota 2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(255, 424, 46, 14);
		add(label);

		JLabel label_1 = new JLabel("Nota 3");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(347, 424, 46, 14);
		add(label_1);

		JLabel label_3 = new JLabel("Nota 4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(438, 424, 46, 14);
		add(label_3);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setBounds(178, 601, 376, 56);
		add(btnConfirmar);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(-27, 594, 796, 8);
		add(separator1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 497, 796, 8);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-27, 410, 796, 2);
		add(separator_2);

		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setBounds(308, 385, 36, 14);
		add(lblEscola);

		txtEscola = new TextField();
		txtEscola.setBounds(354, 382, 198, 22);
		add(txtEscola);
		txtEscola.setEditable(false);
		txtEscola.setEnabled(false);

		JLabel lblSerie = new JLabel("Serie:");
		lblSerie.setBounds(579, 385, 36, 14);
		add(lblSerie);

		txtSerie = new TextField();
		txtSerie.setBounds(621, 382, 63, 22);
		add(txtSerie);
		txtSerie.setEditable(false);
		txtSerie.setEnabled(false);

		JLabel lblDesafio = new JLabel("Desafio:");
		lblDesafio.setBounds(50, 385, 46, 14);
		add(lblDesafio);

		txtDesafio = new TextField();
		txtDesafio.setEditable(false);
		txtDesafio.setBounds(102, 382, 186, 22);
		txtDesafio.setText(desafioAtivo);
		add(txtDesafio);

		JLabel Imagem3 = new JLabel("");
		ImageIcon icone4 = new ImageIcon(LoginTela.class.getResource("/img/Fundo2.jpg"));
		Imagem3.setBounds(0, 21, 741, 668);
		Image imagi3 = icone4.getImage().getScaledInstance(Imagem3.getWidth(), Imagem3.getHeight(), Image.SCALE_SMOOTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(520, 449, 46, 20);
		add(comboBox);
		
		JLabel lblNota = new JLabel("Nota 5");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNota.setBounds(520, 424, 46, 14);
		add(lblNota);
		Imagem3.setIcon(new ImageIcon(imagi3));
		add(Imagem3);
	}
}
