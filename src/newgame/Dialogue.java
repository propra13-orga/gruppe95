package newgame;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


/* Es gibt einen Character in einigen Raeumen, der bei Kollision mit Diggy, Tipps geben kann.
 * 
 */


public class Dialogue extends JFrame implements ActionListener{
	
private JButton weiter;																										
private JButton schliessen;
private JLabel text;
private JButton weiter2,weiter3,weiter4;

	public Dialogue(String Title){
		super(Title);
	
	text = new JLabel("           Ich bin hier um dir zu helfen Diggy!");	
	text.setFont(new Font("Serif", Font.PLAIN, 14));
	//text.setBackground(Color.MAGENTA);
	getContentPane().add(text);

	weiter = new JButton("Weiter");																						
	weiter.setBounds(80,200,120,30);
	weiter.addActionListener(this);
	
	weiter2 = new JButton("Weiter");																					
	weiter2.setBounds(80,200,120,30);
	weiter2.addActionListener(this);
	
	weiter3 = new JButton("Weiter");																					
	weiter3.setBounds(80,200,120,30);
	weiter3.addActionListener(this);
	

	weiter4 = new JButton("Weiter");																					
	weiter4.setBounds(80,200,120,30);
	weiter4.addActionListener(this);

	schliessen = new JButton("Schliessen");																			

	schliessen.setBounds(380,200,120,30);
	schliessen.addActionListener(this);

	add(weiter);
	add(schliessen);																									
	add(text);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource()==schliessen){
			setVisible(false);
		}
		if (e.getSource()==weiter){
			text.setText("     du hast ein Raetsel zu loesen.Hinweis: versuch auf dem Wand zu schiessen");	
			remove(weiter);
			add(weiter2);
		}
		if (e.getSource()==weiter2){
			text.setText("     Beim Toeten von einem Gegner sammelst du Erfahrung");
			remove(weiter2);
			add(weiter3);
		}
		if (e.getSource()==weiter3){
			text.setText("     wenn du 20 Erfahrungspunkte einsammelst kriegst du einen extra Leben");
			remove(weiter3);
			add(weiter4);
		} 
		if (e.getSource()==weiter4){
			text.setText("                           Viel Glueck!");
			remove(weiter4);
		}
	}
}
