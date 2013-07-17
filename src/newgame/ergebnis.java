package newgame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ergebnis extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L; 
private JButton schliessen,weiter, weiter2;
private JLabel text;
	
	public ergebnis(String t){
		
		super("Ergebnis");
		text = new JLabel(t);	
		text.setFont(new Font("Serif", Font.PLAIN, 20));	
		
		getContentPane().add(text);
		
		
		
		schliessen = new JButton("Schliessen");																
		schliessen.setBounds(400,180,120,40);
		schliessen.addActionListener(this);

		weiter = new JButton("Weiter");														
		weiter.setBounds(80,180,120,40);
		weiter.addActionListener(this);
		
		weiter2 = new JButton("Weiter2");												
		weiter2.setBounds(80,180,120,40);
		weiter2.addActionListener(this);
		if (text.getText()=="   Raetsel erfolgreich geloest! dafür kriegst du Diggy eine besondere Hilfe"){
			add(weiter);
		}
		add(schliessen);																						
		add(text);
		
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource()==schliessen)																							
			setVisible(false);
		else if (e.getSource()==weiter){
			text.setText("Diggy! Du musst unbedingt eine Kanone zu kaufen um den letzten Boss zu besiegen");	
			remove(weiter);
			add(weiter2);
		}
		else if (e.getSource()==weiter2){
			text.setText("           Viel Glück dabei! :)");
			remove(weiter2);
		}
	}
}
