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

public class TestandoVideo {

	private JFrame frame;
	private JTextField textField;

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
		textField.setBounds(30, 69, 335, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String diretorio = textField.getText();
				   SwingUtilities.invokeLater(new Runnable() {
					      @Override public void run() {
					        initAndShowGUI(diretorio);
					      }
					    });				
			}
		});
		btnNewButton.setBounds(94, 149, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	  private static void initAndShowGUI(String diretorio) {
		    // This method is invoked on Swing thread
		    JFrame frame = new JFrame("FX");
		    final JFXPanel fxPanel = new JFXPanel();
		    frame.add(fxPanel);
		    frame.setBounds(200, 100, 800, 250);
		    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		    

		    Platform.runLater(new Runnable() {
		      @Override public void run() {
		        initFX(fxPanel, diretorio);        
		      }
		    });
		  }
	
	  private static void initFX(JFXPanel fxPanel, String diretorio) {
		    // This method is invoked on JavaFX thread
		    Scene scene = new SceneGenerator(diretorio).createScene();
		    fxPanel.setScene(scene);
		  }
	
}
