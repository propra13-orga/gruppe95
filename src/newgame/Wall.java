package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Movement{
	
private Image image;


	
	public Wall(int x, int y, String f){
		super(x,y);
		
		ImageIcon i = new ImageIcon("src/Resources/"+f+".png");					// holt sich die Grafik fuer die Waende, die in Board aufgerufen werden
		image = i.getImage();
		this.setImage(image);
		
	}

}
