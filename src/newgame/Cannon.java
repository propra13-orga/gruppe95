package newgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/* Durch diese Klasse wird der Schuss mit der Kannone ermoeglicht.
 * Je Schussrichtung wird die Kannone mit den passenden Grafiken angezeigt.
 * Die Schuesse sind durch die -x,x,-y,y Koordinaten begrenzt.
 */


public class Cannon{

	private int x,y;
	Image image;
	boolean visible;
	private int width, height;
	private int shot_speed = 10;
	
	ImageIcon i0 = new ImageIcon("src/Resources/swordb.png");							
	ImageIcon i = new ImageIcon("src/Resources/missiler.png");
	ImageIcon i1 = new ImageIcon("src/Resources/missilel.png");
	ImageIcon i2 = new ImageIcon("src/Resources/missileu.png");
	ImageIcon i3 = new ImageIcon("src/Resources/missileb.png");
	
	
		public Cannon(int x, int y){
			
			image = i0.getImage();
			this.x = x;
			this.y = y;
			width = image.getWidth(null);													
			height = image.getHeight(null);
			visible = true;
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
			return image;
		}
	
			public void move_r(){
				x += shot_speed;						
				image =i.getImage();
				i.getImage();
				shot_limit_x1();					
			}										
											
			public void move_l(){	
				x -= shot_speed;
				image =i1.getImage();
				i1.setImage(image);
				shot_limit_x2();
			}
	
			public void move_u(){								 
				y -= shot_speed;
				image =i2.getImage();
				i2.setImage(image);
				shot_limit_y1();
			}
	
			public void move_d(){								
				y += shot_speed;
				image =i3.getImage();
				i3.setImage(image);
				shot_limit_y2();	
			}
	
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
