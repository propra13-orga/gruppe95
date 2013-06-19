package newgame;

import java.awt.Color;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_over extends JPanel implements ActionListener {

	private JButton ok;
	
	public Game_over(){
	
		setBackground(Color.BLACK);				// hier kann ein Hintergrundbild 'Game Over' hinzugef�gt werden
		
		
		setFocusable(true);
		

		 ok = new JButton("OK");						
		 ok.setFocusPainted(false);
		 ok.setBackground(Color.BLACK);
		 ok.setForeground(Color.RED);
		 ok.addActionListener(this);
		 add(ok);
		 
		 JButton over = new JButton("Game Over");
		 over.setLocation(200, 0);
		 over.setIcon(new ImageIcon("src/Resources/game_over.png"));
		 over.setBackground(Color.DARK_GRAY);
		 over.setForeground(Color.white);
		 over.setBorderPainted(false);
		 over.setBounds(200, 200, 200, 200);
		 add(over);
		 
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==ok) {
		restart_frame();
	}
}
	
	public  void restart_frame(){								// Methode f�r das Neusart des Menues
	 new frame("DUNGEON CRAWLER *Menue*");
	}
}