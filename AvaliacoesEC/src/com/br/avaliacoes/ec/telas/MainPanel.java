package com.br.avaliacoes.ec.telas;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.InternalFrameUI;

import org.hibernate.Hibernate;

import com.br.avaliacoes.ec.DAO.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;

public class MainPanel {

	private JFrame frmTorneioVirtualDe;
	private Button btnLogin;
	private Button btnCadastroAvaliador;
	private Label label;
	private Button btnAdministração;
	private JTextField textField;
	private JPasswordField passwordField;
	private JInternalFrame internalFrame;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
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
	public MainPanel() {
		HibernateUtil.getSessionFactory();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTorneioVirtualDe = new JFrame();
		frmTorneioVirtualDe.setResizable(false);
		frmTorneioVirtualDe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\ProjectEC1.1\\src\\Img\\tvc.png"));
		frmTorneioVirtualDe.setTitle("Torneio virtual de ci\u00EAncia");
		frmTorneioVirtualDe.setBounds(100, 100, 1073, 717);
		frmTorneioVirtualDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTorneioVirtualDe.getContentPane().setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFont(null);
		
		label = new Label("Menu");
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		label.setAlignment(Label.CENTER);
		label.setBounds(21, 45, 270, 35);
		frmTorneioVirtualDe.getContentPane().add(label);
		
		btnAdministração = new Button("Administra\u00E7\u00E3o");
		btnAdministração.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				CadastroTVC tuabunda = new CadastroTVC();
			
				internalFrame.setContentPane(tuabunda);
				internalFrame.revalidate();
				
			}
		});
		btnAdministração.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAdministração.setBounds(21, 602, 276, 55);
		frmTorneioVirtualDe.getContentPane().add(btnAdministração);
		
		Button button_3;
		btnCadastroAvaliador = new Button("Cadastro Avaliador");
		btnCadastroAvaliador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroTVC telaCadastro = new CadastroTVC();
				internalFrame.setContentPane(telaCadastro);
				internalFrame.revalidate();
			}
		});
		btnCadastroAvaliador.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCadastroAvaliador.setBounds(22, 257, 276, 55);
		frmTorneioVirtualDe.getContentPane().add(btnCadastroAvaliador);
		
		Button button_2;
		
		Button button_1;
		btnLogin = new Button("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				LoginTVC telaLogin = new LoginTVC();
				internalFrame.setContentPane(telaLogin);
				internalFrame.revalidate();
				
				
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		btnLogin.setBounds(21, 156, 276, 55);
		frmTorneioVirtualDe.getContentPane().add(btnLogin);
		
		scrollPane.setBounds(10, 10, 300, 659);
		frmTorneioVirtualDe.getContentPane().add(scrollPane);
		
		internalFrame = new JInternalFrame("");
		internalFrame.setEnabled(false);
		internalFrame.getContentPane().setEnabled(false);
		
		panel_1 = new JPanel();
		internalFrame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(331, 11, 1, 1);
		panel_1.add(desktopPane);
		internalFrame.setBorder(null);
		internalFrame.setBounds(316, 10, 741, 668);
		frmTorneioVirtualDe.getContentPane().add(internalFrame);
		internalFrame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		
		
		ScrollPane scrollPane_2 = new ScrollPane();
		
		scrollPane_2.setBounds(136, 435, 100, 100);
		panel.add(scrollPane_2);
		
		
		
		
		
		
	
		
		
	}
}
