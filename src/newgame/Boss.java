package newgame;


import java.awt.Image;
import javax.swing.ImageIcon;




	public class Boss extends Movement{
		Image image;


		public Boss(int x, int y,String s){
			super(x,y);
			ImageIcon u = new ImageIcon("src/Resources/"+s+".png");	
			image = u.getImage();
			this.setImage(image);	
		}


		/* Methode fuer die Bewegung eines der drei Obergegner
		 * 
		 */


		public void move(int x, int y){										
			int nx = this.getX() + x;										
			int ny = this.getY() + y;
			this.setX(nx);
			this.setY(ny);
		}
	}

