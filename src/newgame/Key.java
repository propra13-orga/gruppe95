package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

/* Wenn Diggy die Obergegner besiegt erscheint ein Schluessel.
 * Durch Kollision landet Diggy im naechsten Level.
 */

public class Key extends Movement {

private Image image;
ImageIcon i = new ImageIcon("src/Resources/Key.png");	

	public Key(int x, int y){												
		super(x,y);
		image = i.getImage();
		this.setImage(image);

	}

}