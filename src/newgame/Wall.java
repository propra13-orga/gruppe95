package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall extends Movement{
	private Image image;
	private int width;
	private int height;
	private int x, y;

	public Wall(int x, int y, String f){
		super(x,y);
		
		ImageIcon i = new ImageIcon("src/Resources/"+f+".png");					// holt sich die Grafik fuer die Waende, die in Board aufgerufen werden
		image = i.getImage();
		this.setImage(image);
		   width = image.getWidth(null);
	       height = image.getHeight(null);
	       visible = true;
	        this.x = x;
	        this.y = y;
	}

	public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
