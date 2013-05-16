package newgame;

import java.awt.Image;

public class Movement {
	
private final int BLOCK = 50;									// f�r die Aktualisierung der Bewegung
	
	
	private int x;
	private int y;
	private Image image;
	
	public Movement(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Image getImage(){
		return this.image;
	}
	
	public void setImage(Image img){
		image = img;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX (int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	

}
