package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sword{

	private int x,y;
	Image img;
	Image image;
	boolean visible;
	private int width, height;
	private int sword_die = 50;
	
	public Sword(int x, int y){
		ImageIcon newSword = new ImageIcon("src/Resources/swordb.png");
		img = newSword.getImage();
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
	
	public void move_r_sword(){
		x += sword_die;							// Schuss nach rechts mit Geschwindigkeit
		shot_limit_x1();					
	}											// dabei wird mit den Funktionen shot_limit_x(bzw.y) darauf
												// geachtet dass es ueber das Board nicht sichtbar ist
	public void move_l_sword(){	
		x -= sword_die;
		shot_limit_x2();
	}
	
	public void move_u_sword(){								 
		y -= sword_die;
		shot_limit_y1();
	}
	
	public void move_d_sword(){								
		y += sword_die;
		shot_limit_y2();	
	}
	
	public void shot_limit_x1(){
		if (x >= 100)								// mit entfernung von 20 kann diggy mit s
	         visible = false;						// Wenn der Schuss ausserhalb des Boards ist -> nicht mehr sichtbar
	}
	
	public void shot_limit_y1(){
		 if (y>=100)
	         visible = false;						
	
	}
	
	public void shot_limit_x2(){
		 if (x >=100)
	         visible = false;						
	}
	
	public void shot_limit_y2(){
		 if (y<=100)
	         visible = false;						
	}
}

   