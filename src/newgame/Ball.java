package newgame;

import java.awt.Image;
import javax.swing.ImageIcon;


	public class Ball extends Movement  {
		Image image;
		ImageIcon u = new ImageIcon("src/Resources/ball2.png");			
	
		public Ball(int x, int y){
			super(x,y);
			image = u.getImage();
			this.setImage(image);
		}
		
		/* Methode fuer die Bewegung vom Schuss des Gegners Boss3
		 * 
		 */
		
		public void move(int x, int y){									
		int nx = this.getX() + x;										
		int ny = this.getY() + y;
		this.setX(nx);
		this.setY(ny);
		}
	}
