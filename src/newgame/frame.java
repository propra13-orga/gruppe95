package newgame;
import java.awt.event.*;

import javax.swing.*; //JButton, JFrame..

import java.awt.*;


/* Durch die Klasse frame wird das Menue mit zwei Buttons (Starten,Schliessen) angezeigt.
 * 
 */

public class frame extends JFrame implements ActionListener{

/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private JButton starten; 															
private JButton beenden;
private JButton chat;
private JButton online;
private JLabel l1;
//private Servera servera;


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

		starten = new JButton();
		starten.setBounds(160,85,150,60);
		starten.setIcon(new ImageIcon("src/Resources/spielstarten.png")); 			
		starten.addActionListener(this);	
		
		chat = new JButton();
		chat.setBounds(160,165,150,60);
		chat.setIcon(new ImageIcon("src/Resources/chatten.png"));				
		chat.addActionListener(this);
		
		online = new JButton();
		online.setBounds(160,250,150,60);
		online.setIcon(new ImageIcon("src/Resources/onspielen.png"));				
		online.addActionListener(this);


		beenden = new JButton();
		beenden.setBounds(160,330,150,60);
		starten.setFocusPainted(false);
		beenden.setIcon(new ImageIcon("src/Resources/spielbeenden.png"));				
		beenden.addActionListener(this);

		
		add(l1);
		add(starten);
		add(chat);	
		add(online);	
		add(beenden);
		setSize(499,499);
		setSize(500,500);																		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==starten)
								game();
						setVisible(false);
	
			if (e.getSource()==chat)	
				 try {
					 new Servera().start(); 											
				//	 new Chatter().start(); 													
				 
				 } catch (Exception e1) {

					e1.printStackTrace();
				}
		 
		
			if (e.getSource()==beenden){
				System.exit(0);
			}
			if (e.getSource()==online){
					online();
					setVisible(false);
			}
		 	}

				/* Beim starten wird das Spielfeld mit (1200 x 720) erstellt.
				 * 
				 */

				public static void game(){																
					JFrame game = new JFrame("PLAY DUNGEON CRAWLER");
					game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
					game.setSize(1200,720);
					game.setLocationRelativeTo(null);
					game.add(new Board());	
					game.setVisible(true);
			
				 
				  	
				 }
				public void online(){																
					JFrame online = new JFrame("PLAY DUNGEON CRAWLER");
					online.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
					online.add(new Play_Online());	
					online.pack();	
					online.setSize(1200,720);
					online.setVisible(true);
					online.setLocationRelativeTo(null);
			
				 
				  	
				 }
	}