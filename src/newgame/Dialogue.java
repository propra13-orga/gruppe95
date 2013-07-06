package newgame;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD
/* Es gibt einen Character in einigen Raeumen, der bei Kollision mit Diggy, Tipps geben kann.
 * 
 */

=======
>>>>>>> 94ee64b91e4ed9a22d048419cddccd4b72ca9ad7
public class Dialogue extends JFrame implements ActionListener{
	
private JButton weiter;																										
private JButton schliessen;
private JLabel text;
private JButton weiter2;

	public Dialogue(String Title){
		super(Title);
	
	text = new JLabel("Der boese Zauberer verbreitet in unserem Reich Angst und Schrecken.");	
	text.setFont(new Font("Serif", Font.PLAIN, 14));																	
	getContentPane().add(text);

<<<<<<< HEAD
	weiter = new JButton("Weiter");																							
	weiter.setBounds(80,200,90,30);
	weiter.addActionListener(this);
	
	weiter2 = new JButton("Weiter2");																						
	weiter2.setBounds(80,200,90,30);
	weiter2.addActionListener(this);

	schliessen = new JButton("Schliessen");																
=======
	weiter = new JButton("Weiter");																							//definiert Position und Gr��e f�r die Buttons
	weiter.setBounds(80,200,90,30);
	weiter.addActionListener(this);
	
	weiter2 = new JButton("Weiter2");																						//definiert Position und Gr��e f�r die Buttons
	weiter2.setBounds(80,200,90,30);
	weiter2.addActionListener(this);

	schliessen = new JButton("Schliessen");																					//definiert Position und Gr��e f�r die Buttons
>>>>>>> 94ee64b91e4ed9a22d048419cddccd4b72ca9ad7
	schliessen.setBounds(400,200,100,30);
	schliessen.addActionListener(this);

	add(weiter);
	add(schliessen);																									
	add(text);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource()==schliessen){
			setVisible(false);
		}
		if (e.getSource()==weiter){
			text.setText("Zieh los und besiege den boesen Zauberer! Rette uns!");			
			remove(weiter);
			add(weiter2);
		}
		if (e.getSource()==weiter2){
			text.setText("");
			remove(weiter2);
		}
	}
}
