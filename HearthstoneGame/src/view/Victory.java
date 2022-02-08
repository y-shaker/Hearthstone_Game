package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;

import model.heroes.Hero;
import model.heroes.Hunter;

public class Victory extends JWindow{
	
	private JTextField msg;
	private JTextField winner;
	private JButton New;
	private JButton Exit;
	
	public Victory(){
	}
		
	public Victory(Hero w){  

     setBounds(370,200,1156,650);
		
		setLayout(null);
		
		
		JLabel background=new JLabel(new ImageIcon("images/VictoryUp.jpg"));
		
		
		background.setBounds(0,0,1156,650);

		Font f = new Font("Robinson Typeface",Font.BOLD,48);
		
		msg=new JTextField("VICTORY !");
		msg.setHorizontalAlignment(JTextField.CENTER);
		msg.setOpaque(false);
		msg.setEditable(false);
		msg.setFont(f);
		msg.setOpaque(false);
		msg.setBorder(null);
		msg.setForeground(Color.WHITE);
		
		Font f1 = new Font("Robinson Typeface",Font.BOLD,25);
		
		winner=new JTextField(w.getName());
		winner.setHorizontalAlignment(JTextField.CENTER);
		winner.setOpaque(false);
		winner.setEditable(false);
		winner.setFont(f1);
		winner.setOpaque(false);
		winner.setBorder(null);
		winner.setForeground(Color.WHITE);
		
		New = new JButton(new ImageIcon("images/NewButton.png"));
		New.setActionCommand("New");
		New.setOpaque(false);
		New.setOpaque(false);
		New.setBorderPainted(false);
		New.setContentAreaFilled(false);
		New.setFocusPainted(false);
		
		
		Exit = new JButton(new ImageIcon("images/ExitButton.png"));
		Exit.setActionCommand("Exit");
		Exit.setOpaque(false);
		Exit.setOpaque(false);
		Exit.setBorderPainted(false);
		Exit.setContentAreaFilled(false);
		Exit.setFocusPainted(false);
		
		
		background.add(msg);
		background.add(winner);
		background.add(New);
		background.add(Exit);
		
		add(background);
		
		
		msg.setBounds(350,175,400,50);
		winner.setBounds(350,225,400,50);
		New.setBounds(400,450,120,60);
		Exit.setBounds(610,450,120,60);
		
		
		

		setVisible(true);

	
	}
	public JTextField getMsg() {
		return msg;
	}
	public JButton getNew() {
		return New;
	}
	public JButton getExit() {
		return Exit;
	}
	//public void setMsg(String msg) {
	//	this.msg.setText(msg);
	//}
	
	public void addConfirmListener(ActionListener listener) {
		  New.addActionListener(listener);
		  Exit.addActionListener(listener);
		}
	
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		new Victory(new Hunter());
	}

}
