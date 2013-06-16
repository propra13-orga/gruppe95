package newgame;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import java.io.IOException;

public class DialogueShop extends JFrame implements ActionListener{
	
private JButton schliessen;																										//definiert 1 JLabel und einen JButton
private JLabel text;


public DialogueShop(String Title){
	super(Title);
	
	text = new JLabel("                       Guten Tag. Bitte schaue dich doch in unserem Laden ein wenig um!");				//legt den Text des Ladenbesitzers fest
	text.setFont(new Font("Serif", Font.PLAIN, 14));																			//Font und Textart- + groesse
	getContentPane().add(text);

	schliessen = new JButton("Schliessen");																						//legt Name, Position und Groesse des Buttons fest
	schliessen.setBounds(250,200,100,30);
	schliessen.addActionListener(this);

	add(schliessen);																											//fuegt Text und Button hinzu
	add(text);
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

if (e.getSource()==schliessen)																									//schliesst Fenster auf Druck
	setVisible(false);

}
}
