package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Movement {

private Image image;
private int width;
private int height;
private int x, y;

	public Enemy(int x, int y){
		super(x,y);
		
		ImageIcon i = new ImageIcon("src/Resources/pilz1.png");					// holt sich die Grafiken für das Feuer, die im Board eingebunden werden
		image = i.getImage();
		this.setImage(image);
	    width = image.getWidth(null);											// fuer Kollision mit Schuss
	    height = image.getHeight(null);
	    visible = true;
	        this.x = x;
	        this.y = y;
	}
			
		public Image getImage() {
	            return image;
	        }

	        public Rectangle getBounds() {										// Kollision Detection
	            return new Rectangle(x, y, width, height);
	        }
 }

