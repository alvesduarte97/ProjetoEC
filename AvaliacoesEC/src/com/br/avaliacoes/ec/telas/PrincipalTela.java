package com.br.avaliacoes.ec.telas;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import com.br.avaliacoes.ec.DAO.HibernateUtil;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.servidor.IServidor;

public class PrincipalTela {

	static JFrame frmTorneioVirtualDe;
	private Button btnLogin;
	private Button btnCadastroAvaliador;
	private Label label;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private IServidor meuServidor;
	
	static JInternalFrame internalFrame;
	static Pessoa pessoa;
	static Desafios desafioAtivo;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PrincipalTela window = new PrincipalTela();
//					window.frmTorneioVirtualDe.setVisible(true);
					
					
					
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {

								File policyFile = new File("security/security.policy");

								InputStream fis = PrincipalTela.class.getClassLoader()
										.getResourceAsStream("serverconfig.properties");
								Properties prop = new Properties();
								prop.load(fis);

								String ipServer = prop.getProperty("server_ip");

								System.out.println(ipServer);
								String porta = prop.getProperty("server_port");

								System.setProperty("java.security.policy",
										policyFile.getCanonicalPath());

								System.setSecurityManager(new SecurityManager());
								System.setProperty("java.rmi.server.hostname", ipServer);

								Registry r = LocateRegistry.getRegistry(ipServer,
										Integer.parseInt(porta));
								final IServidor meuServidor = (IServidor) r
										.lookup("meuServidor");
								
								//Iniciando a tela cliente
								PrincipalTela window = new PrincipalTela(meuServidor);
								window.frmTorneioVirtualDe.setVisible(true);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalTela(IServidor meuServidor) {
		this.meuServidor = meuServidor;
		initialize();
	}

	private void initialize() {
		
		try {
			desafioAtivo = meuServidor.desafioAtivo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
		}
		
		frmTorneioVirtualDe = new JFrame();
		frmTorneioVirtualDe.getContentPane().setBackground(Color.WHITE);
		frmTorneioVirtualDe.getContentPane().setEnabled(false);
		frmTorneioVirtualDe.setResizable(false);
		frmTorneioVirtualDe.setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalTela.class.getResource("/img/LogoTVC.png")));
		frmTorneioVirtualDe.setTitle("Torneio virtual de ci\u00EAncia");
		frmTorneioVirtualDe.setBounds(100, 100, 1060, 720);
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
		btnCadastroAvaliador = new Button("Cadastro");
		btnCadastroAvaliador.setBackground(Color.WHITE);
		btnCadastroAvaliador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastroTela telaCadastro = new CadastroTela(meuServidor);
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
				LoginTela telaLogin = new LoginTela(meuServidor);
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
		
		JLabel Imagem4 = new JLabel("");
		ImageIcon icone4 =new ImageIcon(PrincipalTela.class.getResource("/gif3.gif"));
		Imagem4.setBounds(200, 167, 350, 350);
		internalFrame.getContentPane().add(Imagem4);
		Image imagi4 = icone4.getImage().getScaledInstance(Imagem4.getWidth(),Imagem4.getHeight(), Image.SCALE_SMOOTH);
		Imagem4.setIcon(new ImageIcon(imagi4));
		internalFrame.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		internalFrame.setBounds(316, -24, 741, 716);
		internalFrame.setVisible(true);
		frmTorneioVirtualDe.getContentPane().add(internalFrame);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		
		
		ScrollPane scrollPane_2 = new ScrollPane();
		
		scrollPane_2.setBounds(136, 435, 100, 100);
		panel.add(scrollPane_2);					
	
		
		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 =new ImageIcon(PrincipalTela.class.getResource("/img/LogoTVC.png"));
		Imagem3.setBounds(10, 328, 300, 300);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(),Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(imagi3));
		frmTorneioVirtualDe.getContentPane().add(Imagem3);
//		ImageIcon icone4 =new ImageIcon(PrincipalTela.class.getResource("/img/LogoTVC.png"));
		
		
		
		
		
	}
}
