package newgame;
import java.awt.event.*;

import javax.swing.*; //JButton, JFrame..

import java.awt.*;

public class frame extends JFrame implements ActionListener{


private JButton starten; // 2 Buttons
private JButton beenden;

public static void main(String[] args){ 

frame frame = new frame ("DUNGEON CRAWLER * Menü*");			// Menue
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500,500);
frame.getContentPane().setBackground(Color.DARK_GRAY);
frame.setLayout(null);
frame.setVisible(true);
frame.setLocationRelativeTo(null); 						//setzt das Fenster in der mitte
}


public frame(String title){
super(title);

starten = new JButton("Spiel Starten");
starten.setBounds(160,80,160,80);
starten.setFocusPainted(false);
starten.setBackground(Color.BLACK);
starten.setForeground(Color.WHITE);
starten.addActionListener(this);
add(starten);



beenden = new JButton("Beenden");
beenden.setBounds(160,250,160,80);
beenden.setBackground(Color.BLACK);
beenden.setForeground(Color.WHITE);
beenden.addActionListener(this);
add(beenden);

}


@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

if (e.getSource()==starten)						
game();

if (e.getSource()==beenden)								// schliesst Menue
System.exit(0);
}

public static void game(){								// Fenster fuer's Spiel
	JFrame game = new JFrame("PLAY DUNGEON CRAWLER");
	game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	game.setSize(990,740);
	game.setVisible(true);
	game.getContentPane().setBackground(Color.LIGHT_GRAY);
	game.setLocationRelativeTo(null);
	game.add(new Board());								// Board
	
	}
}