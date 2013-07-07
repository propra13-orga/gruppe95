package newgame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ergebnis extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L; 
private JButton schliessen;
private JLabel text;
	
	public ergebnis(String t){
		super("Ergebnis");
		text = new JLabel(t);	
		text.setFont(new Font("Serif", Font.PLAIN, 20));	
		
		getContentPane().add(text);
		
		schliessen = new JButton("Schliessen");																
		schliessen.setBounds(100,170,120,40);
		schliessen.addActionListener(this);
		
		add(schliessen);																						
		add(text);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource()==schliessen)																							
			setVisible(false);
	}
}
