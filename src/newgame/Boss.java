package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Boss extends Movement  {
	Image image;
	private int width;
	private int height;
	private int x, y;
	ImageIcon u = new ImageIcon("src/Resources/bossv.png");			// holt sich die noetigen Grafiken fuer den Checkpoint
	
	public Boss(int x, int y){
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
	public Image getImage() {
        return image;
    }

	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
