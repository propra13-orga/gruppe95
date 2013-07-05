package newgame;

import java.awt.Image;
import javax.swing.ImageIcon;


	public class Boss3 extends Movement  {
		Image image;
		ImageIcon u = new ImageIcon("src/Resources/e3.png");			
	
		public Boss3(int x, int y){
			super(x,y);
			image = u.getImage();
			this.setImage(image);	
		}
		/* Methode fuer die Bewegung eines der Obergegner
		 * 
		 */
	
		public void move(int x, int y){										
			int nx = this.getX() + x;										
			int ny = this.getY() + y;
			this.setX(nx);
			this.setY(ny);
		}

	}