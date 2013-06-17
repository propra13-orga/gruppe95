package newgame;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import java.io.IOException;

public class DialogueShop extends JFrame implements ActionListener{
	
	private JButton weiter;																										//definiert 3 JButtons und 1 JLabel
	private JButton schliessen;
	private JLabel text;
	private JButton weiter2;


public DialogueShop(String Title){
	super(Title);
	
	text = new JLabel("                       Guten Tag. Bitte schaue dich doch in unserem Laden ein wenig um!");				//legt den Text des Ladenbesitzers fest
	text.setFont(new Font("Serif", Font.PLAIN, 14));																		//Legt Schriftgroesse und Font fest
	getContentPane().add(text);

	weiter = new JButton("Weiter");																							//definiert Position und Größe für die Buttons
	weiter.setBounds(80,200,90,30);
	weiter.addActionListener(this);
	
	weiter2 = new JButton("Weiter2");																						//definiert Position und Größe für die Buttons
	weiter2.setBounds(80,200,90,30);
	weiter2.addActionListener(this);

	schliessen = new JButton("Schliessen");																					//definiert Position und Größe für die Buttons
	schliessen.setBounds(400,200,100,30);
	schliessen.addActionListener(this);

	add(weiter);
	add(schliessen);																										//fuegt die Buttons und den Text im ersten Label zu
	add(text);
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

if (e.getSource()==schliessen)																								//schliesst das Fenster auf Druck
	setVisible(false);

if (e.getSource()==weiter)
	text.setText("                   Unsere Manatraenke kosten 20 Gold und unsere Heiltraenke kosten 30 Gold");				//aendert den Text auf Druck
	remove(weiter);
	add(weiter2);
	
if (e.getSource()==weiter2)
	text.setText("");
	remove(weiter2);
}
}
