package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Storyfield extends Movement {

private Image image;

	public Storyfield(int x, int y){	
		
		super(x,y);

		ImageIcon i = new ImageIcon("src/Resources/key.png");					// holt sich die Grafiken fuer das Storyfeld, wird im Board aufgerufen
		image = i.getImage();
		this.setImage(image);

	}

}

