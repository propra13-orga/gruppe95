package newgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/* Diese Klasse stellt die Feuerruestung im Shop dar.
 * Bei Kollision mit Feuerruestung und Diggy, 
 * also beim Kauf der Feuerruestung, ist sie in anderen Shops nicht mehr verfuegbar.  
 * Wenn Diggy die Feuerruestung trägt, erleidet er kein Schaden durch Boss3, der mit Feuerbaellen wirft.
 */


	public class Buy_Armor_Fire extends Movement  {
	Image image;
	private int width;
	private int height;
	private int x, y;
    
	ImageIcon u = new ImageIcon("src/Resources/ruestungfeuer.png");			
	
		public Buy_Armor_Fire(int x, int y){
			super(x,y);
			image = u.getImage();
			this.setImage(image);	
			visible = true;
			width = image.getWidth(null);								
			height = image.getHeight(null);
		}
	
		public Rectangle getBounds() {
			return new Rectangle(x, y, width, height);
		}
}
