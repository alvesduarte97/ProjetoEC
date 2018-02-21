package com.br.avaliacoes.ec.telas;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.InternalFrameUI;

import org.hibernate.Hibernate;

import com.br.avaliacoes.ec.DAO.HibernateUtil;
import com.br.avaliacoes.ec.modelo.Pessoa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PrincipalTela {

	private JFrame frmTorneioVirtualDe;
	private Button btnLogin;
	private Button btnCadastroAvaliador;
	private Label label;
	private JTextField textField;
	private JPasswordField passwordField;
	static JInternalFrame internalFrame;
	static Pessoa pessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalTela window = new PrincipalTela();
					window.frmTorneioVirtualDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalTela() {
		HibernateUtil.getSessionFactory();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTorneioVirtualDe = new JFrame();
		frmTorneioVirtualDe.getContentPane().setBackground(Color.WHITE);
		frmTorneioVirtualDe.getContentPane().setEnabled(false);
		frmTorneioVirtualDe.setResizable(false);
		frmTorneioVirtualDe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\Desktop\\interfaceec\\TVC LOGO E TIMBRADOS\\LOGO TVC DEZEMBRO 2017.png"));
		frmTorneioVirtualDe.setTitle("Torneio virtual de ci\u00EAncia");
		frmTorneioVirtualDe.setBounds(100, 100, 1073, 758);
		frmTorneioVirtualDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTorneioVirtualDe.getContentPane().setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFont(null);
		
ScrollPane ScrollPane1 = new ScrollPane();
		
		label = new Label("Menu");
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		label.setAlignment(Label.CENTER);
		label.setBounds(33, 20, 258, 35);
		frmTorneioVirtualDe.getContentPane().add(label);
		
		ScrollPane1.setBounds(21, 10, 276, 55);
		frmTorneioVirtualDe.getContentPane().add(ScrollPane1);
		
		
		Button button_3;
		btnCadastroAvaliador = new Button("Cadastro Avaliador");
		btnCadastroAvaliador.setBackground(Color.WHITE);
		btnCadastroAvaliador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastroTela telaCadastro = new CadastroTela();
				internalFrame.setContentPane(telaCadastro);
				internalFrame.revalidate();
			}
		});
		btnCadastroAvaliador.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCadastroAvaliador.setBounds(21, 189, 276, 55);
		frmTorneioVirtualDe.getContentPane().add(btnCadastroAvaliador);
		
		Button button_2;
		
		Button button_1;
		btnLogin = new Button("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				LoginTela telaLogin = new LoginTela();
				internalFrame.setContentPane(telaLogin);
				internalFrame.revalidate();
				
				
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		btnLogin.setBounds(21, 105, 276, 55);
		frmTorneioVirtualDe.getContentPane().add(btnLogin);
		
		scrollPane.setBounds(10, 0, 300, 257);
		frmTorneioVirtualDe.getContentPane().add(scrollPane);
		
		internalFrame = new JInternalFrame("");
		internalFrame.getContentPane().setBackground(Color.WHITE);
		internalFrame.setFrameIcon(null);
		internalFrame.setEnabled(false);
		internalFrame.getContentPane().setEnabled(false);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setBorder(null);
		internalFrame.setBounds(316, -24, 741, 713);
		internalFrame.setVisible(true);
		frmTorneioVirtualDe.getContentPane().add(internalFrame);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		
		
		ScrollPane scrollPane_2 = new ScrollPane();
		
		scrollPane_2.setBounds(136, 435, 100, 100);
		panel.add(scrollPane_2);
		
		
		JLabel Imagem2 = new JLabel("New label");
		ImageIcon icone1 =new ImageIcon("C:/Users/PC/git/ProjetoEC/AvaliacoesEC/src/img/LOGOTVC.png");
		Imagem2.setBounds(10, 342, 300, 300);
		Image imagi = icone1.getImage().getScaledInstance(Imagem2.getWidth(),Imagem2.getHeight(), Image.SCALE_SMOOTH);
		
		Imagem2.setIcon(new ImageIcon(imagi));
		frmTorneioVirtualDe.getContentPane().add(Imagem2);
		
		
		JLabel Imagem1 = new JLabel("New label");
		ImageIcon icone2 =new ImageIcon("C:/Users/PC/git/ProjetoEC/AvaliacoesEC/src/img/Rodape.png");
		Imagem1.setBounds(0, 691, 1067, 35);
		Image imagi2 = icone2.getImage().getScaledInstance(Imagem1.getWidth(),Imagem1.getHeight(), Image.SCALE_SMOOTH);
		
		Imagem1.setIcon(new ImageIcon(imagi2));
		frmTorneioVirtualDe.getContentPane().add(Imagem1);
		
		JLabel Imagem3 = new JLabel("New label");
		ImageIcon icone3 =new ImageIcon("C:/Users/PC/git/ProjetoEC/AvaliacoesEC/src/img/LogoTVC.png");
		Imagem3.setBounds(10, 336, 300, 300);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(),Imagem3.getHeight(), Image.SCALE_SMOOTH);
		
		Imagem3.setIcon(new ImageIcon(imagi3));
		frmTorneioVirtualDe.getContentPane().add(Imagem3);
		
		Imagem1.setIcon(new ImageIcon(imagi2));
		frmTorneioVirtualDe.getContentPane().add(Imagem1);
		
		
	
		
		
	}
}
