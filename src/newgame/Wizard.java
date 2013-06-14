package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wizard extends Movement {

private Image image;

	public Wizard(int x, int y){	
		
		super(x,y);

		ImageIcon i = new ImageIcon("src/Resources/shopkeeper.png");					// holt sich die Grafiken fuer den NPC, wird im Board aufgerufen
		image = i.getImage();
		this.setImage(image);

	}

}
