package newgame;
import java.awt.event.*;

import javax.swing.*; //JButton, JFrame..

import java.awt.*;
import java.io.IOException;

/* Durch die Klasse frame wird das Menue mit zwei Buttons (Starten,Schliessen) angezeigt.
 * 
 */

public class frame extends JFrame implements ActionListener{

private JButton starten; 															
private JButton beenden;
private JLabel l1;

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
		setContentPane(new JLabel(new ImageIcon("src/Resources/Start Screen.png")));			
		setLayout(null);
		l1=new JLabel();

		starten = new JButton("Spiel Starten");
		starten.setBounds(170,95,150,80);
		starten.setFocusPainted(false);
		starten.setIcon(new ImageIcon("src/Resources/Start Screen start.png")); 			
		starten.addActionListener(this);														

		beenden = new JButton("Beenden");
		beenden.setBounds(170,265,150,80);
		beenden.setIcon(new ImageIcon("src/Resources/Start Screen end.png"));				
		beenden.addActionListener(this);

		add(l1);
		add(starten);
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
			if (e.getSource()==beenden)																
				System.exit(0);
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