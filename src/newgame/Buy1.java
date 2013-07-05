package newgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/* Diese Klasse stellt den Schwert im Shop dar, den Diggy sich kaufen kann.
 * Mit dem Schwert kann Diggy die Enemys (Voegel) toeten.
 * 
 */

	public class  Buy1 extends Movement {

	private Image image;
	private int width;
    private int height;
    private int x,y;
    
	ImageIcon i = new ImageIcon("src/Resources/sword.png");		

		public Buy1(int x, int y){	
			super(x,y);
			image = i.getImage();
			this.setImage(image);
		    width = image.getWidth(null);								
		    height = image.getHeight(null);
		    visible = true;
		}
		
		public Rectangle getBounds() {
	        return new Rectangle(x, y, width, height);
	    }

	}
