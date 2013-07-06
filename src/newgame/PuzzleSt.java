package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class PuzzleSt extends Movement {
	Image image;
	private int width;
	private int height;
	private int x, y;
	ImageIcon u = new ImageIcon("src/Resources/ps.png");

	public PuzzleSt(int x, int y) {
		super(x, y);
		image = u.getImage();
		this.setImage(image);
		visible=true;
	}
	public Image getImage() {
        return image;
    }

	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


}
