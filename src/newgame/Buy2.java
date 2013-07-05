package newgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/* Diese Klasse stellt die Kanone im Shop dar, den Diggy sich kaufen kann.
 * Mit der Kannone kann Diggy den Boss2 toeten.
 * 
 */

	public class  Buy2 extends Movement {

	private Image image;
	private int width;
    private int height;
    private int x,y;

		public Buy2(int x, int y){	
			
			super(x,y);
			ImageIcon i = new ImageIcon("src/Resources/missiler.png");					
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
