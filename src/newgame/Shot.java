package newgame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Shot  {
	int x,y;
	Image img;
	boolean visible;
	private final int shot_speed = 30;

	
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
	
	
	public void move_r(){
												// Schuss nach rechts mit Geschwindigkeit
		x += shot_speed;						// dabei wird mit den Funktionen shot_limit_x(bzw.y) darauf
	
		shot_limit_x1();						// geachtet dass es ueber das Board nicht sichtbar ist
	}
	
	public void move_l(){	
	
		x -= shot_speed;
	
	
	shot_limit_x2();
	}
	
	public void move_u(){								 
		y -= shot_speed;
	
		shot_limit_y1();
		
	}
	
	public void move_d(){								
		y += shot_speed;
	
		shot_limit_y2();	
		
	}
	
	public void shot_limit_x1(){
		if (x >= 920)
	         visible = false;						// Wenn der Schuss ausserhalb des Boards ist -> nicht mehr sichtbar
	}
	
	public void shot_limit_y1(){
		 if (y>= 720)
	         visible = false;						
	
	}
	
	public void shot_limit_x2(){
		 if (x <=0)
	         visible = false;						
	}
	
	public void shot_limit_y2(){
		 if (y<=0)
	         visible = false;						
	
	}
}

   

