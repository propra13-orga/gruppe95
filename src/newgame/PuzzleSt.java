package newgame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PuzzleSt extends Movement {
	Image image;
	ImageIcon u = new ImageIcon("src/Resources/ps.png");

	public PuzzleSt(int x, int y) {
		super(x, y);
		image = u.getImage();
		this.setImage(image);
		visible=true;
	}
}
