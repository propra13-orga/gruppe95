package newgame;


import java.awt.Image;
import javax.swing.ImageIcon;

/* Ghosts sind die beweglichen Gegner im Spiel. Durch Kollision verliert Diggy ein Leben.
 * 
 */

public class Ghost extends Movement {
	Image image;

	ImageIcon u = new ImageIcon("src/Resources/ep.png");			
	
	public Ghost(int x, int y){
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
