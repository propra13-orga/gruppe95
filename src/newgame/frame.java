package newgame;
import java.awt.event.*;

import javax.swing.*; //JButton, JFrame..

import java.awt.*;

public class frame extends JFrame implements ActionListener{


private JButton starten; // 2 Buttons
private JButton beenden;

public static void main(String[] args){ // Das Menü

frame frame = new frame ("DUNGEON CRAWLER * Menü*");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500,500);
frame.getContentPane().setBackground(Color.DARK_GRAY);
frame.setLayout(null);
frame.setVisible(true);
frame.setLocationRelativeTo(null); //setzt das Fenster in der mitte
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
menue();

if (e.getSource()==beenden)
System.exit(0);
}

public static void menue(){
JFrame menue = new JFrame();
menue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
menue.setSize(1000,700);
menue.setLayout(null);
menue.setVisible(true);
menue.setLocationRelativeTo(null);
}

}