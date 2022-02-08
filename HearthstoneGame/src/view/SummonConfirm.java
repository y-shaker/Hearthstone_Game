package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

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

public class SummonConfirm extends JWindow{
	
	private JTextField msg;
	private JButton confirm;
	private JButton cancel;
	
	public SummonConfirm(){
		
	    

setBounds(750,400,400,290);
		
		setLayout(null);
		
		
		JLabel background=new JLabel(new ImageIcon("images/PopUpBackground.png"));
		
		
		background.setBounds(0,0,400,300);

		Font f = new Font("Robinson Typeface",Font.BOLD,22);
		
		msg=new JTextField("Summon this minion ?");
		msg.setHorizontalAlignment(JTextField.CENTER);
		msg.setOpaque(false);
		msg.setEditable(false);
		msg.setFont(f);
		msg.setOpaque(false);
		msg.setBorder(null);
		msg.setForeground(Color.WHITE);
		
		confirm = new JButton(new ImageIcon("images/SummonButton.png"));
		confirm.setActionCommand("Confirm");
		confirm.setOpaque(false);
		confirm.setOpaque(false);
		confirm.setBorderPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.setFocusPainted(false);
		
		
		cancel = new JButton(new ImageIcon("images/CancelButton.png"));
		cancel.setActionCommand("Cancel");
		cancel.setOpaque(false);
		cancel.setOpaque(false);
		cancel.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		cancel.setFocusPainted(false);
		
		
		background.add(msg);
		background.add(confirm);
		background.add(cancel);
		
		add(background);
		
		
		msg.setBounds(0,75,400,50);
		confirm.setBounds(80,160,120,60);
		cancel.setBounds(210,160,120,60);
		
		
		

		//setVisible(true);

	
	}
	public JTextField getMsg() {
		return msg;
	}
	public JButton getConfirm() {
		return confirm;
	}
	public JButton getCancel() {
		return cancel;
	}
	
	public void addConfirmListener(ActionListener listener) {
		  confirm.addActionListener(listener);
		  cancel.addActionListener(listener);
		}
	
	public static void main(String[] args) {
		new SummonConfirm();
	}

}
