package newgame;
import java.awt.event.*;

import javax.swing.*; //JButton, JFrame..

import java.awt.*;
import java.io.IOException;

public class frame extends JFrame implements ActionListener{


private JButton starten; 																// fuegt der Klasse die Buttons und das Label hinzu
private JButton beenden;
private JLabel l1;

public static void main(String[] args){ 

frame frame = new frame ("DUNGEON CRAWLER");									// Menuetitel
}

public frame(String title){
super(title);

setSize(500,500);
setLocationRelativeTo(null);															// zentriert das Fenster
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
setLayout(new BorderLayout());
setContentPane(new JLabel(new ImageIcon("src/Resources/Start Screen.png")));			// setzt die Groesse des Fensters, den Hintergrund, sowie die Operation zum Schliessen fest
setLayout(null);
l1=new JLabel();

starten = new JButton("Spiel Starten");
starten.setBounds(170,95,150,80);
starten.setFocusPainted(false);
starten.setIcon(new ImageIcon("src/Resources/Start Screen start.png")); 				// setzt Groesse und Hintergruende fuer die Buttons fest
starten.addActionListener(this);														// fuegt Aktion dem Buttonklick hinzu

beenden = new JButton("Beenden");
beenden.setBounds(170,265,150,80);
beenden.setIcon(new ImageIcon("src/Resources/Start Screen end.png"));					// gleiches Verhalten wie beim Button "starten"
beenden.addActionListener(this);

add(l1);
add(starten);
add(beenden);																			// fuegt dem Frame die noetigen Buttons hinzu
setSize(499,499);
setSize(500,500);																		// aktualisiert das Fenster; noetig damit Einstellungen uebernommen werden
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

if (e.getSource()==starten)
	try {
		game();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

if (e.getSource()==beenden)																// schliesst Menue
System.exit(0);
}

public static void game() throws IOException{																// Fenster fuer's Spiel
	JFrame game = new JFrame("PLAY DUNGEON CRAWLER");
	game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	game.setSize(1200,720);
	game.setVisible(true);
	//game.getContentPane().setBackground(Color.LIGHT_GRAY);
	game.setLocationRelativeTo(null);
	game.add(new Board());																// oeffnet Klasse board (das eigentliche Spiel)
	//game.removeAll();

	}
}
