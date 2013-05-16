package newgame;

import java.awt.Image;

public class Movement {
	
<<<<<<< HEAD
private final int BLOCK = 50;									// f�r die Aktualisierung der Bewegung
=======
private final int BLOCK = 35;									// fuer die Aktualisierung der Bewegung
>>>>>>> 283e202c1904b94deaacbfbea526d6657217c171
	
	
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
