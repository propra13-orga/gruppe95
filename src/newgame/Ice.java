package newgame;

import java.awt.Image;
import javax.swing.ImageIcon;

/* Diese Klasse steht fuer die Schuesse des Gegners Boss2.
 * 
 */

public class Ice extends Movement  {
	Image image;

	ImageIcon u = new ImageIcon("src/Resources/ice.png");			
	
	public Ice(int x, int y){
		super(x,y);
		image = u.getImage();
		this.setImage(image);
	}
		public void move(int x, int y){									
			int nx = this.getX() + x;										
			int ny = this.getY() + y;
			this.setX(nx);
			this.setY(ny);
		}
	}