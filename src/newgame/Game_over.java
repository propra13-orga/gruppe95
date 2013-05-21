package newgame;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game_over extends JPanel implements ActionListener {

	private JButton ok;
	
	public Game_over(){
	
	setBackground(Color.DARK_GRAY);				// hier kann ein Hintergrundbild 'Game Over' hinzugefügt werden
	setFocusable(true);
	

	
		 ok = new JButton("OK");						
		 ok.setFocusPainted(false);
		 ok.setBackground(Color.BLACK);
		 ok.setForeground(Color.RED);
		 ok.addActionListener(this);
		 add(ok);
		 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		 if (e.getSource()==ok) {
		 restart_frame();
	}
		
		// TODO Auto-generated method stub
		
	}
	
	
	
public  void restart_frame(){								// Methode für das Neusart des Menues
	 
	 new frame("DUNGEON CRAWLER *Menue*");
	
	
		 }
}