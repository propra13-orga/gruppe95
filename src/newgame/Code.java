package newgame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;


/*
 * Es werden Fenster angezeigt, wenn Diggy den Code richtig bzw. falsch erraet.
 */
public class Code extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L;
private JTextField text;
	
	public Code(String Title){
		super(Title);
		text=new JTextField("  Code eingeben :");
		text.addActionListener(this);
		add(text);
	}	
	
		public void ergebnis( String t){															

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
					ergebnis("   Raetsel erfolgreich geloest!  :) ");
					
					}else {
						System.out.println(s);
						ergebnis("   Code falsch eingegeben");
					}
 				}
			}
		}
