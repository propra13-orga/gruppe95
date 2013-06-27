package newgame;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Coin extends Movement {

private Image image;
private int width;
private int height;
private int x, y;

	public Coin(int x, int y){
		super(x,y);
		ImageIcon i = new ImageIcon("src/Resources/Coink.png");					// holt sich die Grafik fuer die Waende, die in Board aufgerufen werden
		image = i.getImage();
		this.setImage(image);
		   	width = image.getWidth(null);										// fuer Kollsion mit Schuss
	        height = image.getHeight(null);
	        visible = true;
	        this.x = x;
	        this.y = y;
	}
    
	public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {												// Kollision mit Schuss 
        return new Rectangle(x, y, width, height);
    }
 }