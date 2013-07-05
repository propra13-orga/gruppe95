package newgame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/* Durch diese Klasse wird der Schuss mit Feuerbaellen ermoeglicht.
 * Die Schuesse sind durch die -x,x,-y,y Koordinaten begrenzt.
 */

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
        width = img.getWidth(null);												
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

	public void setVisible(Boolean visible) {						
	        this.visible = visible;
	}

	public Rectangle getBounds() {											
	        return new Rectangle(x, y, width, height);
	}

	public Image getImage(){
		return img;
	}
	
	/* Die Schuesse in verschiedenen Richtungen.
	 * 
	 */
	public void move_r(){
		x += shot_speed;				
		shot_limit_x1();					
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
	
	/* Die Eingrenzung der Schuesse im Spielfeld.
	 * 
	 */
	
	public void shot_limit_x1(){
		if (x >= 920)
	         visible = false;						
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

   

