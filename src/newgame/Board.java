package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Board extends JPanel{

Image image;
	
	ImageIcon r = new ImageIcon("src/Resources/rechts.png");				// fuer versch. Positionen rechts,links,oben,unten
	ImageIcon l = new ImageIcon("src/Resources/rechts.png");
	ImageIcon t = new ImageIcon("src/Resources/rechts.png");
	ImageIcon b = new ImageIcon("src/Resources/rechts.png");
	
	private int BLOCK = 70;
	
	java.util.List<Movement> walls = new java.util.ArrayList<Movement>();		// Array für die Wände
	
	private Character Jay;
	private int w = 0;
	private int h = 0;
	
	private String level1 = "##############\n"
						+	"#            #\n"
						+	"#  ###  ##  ##\n"
						+	"#  ###  ##  ##\n"
						+	"#       ##  ##\n"
						+	"#       ##  ##\n"
						+	"#       ##  ##\n"
						+	"#       ##  ##\n"
						+	"#@      ##  ##\n"
						+	"##############\n";
	
	
	public Board(){
		addKeyListener(new Ap());
		setFocusable(true);
		initWorld();
	}
	
	

	public int getBoardWidth(){
		return this.w;
		
	}
	
	public int getBoardHeight(){
		return this.h;
		
	}
	
	public Image getImage(){
		return image;
		
	}
	
	public final void initWorld(){										// zeichnet level1 mit walls und character
		
		int x = 0;
		int y = 0;
		Wall wall;
		
		for(int i = 0; i < level1.length(); i++){
			
			char obj = level1.charAt(i);
			
			if(obj == '\n'){
				y = y + BLOCK;
				x = 0;
			}else if(obj == '#'){
				wall = new Wall(x,y);
				walls.add(wall);
				x = x + BLOCK;
			}else if(obj == '@'){														// wo character sich beim Start befinden soll
				Jay = new Character(x,y);
				x = x + BLOCK;
			}else if(obj == ' '){
				x = x + BLOCK;
			}
			
		}
	}
	
	public void buildWorld(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0, this.getWidth(), this.getHeight());
		
		ArrayList<Movement> world = new ArrayList<Movement>();
		world.addAll(walls);
		world.add(Jay);
		
		for(int i = 0; i < world.size(); i++){
			Movement obj = (Movement) world.get(i);
			g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);
			
		}
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		buildWorld(g);
	}
	
	private class Ap extends KeyAdapter{											// für rechts: holt das Bild mit Position rechts
																					// durch die class Charackter bewegt sich Jay ein Block nach rechts..
		public  void keyPressed(KeyEvent e){
			
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT){
			
				image = r.getImage();
				Jay.setImage(image);
				Jay.move(BLOCK,0);
				
			}
			
			else if(key == KeyEvent.VK_LEFT){
				image = l.getImage();
				Jay.setImage(image);
				Jay.move(-BLOCK,0);
			
			}
			
			
			else if(key == KeyEvent.VK_UP){
				
				
				image = t.getImage();
				Jay.setImage(image);
				Jay.move(0, -BLOCK);
				
			}
			
			
			else if(key == KeyEvent.VK_DOWN){
				image = b.getImage();
				Jay.setImage(image);
				Jay.move(0,BLOCK);
			}
			repaint();
		}
		
	}
	
}
