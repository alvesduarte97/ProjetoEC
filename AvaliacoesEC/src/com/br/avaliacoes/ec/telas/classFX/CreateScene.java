package com.br.avaliacoes.ec.telas.classFX;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class CreateScene {
	//Exemplo de como deve ficar o diretorio
	//file:///C:/Users/Duarte/Desktop/video/lala.mp4
//    private String VIDEO_URL = getClass().getResource(
//            "file:///C:/Users/Duarte/Desktop/video/lala.mp4").toString();
	private String videoURL;
	private String nomeVideo;
	public static MediaPlayer mediaPlayer;
	
	public CreateScene(String diretorio, String nomeVideo) {
		this.nomeVideo = nomeVideo;
		this.videoURL ="file:///" + (diretorio + "\\" + nomeVideo+".mp4").replace("\\", "/").replaceAll(" ", "%20");
	}
	
	public void NovoVideo(String diretorio, String nomeVideo) {
		this.nomeVideo = nomeVideo;
		this.videoURL ="file:///" + (diretorio + "\\" + nomeVideo+".mp4").replace("\\", "/").replaceAll(" ", "%20");
	}

    public void initFX(JFXPanel fxPanel) {
        Media media = new Media(videoURL);
        mediaPlayer = new MediaPlayer(media);
        MediaControl mediaControl = new MediaControl(mediaPlayer);

        StackPane raiz = new StackPane();
        raiz.getChildren().add(mediaControl);
        Scene cena = new Scene(raiz, 300, 300);
        mediaPlayer.play();
        fxPanel.setScene(cena);
        
    }
   public void stopVideo() {
	   mediaPlayer.stop();
   }
}