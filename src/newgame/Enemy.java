package newgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/* Es gibt Hindernisse im Spiel in Form von Voegel. Bei Kollision verliert Diggy ein Leben.
 * Diese können durch Feuerschuesse oder durch Schwertkampf getotet werden.
 */

public class Enemy extends Movement {

private Image image;
private int width;
private int height;
private int x, y;

	ImageIcon i = new ImageIcon("src/Resources/epi1.png");	

	public Enemy(int x, int y){
		super(x,y);		
		ImageIcon i = new ImageIcon("src/Resources/epi1.png");				
		image = i.getImage();
		this.setImage(image);
	    width = image.getWidth(null);										
	    height = image.getHeight(null);
	    visible = true;
	        this.x = x;
	        this.y = y;
	}
			
		public Image getImage() {
	            return image;
	        }

	        public Rectangle getBounds() {									
	            return new Rectangle(x, y, width, height);
	        }
 }

