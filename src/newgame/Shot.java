package newgame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Shot  {
	int x,y;
	Image img;
	boolean visible;
	private final int shot_speed = 5;
	
	public Shot(int x, int y){
	
		ImageIcon newShoot = new ImageIcon("src/Resources/missile1.png");
		img = newShoot.getImage();
		visible = true;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
	    return y;
	}
	
	public boolean getVisible(){						// Schuss sichtbar
		return visible;
	}
	public Image getImage(){
		return img;
	}
	
	public void move(){									// Schuss nach rechts mit Geschwindigkeit = 10
		
		   x = x+  shot_speed;
	        if (x > 950)
	            visible = false;						// ab w = 950 nicht mehr sichtbar
	}
	
}

   

