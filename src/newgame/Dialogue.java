package newgame;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

public class Dialogue extends JFrame implements ActionListener{
	
private JButton weiter;																										//definiert 3 JButtons und 1 JLabel
private JButton schliessen;
private JLabel text;
private JButton weiter2;

public Dialogue(String Title){
	super(Title);
	
	text = new JLabel("                       Der boese Zauberer verbreitet in unserem Reich Angst und Schrecken.");		//Legt den ersten Text im Label fest
	text.setFont(new Font("Serif", Font.PLAIN, 14));																		//Legt Schriftgroesse und Font fest
	getContentPane().add(text);

	weiter = new JButton("Weiter");																							//definiert Position und Gr��e f�r die Buttons
	weiter.setBounds(80,200,90,30);
	weiter.addActionListener(this);
	
	weiter2 = new JButton("Weiter2");																						//definiert Position und Gr��e f�r die Buttons
	weiter2.setBounds(80,200,90,30);
	weiter2.addActionListener(this);

	schliessen = new JButton("Schliessen");																					//definiert Position und Gr��e f�r die Buttons
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
	text.setText("                                   Zieh los und besiege den boesen Zauberer! Rette uns!");				//aendert den Text auf Druck
	remove(weiter);
	add(weiter2);
	
if (e.getSource()==weiter2)
	text.setText("");
	remove(weiter2);
}
}
