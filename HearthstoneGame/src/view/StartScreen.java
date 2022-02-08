package view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StartScreen extends JFrame{
	
	private JButton start;
	private JLabel background;
	
	public StartScreen(){

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double swidth = screenSize.getWidth();
		double sheight = screenSize.getHeight();
		
		
		setTitle("Hearthstone: Heroes Of Warcraft");
		setBounds(160, 20, 1600,900);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		ImageIcon ss=new ImageIcon("images/StartScreenNew.jpg");
		
	    background=new JLabel(ss);
		background.setPreferredSize(new Dimension(1580, 880));
		background.setLayout(new BoxLayout(background,BoxLayout.Y_AXIS));
		
			start=new JButton();
			start.setIcon(new ImageIcon("images/StartButtonNew.png"));
			start.setActionCommand("Start");
			start.setOpaque(false);
			start.setContentAreaFilled(false);
			start.setBorderPainted(false);
			start.setFocusPainted(false);
			
			
		
		
	   
		
		background.add(Box.createRigidArea(new Dimension(450,700)));
		background.add(start);
		
		
		add(background);
	    
		
		
        pack();
        
        setResizable(false);
        setVisible(true);
        revalidate();
        repaint();
        
       
	}
		
	
	public JButton getStart() {
		return start;
	}


	public JLabel getBackgroundd() {
		return background;
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


	public static void main (String[]args){
		new StartScreen();
	}
	
	
		
	}


