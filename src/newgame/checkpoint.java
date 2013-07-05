package newgame;

import java.awt.Image;
import javax.swing.ImageIcon;

/* Durch die Klasse Checkpoint muss Diggy nach Niederlage nicht vom ersten Level anfangen.
 * 
 */

public class checkpoint extends Movement {

	Image image;
	ImageIcon u = new ImageIcon("src/Resources/check1.png");		
	
	public checkpoint(int x, int y){
		super(x,y);
		image = u.getImage();
		this.setImage(image);
	}
}
