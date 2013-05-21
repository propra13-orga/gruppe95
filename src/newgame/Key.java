package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Key extends Movement {

private Image image;

	public Key(int x, int y){												
		super(x,y);

		ImageIcon i = new ImageIcon("src/Resources/Key.png");					// holt sich die Grafiken fuer den Schluessel, wird im Board aufgerufen
		image = i.getImage();
		this.setImage(image);

	}

}