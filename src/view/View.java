package view;import java.awt.BorderLayout;  
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;


public class View   extends JFrame implements ActionListener {
	private JLabel player_name;
	private JTextArea p_name;
	private JButton startgame;
	private JComboBox<String> city;
	
	
	public View() {
		super();
		// set the windows title
		setTitle("Startgame");
		// change the default close operation of the JFrame to exit the application instead of hiding the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// set the location and size of the JFrame
		//setBounds(400, 400, 800, 600);
		 setSize(2500,4000);
		  this.setVisible(true);	 
		  getContentPane().setLayout(new FlowLayout());
			
			 player_name = new JLabel("please enter your name ");
			 
			
			 getContentPane().add(player_name);
              p_name= new JTextArea();
              p_name.setPreferredSize(new Dimension(100, 50));
              
              getContentPane().add(p_name);
              startgame = new JButton("enter to start ");
             // startgame.addActionListener(this);
              startgame.setActionCommand("enter to start");
      		  String[] x = { "Select City", "Cairo", "Sparta", "Rome" };
      		  city = new JComboBox<String>(x);      		  
              getContentPane().add(startgame);
              add(city);
             
              
             this.revalidate();
             this.repaint();
	

}
	 public JLabel getPlayer_name() {
		return player_name;
	}
	public JTextArea getP_name() {
		return p_name;
	}
	public JButton getStartgame() {
		return startgame;
	}
	public JComboBox<String> getCity() {
		return city;
	}
	public void actionPerformed(ActionEvent e)
	    {}

	}
