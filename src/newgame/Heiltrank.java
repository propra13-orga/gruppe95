package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Heiltrank extends Movement {

private Image image;

	public Heiltrank(int x, int y){	
		
		super(x,y);

		ImageIcon i = new ImageIcon("src/Resources/herz.png");					// holt sich die Grafiken fuer den Manatrank, wird im Board aufgerufen
		image = i.getImage();
		this.setImage(image);

	}

}