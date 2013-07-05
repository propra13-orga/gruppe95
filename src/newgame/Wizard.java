package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

/* Der NPC im ersten Level gibt Auskunft.
 * 
 */
public class Wizard extends Movement{

private Image image;
ImageIcon i = new ImageIcon("src/Resources/shopkeeper.png");

	public Wizard(int x, int y){	
		super(x,y);		
		image = i.getImage();
		this.setImage(image);
	}

}
