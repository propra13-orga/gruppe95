package newgame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Shot  {
	int x,y;
	Image img;
	boolean visible;
	private final int shot_speed = 15;
	
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
	
	public boolean getVisible(){						
		return visible;
	}
	public Image getImage(){
		return img;
	}
	
	
	public void move_r(){								// Schuss nach rechts mit Geschwindigkeit
		x = x + shot_speed;								// dabei wird mit den Funktionen shot_limit_x(bzw.y) darauf
		shot_limit_x();									// geachtet dass es ueber das Board nicht sichtbar ist
	}
	
	public void move_l(){								
		x = x - shot_speed;
		shot_limit_x();
	}
	
	public void move_u(){								 
		y = y - shot_speed;
		shot_limit_y();
	}
	
	public void move_d(){								
		y = y + shot_speed;
		shot_limit_y();						
	}
	
	public void shot_limit_x(){
		 if (x > 880)
	         visible = false;						// ab x = 880 nicht mehr sichtbar
	}
	
	public void shot_limit_y(){
		 if (y > 500)
	         visible = false;						// ab y = 500
	}
}

   

