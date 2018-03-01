package com.br.avaliacoes.ec.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.br.avaliacoes.ec.telas.classFX.SceneGenerator;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TestandoVideo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestandoVideo window = new TestandoVideo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestandoVideo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(128, 64, 306, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Reproduzir");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String diretorio = textField.getText();
				int index = new Integer(textField_1.getText());
				   SwingUtilities.invokeLater(new Runnable() {
					      @Override public void run() {
					        initAndShowGUI(diretorio, index);
					      }
					    });				
			}
		});
		btnNewButton.setBounds(94, 149, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 97, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDiretorio = new JLabel("Diretorio:");
		lblDiretorio.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblDiretorio);
		
		JLabel lblPosioDoVideo = new JLabel("Posi\u00E7\u00E3o do video");
		lblPosioDoVideo.setBounds(10, 103, 108, 14);
		frame.getContentPane().add(lblPosioDoVideo);
	}
	
	  private static void initAndShowGUI(String diretorio, int index) {
		    // This method is invoked on Swing thread
		    JFrame frame = new JFrame("FX");
		    final JFXPanel fxPanel = new JFXPanel();
		    frame.getContentPane().add(fxPanel);
		    frame.setBounds(200, 100, 800, 250);
		    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		    

		    Platform.runLater(new Runnable() {
		      @Override public void run() {
		        initFX(fxPanel, diretorio, index);        
		      }
		    });
		  }
	
	  private static void initFX(JFXPanel fxPanel, String diretorio, int index) {
		    // This method is invoked on JavaFX thread
		    Scene scene = new SceneGenerator(diretorio, index).createScene();
		    fxPanel.setScene(scene);
		  }
}
