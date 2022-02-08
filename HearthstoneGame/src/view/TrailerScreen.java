package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;


import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;




public class TrailerScreen extends JFrame{
	private JButton skip;
	private JLabel background;
	
	public TrailerScreen(){
	setTitle("Hearthstone: Heroes Of Warcraft");
	setBounds(320, 150, 800,450);
	setDefaultCloseOperation(EXIT_ON_CLOSE); 
	
	
	ImageIcon ts=new ImageIcon("images/TrailerVideo30MB.gif");
	
    background=new JLabel(ts);
	background.setPreferredSize(new Dimension(780, 430));
	background.setLayout(new BoxLayout(background,BoxLayout.Y_AXIS));
	
	
	playSound("sounds/trailerAudio.wav");
	skip=new JButton();
	skip.setIcon(new ImageIcon("images/StartButtonNew.png"));
	skip.setActionCommand("Skip");
	skip.setOpaque(false);
	skip.setContentAreaFilled(false);
	skip.setBorderPainted(false);
	skip.setFocusPainted(false);
	

	background.add(Box.createRigidArea(new Dimension(200,300)));
	
	background.add(skip);
	
	
	add(background);
    
	pack();
    setResizable(false);
    setVisible(true);
    revalidate();
    repaint();
	}

	public void playSound(String filepath) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

