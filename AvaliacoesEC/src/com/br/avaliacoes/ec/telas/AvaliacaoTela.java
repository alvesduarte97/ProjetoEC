package com.br.avaliacoes.ec.telas;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.modelo.Avaliacoes;
import com.br.avaliacoes.ec.modelo.Desafios;
import com.br.avaliacoes.ec.modelo.Grupo;
import com.br.avaliacoes.ec.servidor.IServidor;
import com.br.avaliacoes.ec.telas.classFX.CreateScene;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class AvaliacaoTela extends JPanel {
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
	private static JFXPanel fxPanel;
	private static CreateScene cs;
	private String oldName;
	private String nome;
	private String diretorio;
	private static JInternalFrame internalFrame;
	private JTextArea txtComentario;

	public AvaliacaoTela(int newIndex, List<Grupo> listaGrupos, String velhoNome, IServidor servidor) throws BancoException {
		setLayout(null);
		setSize(1062, 722);
		this.index = newIndex;
		this.grupos = listaGrupos;

		if (newIndex >= listaGrupos.size()) {
			LoginTela login = new LoginTela(servidor);
			PrincipalTela.internalFrame.setContentPane(login);
			throw new BancoException("Não existem mais grupos para serem avaliados por você.");
		}

		try {
			diretorio = servidor.getDiretorioVideo();
		} catch (RemoteException e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

		try {
			desafioAtivo = servidor.desafioAtivo();
		} catch (RemoteException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

		internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		internalFrame.setBounds(181, -29, 728, 408);
		add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		txtEscola = new TextField();
		txtEscola.setBounds(535, 400, 198, 22);
		add(txtEscola);
		txtEscola.setEditable(false);

		txtSerie = new TextField();
		txtSerie.setBounds(801, 400, 63, 22);
		add(txtSerie);
		txtSerie.setEditable(false);

		if (grupos.size() > 0) {
			txtEscola.setText(grupos.get(index).getEscola());
			txtSerie.setText(grupos.get(index).getSerie());
		}

		nome = txtEscola.getText() + txtSerie.getText();
		cs = new CreateScene(diretorio, nome);
		SwingUtilities.invokeLater(() -> {
			ShowGUI(diretorio, nome);
		});

		JLabel lblNewLabel = new JLabel("Coment\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(338, 523, 86, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Criatividade");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(227, 441, 73, 14);
		add(lblNewLabel_1);

		cbNota1 = new JComboBox();
		cbNota1.addItem(0.1);
		cbNota1.addItem(0.2);
		cbNota1.addItem(0.3);
		cbNota1.addItem(0.4);
		cbNota1.setBounds(237, 466, 46, 20);
		add(cbNota1);

		cbNota2 = new JComboBox();
		cbNota2.addItem(0.1);
		cbNota2.addItem(0.2);
		cbNota2.addItem(0.3);
		cbNota2.addItem(0.4);
		cbNota2.setBounds(338, 466, 46, 20);
		add(cbNota2);

		cbNota3 = new JComboBox();
		cbNota3.addItem(0.1);
		cbNota3.addItem(0.2);
		cbNota3.addItem(0.3);
		cbNota3.addItem(0.4);
		cbNota3.setBounds(454, 466, 46, 20);
		add(cbNota3);

		cbNota4 = new JComboBox();
		cbNota4.addItem(0.1);
		cbNota4.addItem(0.2);
		cbNota4.addItem(0.3);
		cbNota4.addItem(0.4);
		cbNota4.setBounds(569, 466, 46, 20);
		add(cbNota4);

		JLabel lblTempo = new JLabel("Tempo");
		lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempo.setBounds(338, 441, 54, 14);
		add(lblTempo);

		JLabel lblExplicaoNoVideo = new JLabel("Explica\u00E7\u00E3o no video");
		lblExplicaoNoVideo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExplicaoNoVideo.setBounds(423, 441, 136, 14);
		add(lblExplicaoNoVideo);

		JLabel lblDominoDoConteudo = new JLabel("Domino do conteudo");
		lblDominoDoConteudo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDominoDoConteudo.setBounds(569, 441, 145, 14);
		add(lblDominoDoConteudo);

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
					servidor.inserirAvaliacoes(avaliacao);
					index = index + 1;
					if (index >= listaGrupos.size()) {
						JOptionPane.showMessageDialog(null, "Não existem mais grupos para serem avaliados por você.");
						System.exit(0);
						
					}
					oldName = nome;
					txtEscola.setText(grupos.get(index).getEscola());
					txtSerie.setText(grupos.get(index).getSerie());
					txtComentario.setText("");
					nome = txtEscola.getText() + txtSerie.getText();
					
					if(cs.mediaPlayer != null)
						cs.stopVideo();
					
					cs = null;
					CreateScene newCs = new CreateScene(diretorio, nome);
					cs = newCs;
					newCs = null;
					SwingUtilities.invokeLater(() -> {
						ShowGUI(diretorio, nome);
					});

				} catch (BancoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (RemoteException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setBounds(338, 630, 376, 56);
		add(btnConfirmar);

		JSeparator separator = new JSeparator();
		separator.setBounds(-27, 615, 1200, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 497, 1200, 2);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-27, 428, 1200, 2);
		add(separator_2);

		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEscola.setBounds(475, 403, 54, 14);
		add(lblEscola);

		JLabel lblSerie = new JLabel("S\u00E9rie:");
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSerie.setBounds(759, 403, 36, 14);
		add(lblSerie);

		JLabel lblDesafio = new JLabel("Desafio:");
		lblDesafio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesafio.setBounds(209, 403, 54, 14);
		add(lblDesafio);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 543, 376, 66);
		add(scrollPane);

		txtComentario = new JTextArea();
		txtComentario.setLineWrap(true);
		scrollPane.setViewportView(txtComentario);

		txtDesafio = new TextField();
		txtDesafio.setEditable(false);
		txtDesafio.setBounds(269, 400, 186, 22);
		txtDesafio.setText(desafioAtivo.getNome());
		add(txtDesafio);

		cbNota5 = new JComboBox();
		cbNota5.setModel(new DefaultComboBoxModel(new String[] { "0.1", "0.2", "0.3", "0.4" }));
		cbNota5.setBounds(749, 466, 46, 20);
		add(cbNota5);

		JLabel lblNota = new JLabel("Audio e imagem");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNota.setBounds(769, 441, 112, 18);
		add(lblNota);

		JLabel Imagem3 = new JLabel("");
		ImageIcon icone3 = new ImageIcon(PrincipalTela.class.getResource("/imgfundo.jpg"));
		Imagem3.setBounds(0, 0, 1062, 722);
		Image imagi3 = icone3.getImage().getScaledInstance(Imagem3.getWidth(), Imagem3.getHeight(), Image.SCALE_SMOOTH);
		Imagem3.setIcon(new ImageIcon(AvaliacaoTela.class.getResource("/imgfundo3.jpg")));
		add(Imagem3);

	}

	private void limparCampos() {
		txtComentario.setText("");
		cbNota1.setSelectedIndex(0);
		cbNota2.setSelectedIndex(0);
		cbNota3.setSelectedIndex(0);
		cbNota4.setSelectedIndex(0);
	}

	private static void ShowGUI(String diretorio, String nomeVideo) {
		fxPanel = new JFXPanel();
		internalFrame.setContentPane(fxPanel);

		Platform.runLater(() -> {
			cs.initFX(fxPanel);
		});
	}
}
