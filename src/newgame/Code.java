package newgame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;



public class Code extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField text;
	public Code(String Title){
		super(Title);
		text=new JTextField("Code eingeben :");
		text.addActionListener(this);
	
		add(text);
	
	}	
	
	public void ergebnis( String t){																	//definiert die Methode raetsel genauer, mit Close-Operation, Name, Layout und Position

		JFrame ergebnis = new ergebnis(t);
		ergebnis.setSize(400,250);
		ergebnis.setLocationRelativeTo(null);
		ergebnis.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ergebnis.setVisible(true);
		ergebnis.setFocusable(true);
		ergebnis.setLayout(new BorderLayout());
		ergebnis.setLayout(null);
		ergebnis.add(new ergebnis(t));
	}
	@Override

		public void actionPerformed(ActionEvent e) {

			if (e.getSource()==text){	
				setVisible(false);
				String s=text.getText();
				s=s.substring(15,21);
 			if (s.contains("158273")){
 				ergebnis("Rätsel erfolgreich gelöst!  :) ");
 			}
 			else {
 				System.out.println(s);
 				ergebnis("Code falsch eingegeben");
 			}
 			
				
			}
	}
}
