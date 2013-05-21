package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Movement{
	
private Image image;
	
	public Wall(int x, int y){
		super(x,y);
		
		ImageIcon i = new ImageIcon("src/Resources/wand.png");					// holt sich die Grafik fuer die Waende, die in Board aufgerufen werden
		image = i.getImage();
		this.setImage(image);
		
	}

}
