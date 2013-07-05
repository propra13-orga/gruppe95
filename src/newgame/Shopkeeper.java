package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

/* Der Shopkeeper gibt Diggy Auskunft.
 * 
 */
public class Shopkeeper extends Movement {

	private Image image;
	ImageIcon i = new ImageIcon("src/Resources/shopkeeper.png");	

	public Shopkeeper(int x, int y){	
		super(x,y);				
		image = i.getImage();
		this.setImage(image);

	}

}
