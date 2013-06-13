package newgame;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import java.io.IOException;

public class Dialogue extends JFrame implements ActionListener{
	
private JButton weiter;
private JButton schliessen;
private JLabel text;
private JButton weiter2;

public Dialogue(String Title){
	super(Title);
	
	text = new JLabel("                 Lass mich dir eine Geschichte erzaehlen...");
	text.setFont(new Font("Serif", Font.PLAIN, 14));
	getContentPane().add(text);

	weiter = new JButton("Weiter");
	weiter.setBounds(30,100,90,30);
	weiter.addActionListener(this);
	
	weiter2 = new JButton("Weiter");
	weiter2.setBounds(30,100,90,30);
	weiter2.addActionListener(this);

	schliessen = new JButton("Schliessen");
	schliessen.setBounds(250,100,100,30);
	schliessen.addActionListener(this);

	add(weiter);
	add(schliessen);
	add(text);
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

if (e.getSource()==schliessen)																// schliesst Menue
	setVisible(false);

if (e.getSource()==weiter)
	text.setText("    Vor langer Zeit beherrschte ein böser Zauberer das Koenigreich.");
	remove(weiter);
	add(weiter2);
	
if (e.getSource()==weiter2)
		text.setText("    Er stahl die Jungfrauen des Reiches um sie zu opfern!");
}
}
