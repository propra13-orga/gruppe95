package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/* Die Klasse Character stellt die Hauptfigur 'Diggy' dar.
 * 
 */

public class Character extends Movement {
	
	Image image;
    private int width;
    private int height;
    private int x,y;

	ImageIcon u = new ImageIcon("src/Resources/Character.png");
	
	public Character(int x, int y){
		super(x,y);
		image = u.getImage();
		this.setImage(image);
		visible = true;
	    width = image.getWidth(null);									
	}
	
		public void move(int x, int y){										
			int nx = this.getX() + x;										
			int ny = this.getY() + y;
			this.setX(nx);
			this.setY(ny);
		}
	
		public Rectangle getBounds() {
	        return new Rectangle(x, y, width, height);
	    }
	}
