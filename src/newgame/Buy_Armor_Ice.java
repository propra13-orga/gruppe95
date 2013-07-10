package newgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/* Diese Klasse stellt die Eisruestung im Shop dar.
 * Bei Kollision mit Eisruestung und Diggy, 
 * also beim Kauf der Eisruestung, ist sie in anderen Shops nicht mehr verfuegbar.  
 * Wenn Diggy die Eisruestung trägt, erleidet er kein Schaden durch Boss2, der mit Eisbaellen wirft.
 */

public class Buy_Armor_Ice extends Movement  {
	Image image;
	private int width;
	private int height;
	private int x, y;
    
	ImageIcon u = new ImageIcon("src/Resources/ruestungeis.png");		
	
	
	public Buy_Armor_Ice(int x, int y){
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
