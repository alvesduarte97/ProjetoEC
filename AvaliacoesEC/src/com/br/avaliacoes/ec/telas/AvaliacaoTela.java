package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.telas.classFX.SceneGenerator;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class AvaliacaoTela extends JPanel {
	private JTextArea txtComentario;
	private JButton btnConfirmar;
	private JComboBox cbNota1;
	private JComboBox cbNota2;
	private JComboBox cbNota3;
	private JComboBox cbNota4;
	private TextField txtEscola;
	private TextField txtSerie;
	private TextField txtDesafio;
	private Desafios desafioAtivo;
	private List<Grupo> grupos;
	private int index;
	private JComboBox cbNota5;
	private static JFrame frame;
    static JFXPanel fxPanel;
    static Scene scene;
    private static JInternalFrame frameVideo;

	public AvaliacaoTela(int newIndex, List<Grupo> listaGrupos) throws BancoException {
		setLayout(null);
		setSize(741, 690);
		this.index = newIndex;
		this.grupos = listaGrupos;
		
		if(newIndex >= listaGrupos.size()) {
			LoginTela login = new LoginTela();
			PrincipalTela.internalFrame.setContentPane(login);
			throw new BancoException("Não existem mais grupos para serem avaliados por você.");
		}
		
//		SwingUtilities.invokeLater(new Runnable() {
//		      @Override public void run() {
//		        initAndShowGUI("C:\\Users\\Duarte\\Desktop\\video", index);
//		      }
//		    });
		
		
		desafioAtivo = FachadaImp.getInstanciaFachada().desafioAtivo();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 543, 376, 63);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("Comentario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(178, 518, 86, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nota 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(162, 441, 46, 14);
		add(lblNewLabel_1);

		cbNota1 = new JComboBox();
		cbNota1.addItem(0.1);
		cbNota1.addItem(0.2);
		cbNota1.addItem(0.3);
		cbNota1.addItem(0.4);
		cbNota1.setBounds(162, 466, 46, 20);
		add(cbNota1);

		cbNota2 = new JComboBox();
		cbNota2.addItem(0.1);
		cbNota2.addItem(0.2);
		cbNota2.addItem(0.3);
		cbNota2.addItem(0.4);
		cbNota2.setBounds(260, 466, 46, 20);
		add(cbNota2);

		cbNota3 = new JComboBox();
		cbNota3.addItem(0.1);
		cbNota3.addItem(0.2);
		cbNota3.addItem(0.3);
		cbNota3.addItem(0.4);
		cbNota3.setBounds(352, 466, 46, 20);
		add(cbNota3);

		cbNota4 = new JComboBox();
		cbNota4.addItem(0.1);
		cbNota4.addItem(0.2);
		cbNota4.addItem(0.3);
		cbNota4.addItem(0.4);
		cbNota4.setBounds(443, 466, 46, 20);
		add(cbNota4);

		JLabel label = new JLabel("Nota 2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(260, 441, 46, 14);
		add(label);

		JLabel label_1 = new JLabel("Nota 3");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(352, 441, 46, 14);
		add(label_1);

		JLabel label_3 = new JLabel("Nota 4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(443, 441, 46, 14);
		add(label_3);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				double nota1 = 0.1;
				double nota2 = 0.1;
				double nota3 = 0.1;
				double nota4 = 0.1;
				double nota5 = 0.1;

				int index1 = cbNota1.getSelectedIndex();
				switch (index1) {
				case 0:
					nota1 = 0.1;
					break;
				case 1:
					nota1 = 0.2;
					break;
				case 2:
					nota1 = 0.3;
					break;
				case 3:
					nota1 = 0.4;
					break;

				default:
					break;
				}

				int index2 = cbNota2.getSelectedIndex();
				switch (index2) {
				case 0:
					nota2 = 0.1;
					break;
				case 1:
					nota2 = 0.2;
					break;
				case 2:
					nota2 = 0.3;
					break;
				case 3:
					nota2 = 0.4;
					break;

				default:
					break;
				}

				int index3 = cbNota3.getSelectedIndex();
				switch (index3) {
				case 0:
					nota3 = 0.1;
					break;
				case 1:
					nota3 = 0.2;
					break;
				case 2:
					nota3 = 0.3;
					break;
				case 3:
					nota3 = 0.4;
					break;

				default:
					break;
				}

				int index4 = cbNota4.getSelectedIndex();
				switch (index4) {
				case 0:
					nota4 = 0.1;
					break;
				case 1:
					nota4 = 0.2;
					break;
				case 2:
					nota4 = 0.3;
					break;
				case 3:
					nota4 = 0.4;
					break;

				default:
					break;
				}

				int index5 = cbNota5.getSelectedIndex();
				switch (index5) {
				case 0:
					nota5 = 0.1;
					break;
				case 1:
					nota5 = 0.2;
					break;
				case 2:
					nota5 = 0.3;
					break;
				case 3:
					nota5 = 0.4;
					break;

				default:
					break;
				}
				

				String comentario = txtComentario.getText();
				double notaFinal = nota1 + nota2 + nota3 + nota4 + nota5;
				Avaliacoes avaliacao = new Avaliacoes();
				
				avaliacao.setComentario(comentario);
				avaliacao.setNota1(nota1);
				avaliacao.setNota2(nota2);
				avaliacao.setNota3(nota3);
				avaliacao.setNota4(nota4);
				avaliacao.setNota5(nota5);
				avaliacao.setNotaFinal(notaFinal);
				avaliacao.setAvaliador(PrincipalTela.pessoa);
				avaliacao.setGrupoAvaliado(grupos.get(index));
				avaliacao.setDesafio(desafioAtivo);
				try {
					FachadaImp.getInstanciaFachada().inserirAvaliacoes(avaliacao);
					index = index + 1;
					AvaliacaoTela proxTela = new AvaliacaoTela(index,listaGrupos);
					PrincipalTela.internalFrame.setContentPane(proxTela);
					PrincipalTela.internalFrame.revalidate();
					
				} catch (BancoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setBounds(178, 628, 376, 56);
		add(btnConfirmar);

		JSeparator separator = new JSeparator();
		separator.setBounds(-27, 615, 796, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 497, 796, 2);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-27, 428, 796, 2);
		add(separator_2);

		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setBounds(308, 403, 54, 14);
		add(lblEscola);

		txtEscola = new TextField();
		txtEscola.setBounds(368, 400, 198, 22);
		if (grupos.size() > 0)
			txtEscola.setText(grupos.get(index).getEscola());
		add(txtEscola);
		txtEscola.setEditable(false);

		JLabel lblSerie = new JLabel("Serie:");
		lblSerie.setBounds(605, 403, 36, 14);
		add(lblSerie);

		txtSerie = new TextField();
		txtSerie.setBounds(647, 400, 63, 22);
		if (grupos.size() > 0)
			txtSerie.setText(grupos.get(index).getSerie());
		add(txtSerie);
		txtSerie.setEditable(false);

		JLabel lblDesafio = new JLabel("Desafio:");
		lblDesafio.setBounds(50, 403, 46, 14);
		add(lblDesafio);

		txtDesafio = new TextField();
		txtDesafio.setEditable(false);
		txtDesafio.setBounds(102, 400, 186, 22);
		txtDesafio.setText(desafioAtivo.getNome());
		add(txtDesafio);

		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginTela logTela = new LoginTela();
				PrincipalTela.internalFrame.setContentPane(logTela);
				PrincipalTela.internalFrame.revalidate();
			}
		});
		
		frameVideo = new JInternalFrame("New JInternalFrame");
		frameVideo.setBorder(null);
		frameVideo.setBounds(10, 11, 721, 380);
		add(frameVideo);
		frameVideo.setVisible(true);
		// Este metodo chama uma swing thread
		fxPanel = new JFXPanel();
		frameVideo.getContentPane().add(fxPanel);
		
				cbNota5 = new JComboBox();
				cbNota5.setModel(new DefaultComboBoxModel(new String[] { "0.1", "0.2", "0.3", "0.4" }));
				cbNota5.setBounds(525, 466, 46, 20);
				add(cbNota5);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(10, 628, 80, 56);
		add(button);
		ImageIcon icone3 =new ImageIcon(LoginTela.class.getResource("/imgfundo.jpg"));

		JLabel lblNota = new JLabel("Nota 5");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNota.setBounds(525, 441, 46, 14);
		add(lblNota);
		
				txtComentario = new JTextArea();
				txtComentario.setBounds(178, 543, 374, 61);
				add(txtComentario);
				txtComentario.setLineWrap(true);
				
				JLabel Imagem3 = new JLabel("");
				Imagem3.setBounds(0, 17, 741, 675);
				Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(),Imagem3.getHeight(), Image.SCALE_SMOOTH);
				Imagem3.setIcon(new ImageIcon(AvaliacaoTela.class.getResource("/img/Fundo2.jpg")));
				add(Imagem3);
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override public void run() {
		        initAndShowGUI("C:\\Users\\Duarte\\Desktop\\video", index);
		        System.out.println("executou essa mzra");
		      }
		    });
	}
	
		private void limparCampos() {
		txtComentario.setText("");
		cbNota1.setSelectedIndex(0);
		cbNota2.setSelectedIndex(0);
		cbNota3.setSelectedIndex(0);
		cbNota4.setSelectedIndex(0);
		}
		
		//Metodos para chamar video
		  private static void initAndShowGUI(String diretorio, int index) {
			    frameVideo.setBounds(10, 11, 721, 363);
			    frameVideo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			    frameVideo.setVisible(true);

			    Platform.runLater(new Runnable() {
			      @Override public void run() {
			        initFX(fxPanel, diretorio, index);        
			      }
			    });
			  }
		
		  private static void initFX(JFXPanel fxPanel, String diretorio, int index) {
			    // Este metodo chama uma JavaFX thread
			    scene = new SceneGenerator(diretorio, index).createScene();
			    fxPanel.setScene(scene);
			    
			    
}
		  
		  
}
