import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Chatter implements IReceive {
	
	
	
	JTextArea textArea;
	JLabel label= new JLabel();
	
	
	ArrayList<String> Lines= new ArrayList<String>(Arrays.asList("", "" , "", "","", "","", "","","",""));//Lines method 
	String _name;
	ISend _server;// the underscores are used to distinguish class members from local variables 
	
	private String ConvoMessage() {
		String s="<html>";
		for(int i=0; i<9;i++) {
		s+= Lines.get(i)+ "<br>";
		//s+="<break>";
	}
	return s+Lines.get(9)+" </html>";
		
	}

	public Chatter(String name, ISend server) {
		super();
		_name=name; 
		_server=server;
		//setTitle(_name);
		JLabel label= new JLabel();
		
		JFrame frame= new JFrame();
		
		frame.setTitle(_name);
		label.setText(ConvoMessage());
		frame.setLayout(new BorderLayout());
		JPanel userPanel= new JPanel();
		
		JButton button= new JButton("Send");
		button.setFont(new Font("Comic Sans MS",Font.BOLD,14));
		textArea = new JTextArea(10,25);
		textArea.setForeground(Color.MAGENTA);
		JTextArea userTextArea = new JTextArea(5,25);
		userTextArea.setFont(new Font("Rockwell",Font.ITALIC,18));
	
		
		frame.add(textArea, BorderLayout.CENTER);
		JPanel bottomArea= new JPanel();
		bottomArea.add(userTextArea);
		bottomArea.add(button);
		
		
		frame.add(bottomArea,BorderLayout.SOUTH);
		

		button.addActionListener(new ActionListener() {

			@Override
		public void actionPerformed(ActionEvent e) {
				server.Send(name, userTextArea.getText());
				userTextArea.setText("");
				
			}
		
			
			
		});
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	
	}
	public void Receive(String From, String Message) {
		textArea.append(From + ":" + Message+ "\n");
	}


}


