package newgame;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


/* Diggy hat die Moeglichkeit in den Levels Muenzen zu sammeln, um im Shop Waffen und Ruestungen zu kaufen.
 * 
 */

public class Coin extends Movement {

private Image image;
private int width;
private int height;
private int x, y;

	ImageIcon i = new ImageIcon("src/Resources/Coink.png");	

	public Coin(int x, int y){
		super(x,y);		
		image = i.getImage();
		this.setImage(image);
		width = image.getWidth(null);									
	    height = image.getHeight(null);
	    visible = true;
	    this.x = x;
	    this.y = y;
	}
 
    public Rectangle getBounds() {												
        return new Rectangle(x, y, width, height);
    }
 }