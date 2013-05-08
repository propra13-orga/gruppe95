package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Movement{
	
private Image image;
	
	public Wall(int x, int y){
		super(x,y);
		
		ImageIcon i = new ImageIcon("src/Resources/wand.png");
		image = i.getImage();
		this.setImage(image);
		
	}

}
