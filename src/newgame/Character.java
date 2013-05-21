package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Character extends Movement {
	
	Image image;
	ImageIcon u = new ImageIcon("src/Resources/Character.png");			// holt sich die noetigen Grafiken fuer den Charakter
	
	public Character(int x, int y){
		super(x,y);
		image = u.getImage();
		this.setImage(image);
	}
	
	public void move(int x, int y){										// fuehrt die Berechnung zb. fuer rechts aus(BLOCK,0)
		int nx = this.getX() + x;										// legt die Bewegungsbedingungen fest
		int ny = this.getY() + y;
		this.setX(nx);
		this.setY(ny);
	}

}
