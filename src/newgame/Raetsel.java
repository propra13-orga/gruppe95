package newgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;




public class Raetsel extends JFrame implements ActionListener{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Image imgcode;
private ImageIcon ii;
private String s;





	public Raetsel(int a) throws IOException{
		setFocusable(true);
		addKeyListener(new Ap());
		setBackground(Color.BLACK);
		s=Integer.toString(a);
		ii=(new ImageIcon("src/Resources/code"+s+".png"));
		imgcode=ii.getImage();
		repaint();
		
	}
	 private class Ap extends KeyAdapter{															// fuer rechts: holt das Bild mit Position rechts
		
		 	public  void keyPressed(KeyEvent e){

		 		int key = e.getKeyCode();
		 		if (key == KeyEvent.VK_S) {
		 			setVisible(false);
		 		}
		 		if (key==KeyEvent.VK_C){
		 			codeAngabe();
		 		}
		 	}
	 }
	
	public void paint(Graphics g){
		super.paint(g);
		// g.drawString(s,50,50);
		 g.drawImage(imgcode,0,0,this);	
	}
	
	public void codeAngabe(){																	//definiert die Methode raetsel genauer, mit Close-Operation, Name, Layout und Position

		JFrame CodeAn = new Code("Code Eingeben");
		CodeAn.setSize(200,100);
		CodeAn.setLocationRelativeTo(null);
		CodeAn.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		CodeAn.setVisible(true);
		CodeAn.setFocusable(true);
		CodeAn.setLayout(new BorderLayout());
		CodeAn.setLayout(null);
		CodeAn.add(new Code("Code Eingeben"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
}