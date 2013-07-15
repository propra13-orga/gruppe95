package newgame;
import java.awt.event.*;

import javax.swing.*; //JButton, JFrame..



import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/* Durch die Klasse frame wird das Menue mit zwei Buttons (Starten,Schliessen) angezeigt.
 * 
 */

public class frame extends JFrame implements ActionListener{

private JButton starten; 															
private JButton beenden;
private JButton chat;
private JButton info;
private JLabel l1;
private Server server;


public static void main(String[] args){ 
	frame frame = new frame ("DUNGEON CRAWLER");								
}

	public frame(String title){
		super(title);

		setSize(500,500);
		setLocationRelativeTo(null);															
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("src/Resources/Start Screen2.png")));			
		setLayout(null);
		l1=new JLabel();

		starten = new JButton("Spiel Starten");
		starten.setBounds(170,85,150,60);
		starten.setFocusPainted(false);
		starten.setIcon(new ImageIcon("src/Resources/starten.png")); 			
		starten.addActionListener(this);	
		
		chat = new JButton("Chat");
		chat.setBounds(170,165,150,60);
		starten.setFocusPainted(false);
		chat.setIcon(new ImageIcon("src/Resources/chat.png"));				
		chat.addActionListener(this);
		
		info = new JButton("Information");
		info.setBounds(170,250,150,60);
		starten.setFocusPainted(false);
		info.setIcon(new ImageIcon("src/Resources/info.png"));				
		info.addActionListener(this);


		beenden = new JButton("Beenden");
		beenden.setBounds(170,330,150,60);
		starten.setFocusPainted(false);
		beenden.setIcon(new ImageIcon("src/Resources/beenden.png"));				
		beenden.addActionListener(this);

		
		add(l1);
		add(starten);
		add(chat);	
		add(info);	
		add(beenden);
		setSize(499,499);
		setSize(500,500);																		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==starten)
				try {
					game();
	
				}catch(IOException e1) {
					e1.printStackTrace();
				
			}
			
		
			if (e.getSource()==chat)	
				 try {
					// new Server().start(); 														// Server
					 new Chatter().start(); 													// Client
			
				 } catch (Exception e1) {

					e1.printStackTrace();
				}
		 
		
			if (e.getSource()==beenden)	System.exit(0);
		 	}

				/* Beim starten wird das Spielfeld mit (1200 x 720) erstellt.
				 * 
				 */

				public static void game() throws IOException{																
					JFrame game = new JFrame("PLAY DUNGEON CRAWLER");
					game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
					game.setSize(1200,720);
					game.setVisible(true);
					game.setLocationRelativeTo(null);
					game.add(new Board());															
				 
				  	
				 }
	}