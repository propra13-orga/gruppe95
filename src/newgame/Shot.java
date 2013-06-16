package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Shot{

	private int x,y;
	Image img;
	Image image;
	boolean visible;
	private int width, height;
	private int shot_speed = 50;
	
	public Shot(int x, int y){
		ImageIcon newShoot = new ImageIcon("src/Resources/ball.png");
		img = newShoot.getImage();
		visible = true;
		this.x = x;
		this.y = y;
        width = img.getWidth(null);													// fuer Kollision Bild
        height = img.getHeight(null);
    }
	
	public int getX() {
		return x;
	}

	public int getY() {
	    return y;
	}
	
	public boolean isVisible() {
	        return visible;
	}

	public void setVisible(Boolean visible) {								// setzt Kollision im Board fest
	        this.visible = visible;
	}

	public Rectangle getBounds() {											// Kollision Detection
	        return new Rectangle(x, y, width, height);
	}

	public Image getImage(){
		return img;
	}
	
	public void move_r(){
		x += shot_speed;						// Schuss nach rechts mit Geschwindigkeit
		shot_limit_x1();					
	}											// dabei wird mit den Funktionen shot_limit_x(bzw.y) darauf
												// geachtet dass es ueber das Board nicht sichtbar ist
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

   

