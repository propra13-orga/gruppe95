package newgame;
import java.awt.event.*;

import javax.swing.*; //JButton, JFrame..

import java.awt.*;

public class frame extends JFrame implements ActionListener{


private JButton starten; // 2 Buttons
private JButton beenden;
private JLabel l1;

public static void main(String[] args){ 

frame frame = new frame ("DUNGEON CRAWLER * Menü*");			// Menue						//setzt das Fenster in der mitte
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
// refresh
setSize(499,499);
setSize(500,500);
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
	game.setSize(950,720);
	game.setVisible(true);
	game.getContentPane().setBackground(Color.LIGHT_GRAY);
	game.setLocationRelativeTo(null);
	game.add(new Board());								// Board
	
	}
}
