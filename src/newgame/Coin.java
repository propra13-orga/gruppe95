package newgame;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Coin extends Movement {

private Image image;


	
	public Coin(int x, int y){
		super(x,y);
		ImageIcon i = new ImageIcon("src/Resources/Coin.png");					// holt sich die Grafik fuer die Waende, die in Board aufgerufen werden
		image = i.getImage();
		this.setImage(image);
	}		

}