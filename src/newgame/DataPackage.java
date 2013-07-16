package newgame;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Timer;



public class DataPackage implements Serializable
{
	public Image image;
	public float n = 0.0f;
	public float m = 0.0f;
	public Shot shot;
	public int x ;
	public int y ;
	public int nx = this.getX() + x;										
	public int ny = this.getY() + y;
	//this.setX(nx);
	//this.setY(ny);
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	 public ArrayList<Shot> getShots() {																
	        return shots;
	    }

	

	
	public void setX (int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	


	
	
	int a;
																		
	public Character Jay;
	
	public int shotx,shoty;
	public String raum="";
	public String lr,rooms,lrs; 													
	public ArrayList<Sword> swords;
	public ArrayList<Cannon> cannons;													
	public ArrayList<Shot> shots;	
	
	public int mix,miy;
	public  ArrayList<Shot> shotsnw;
	public Timer timer;
	public int BLOCK = 50;															
	public int position;
	public int ruban=0,xruban;
	public int life=3, xlife;
	public int mana = 3;
	public int use_invisible=3;
	public int k,z,posX,posY;
	public boolean ingame,failed,get_sword, get_cannon, get_invisible, armor_ice, armor_fire;
	public boolean bought1, bought2, bought3, bought4;
	public checkpoint check;
	public Ghost Geist,geist2;
	public Boss Monster,Monster2,Monster3;
	public Ball ball;
	public Ice ice;
	public boolean besuch = false;
	
	public String username = "";
	
}
