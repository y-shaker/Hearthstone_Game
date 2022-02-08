package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;

import model.cards.minions.Icehowl;

public class ExceptionWindow extends JWindow{
	private JTextField msg;
	private JTextField br;
	

	private JButton ok;
	
	
	public ExceptionWindow(){
		
		
		setBounds(750,400,400,290);
		
		setLayout(null);
		
		
		JLabel background=new JLabel(new ImageIcon("images/PopUpBackground.png"));
		
		
		background.setBounds(0,0,400,300);

		Font f = new Font("Robinson Typeface",Font.BOLD,18);
		
		msg=new JTextField();
		msg.setHorizontalAlignment(JTextField.CENTER);
		msg.setOpaque(false);
		msg.setEditable(false);
		msg.setFont(f);
		msg.setOpaque(false);
		msg.setBorder(null);
		msg.setForeground(Color.WHITE);
		
		br=new JTextField();
		br.setHorizontalAlignment(JTextField.CENTER);
		br.setOpaque(false);
		br.setEditable(false);
		br.setFont(f);
		br.setOpaque(false);
		br.setBorder(null);
		br.setForeground(Color.WHITE);
		
		ok = new JButton(new ImageIcon("images/okButton.png"));
		ok.setActionCommand("ok");
		ok.setOpaque(false);
		ok.setOpaque(false);
		ok.setBorderPainted(false);
		ok.setContentAreaFilled(false);
		ok.setFocusPainted(false);
		
		
		
		background.add(msg);
		background.add(br);
		background.add(ok);
		
		
		add(background);
		
		
		msg.setBounds(0,75,400,50);
		br.setBounds(0,115,400,50);
		ok.setBounds(140,160,120,60);
		
		
		
		

		//setVisible(true);

}
	public JTextField getMsg() {
		return msg;
	}
	public JButton getOk() {
		return ok;
	}
	
	public void setMsg(String msg) {
		this.msg.setText(msg);
	}
	
	public void setbr(String msg) {
		this.br.setText(msg);
	}
	
	
	public void addConfirmListener(ActionListener listener) {
		  ok.addActionListener(listener);
		  
		}
	
	public static void main(String[] args) {
		
		ExceptionWindow e=new ExceptionWindow();
		e.setMsg("Full Hand!");
		e.setbr("Burned Card Details: "+new Icehowl().getName()+new Icehowl().getManaCost()+new Icehowl().getRarity());
		e.setVisible(true);
	}

}

