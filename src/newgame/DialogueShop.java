package newgame;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;


public class DialogueShop extends JFrame implements ActionListener{
	
	private JButton weiter;																	
	private JButton schliessen;
	private JLabel text;
	private JButton weiter2;


public DialogueShop(String Title){
	super(Title);
	
	text = new JLabel("Guten Tag. Bitte schaue dich doch in unserem Laden ein wenig um!");				
	text.setFont(new Font("Serif", Font.PLAIN, 14));															
	getContentPane().add(text);

	weiter = new JButton("Weiter");														
	weiter.setBounds(80,200,90,30);
	weiter.addActionListener(this);
	
	weiter2 = new JButton("Weiter2");												
	weiter2.setBounds(80,200,90,30);
	weiter2.addActionListener(this);

	schliessen = new JButton("Schliessen");													
	schliessen.setBounds(400,200,100,30);
	schliessen.addActionListener(this);

	add(weiter);
	add(schliessen);															
	add(text);
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

if (e.getSource()==schliessen)											
	setVisible(false);

if (e.getSource()==weiter)
	text.setText("|Kannone 30 $|Schwert 20 $|Eisruestung 5 $|Feuerruestung 5 $|");				
	remove(weiter);
	add(weiter2);
	
if (e.getSource()==weiter2)
	text.setText("");
	remove(weiter2);
}
}
