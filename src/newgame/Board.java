package newgame;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;




public class Board extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	Image img;  													//Bild fuer den Hintergrund (WEG)
	private Character Jay;
	private String raum="";
	private String lr,rooms,lrs; 									//lr fuer der Name der raumdatei, w:wandbild , h:hintergrundsbild
	private ArrayList<Shot> shots;									//Array fuer die Zeichnung der Schuesse
	private Timer timer;
	private int BLOCK = 50;											// 50* 50 Pixel
	private int position;
	private int ruban=0; private int xruban;
	private int k,posX,posY;
	boolean ingame,failed;
	private checkpoint check;

	ImageIcon r = new ImageIcon("src/Resources/r1.png");						// fuer versch. Positionen rechts, links, oben, unten
	ImageIcon l = new ImageIcon("src/Resources/l1.png");
	ImageIcon t = new ImageIcon("src/Resources/Character top.png");
	ImageIcon b = new ImageIcon("src/Resources/Character.png");

	java.util.List<Movement> enemys = new java.util.ArrayList<Movement>();
	java.util.List<Movement> walls = new java.util.ArrayList<Movement>();		// Array fuer Waende, Gegner, Schluessel, NPC, Muenzen und Ladenbesitzer
	java.util.List<Movement> keys = new java.util.ArrayList<Movement>();
	java.util.List<Movement> wizards = new java.util.ArrayList<Movement>();
	java.util.List<Movement> storyfields = new java.util.ArrayList<Movement>();
	java.util.List<Movement> coins = new java.util.ArrayList<Movement>();
	java.util.List<Movement> shopkeepers = new java.util.ArrayList<Movement>();
	
	Image image1 = image = r.getImage();										// f�r das aktualisieren nach Kollision
	Image image2 = image = l.getImage();										// mit Jay.getImage() Abfrage
	Image image3 = image = t.getImage();	
	Image image4 = image = b.getImage();	
	
	public Board() throws IOException{
		lr="l1r1";
		addKeyListener(new Ap());
		setFocusable(true);		
		initWorld(image4);
		ingame = true;
	    shots = new ArrayList<Shot>();
		timer = new Timer(5, this);												//zeichnet alle  5ms den Board (Schuesse)
        timer.start();
       

	}

	public void loeschen(boolean b){											//loescht alle Inhalte 
		coins.clear();
		walls.clear();
		enemys.clear();
		keys.clear();
		wizards.clear();
		storyfields.clear();
		shopkeepers.clear();
		if (b) raum="";
		if (failed) {
			if (lr==lrs){
				raum=rooms;
			}
			ruban=0;
		}
		
	}
	
	public void collision(int movx,int movy,Image image){											// char pos mit image ge�ndet um statt mit  t,v Bild festzulegen man abfragt wo er guckt 
		
		int xx = ((Jay.getX()+movx)/BLOCK);																	 							//xx und yy sind die imaginaere Koordinaten innerhalb des Strings Variable (level).
		int yy=(Jay.getY()+movy)/BLOCK;																									//xx und yy werden dafuer gerechnet um zu erkennen, ob an der Stelle wohin sich die Spielfigur bewegen will, kein # im variable level bzw kein Stueck Mauer im Spielfeld gibt
		if ((raum.charAt(yy*20+xx)!='#')&&(raum.charAt(yy*20+xx)!='~')&&(raum.charAt(yy*20+xx)!='s')&&(xx>=0)||(Jay.getY()<0))		    //yy wird mal 20 multipliziert da es in jeder linie des Spielfelds 20 Bloecke gibt(also in jeder linie des strings level gibt es 20 zeichen)
		{																							        							//Wandkollision
			Jay.move(movx,movy);																		    							//erst wenn es kein Stueck Mauer, keinen NPC/Ladenbesitzer oder einen Ein-Ausgang gibt(entweder xx oder yy <0 ist) darf/kann sich die Spielfigur bewegen
			if (raum.charAt(yy*20+xx)=='a'){
				ruban= ruban+1;
				System.out.print("ruban = ");
				System.out.println(ruban);
				if (raum.contains("@") )
				{	int c =raum.lastIndexOf("@");						
					raum=raum.substring(0,c)+' '+raum.substring(c+1);
					raum=raum.substring(0,yy*20+xx)+'@'+raum.substring(yy*20+xx+1);
					try {
						restartLevel(false,Jay.getImage());
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
				
			}
		}
		if (raum.charAt(yy*20+xx)=='*'){    														// Kollision mit dem Gegner, Neustart des Spiels
			//Game_over();
			failed=true;
			try {
				restartLevel(true,Jay.getImage());
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
		

		if (raum.charAt(yy*20+xx)=='~'){    														//startet bei Kollision den Dialog des NPC
			Dialogue();
		}
		
	/*	if (raum.charAt(yy*20+xx)=='s'){    														//startet bei Kollision den Dialog des Ladenbesitzers
			DialogueShop();
		}*/

		else if (raum.charAt(yy*20+xx)=='$'){														//startet die naechste Welt wenn ein Schluessel aufgenommen wurde
			if (lr.charAt(1)=='1') lr="l2r1";

			else if (lr.charAt(1)=='2')lr="l3r1"; 
			else if (lr.charAt(1)=='3')lr="l4r1";
			loeschen(true);
			try {
				initWorld(Jay.getImage());
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		
		else if (raum.charAt(yy*20+xx)=='b'){														//speichert Status des Raumes mit Muenzen, Gegner und Position
			xruban=xruban+ruban;
			System.out.print("xruban = ");
			System.out.println(xruban);
			ruban=0;
			System.out.print("ruban = ");
			System.out.println(ruban);
			posX=Jay.getX();
			posY=Jay.getY();
			rooms=raum;
			lrs=lr;
		}


	}


	public Image getImage(){																		//laedt Images
		return image;

	}
	
	public String raumeinlesen() throws IOException{
		String room="";
		FileReader fr = new FileReader("src/Resources/"+lr+".txt");
		    BufferedReader br = new BufferedReader(fr);
		    String zeile = br.readLine();
		    while (zeile != null)
		    {
		      room=room+zeile+'\n';
		      zeile = br.readLine();
		    }
		br.close();
		return room;
	}



	public final void initWorld(Image image42) throws IOException{										// zeichnet das Level mit Walls, Character, dem Schluessel und Gegner.
		
		ImageIcon ii= new ImageIcon ("src/Resources/back"+lr.charAt(1)+".png");						// Den Pfad fuers Hintergrundbild angeben.
		img=ii.getImage();		//Image importieren.	
		setBackground(Color.BLACK);																	// dunkler Hintergrund fuer den Kontrast der Schuesse
		if (raum=="") raum=raumeinlesen();
		int x = 0;
		int y = 0;
		Wall wall;
		Coin coin;
		Enemy enemy;
		Key key;
		Wizard wizard;
		//Shopkeeper shopkeeper;


		for(int i = 0; i < raum.length(); i++){	

			char obj = raum.charAt(i);										

			if(obj == '\n'){																		//y erhoeht sich um ein BLOCK wenn man ein /n im String Level findet.
				y = y + BLOCK;
				x = 0;
			}else if(obj == '#'){																	// # bezeichnet ein Stueck Mauer. eine Mauer im array walls an seine Position speichern.
				wall = new Wall(x,y, "wand"+ lr.charAt(1));
				walls.add(wall);
				x = x + BLOCK;
			}else if(obj == '@'){																	// Legt die Position des Charakters beim Levelstart fest
				if (lr!="l3r4"){
					if (failed==false)Jay = new Character(x,y);
					else if (failed){
						if (lr==lrs) Jay=new Character(posX,posY);
						else Jay = new Character(x,y);
						failed=false;
					}

					if (image==image1){
						image =	r.getImage();																		//Image vom Spieler der nach rechts laeuft
						Jay.setImage(image);}
					if (image==image2){
						image =	l.getImage();																		//Image vom Spieler der nach rechts laeuft
						Jay.setImage(image);}
					if (image==image3){
						image =	t.getImage();																		//Image vom Spieler der nach rechts laeuft
						Jay.setImage(image);}
					if (image==image4){
						image =	b.getImage();}																		//Image vom Spieler der nach rechts laeuft
						
				
					x = x + BLOCK;}
			}
				else if(obj == ' '){																	//x erhoeht sich um einen Block(' ':Bereich wo sich der Spieler bewegen kann)
					x = x + BLOCK;
				}
				else if(obj == '*'){                													// stellt den Enemy in den Levels als * dar
					enemy = new Enemy(x,y);
					enemys.add(enemy);
					x = x + BLOCK;
					}
				else if(obj == '$'){                													// stellt den Schluessel in den Levels als $ dar
					key = new Key(x,y);	
					keys.add(key);
					x = x + BLOCK;
				}
				else if (obj=='a'){
					coin=new Coin(x,y);
					coins.add(coin);
					x=x+BLOCK;
				}
				else if(obj == '~'){																	//stellt den NPC in den Levels als ein ~ dar
					wizard = new Wizard(x,y);
					wizards.add(wizard);
					x = x + BLOCK;
				}
				/*else if(obj == 's'){																	//stellt den Ladenbesitzer in den Levels als ein s dar
					shopkeeper = new Shopkeeper(x,y);
					shopkeepers.add(shopkeeper);
					x = x + BLOCK;
				}*/
				else if(obj == 'b'){																	// Legt die Position des Charakters beim Tod fest
					check = new checkpoint(x,y);
					x=x+BLOCK;
				}
		}
		}

	public void buildWorld(Graphics g){

		g.drawImage(img, 0, 0, null);																//Background Image zeichnen
		ArrayList<Movement> world = new ArrayList<Movement>();

		//world.addAll(walls);																		//Alle Objekte in einem Array world speichern
		world.add(check);																			//im levelend soll es kein Spielfigur geben
		world.add(Jay);
		//world.addAll(enemys);																		// nur zeichnen wenn Enemy nicht schon tot ist 
		world.addAll(keys);
		world.addAll(wizards);
		world.addAll(coins);
		world.addAll(shopkeepers);
		//world.addAll(coins);

		for(int i = 0; i < world.size(); i++){														// Array world durchgehen um objekte zu zeichnen.
			
			Movement obj = (Movement) world.get(i);
			g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);								// g.drawImage fuer die Grafische Zeichnung
		}
		
	       ArrayList<Shot> shots = getShots();
	       		for (int j = 0; j < shots.size(); j++) {
                
	       			Shot m = (Shot) shots.get(j);
	       			g.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
	       		
	       			for (int i = 0; i < enemys.size(); i++) {										// Enemy soll nur gezeichnet werden, wenne es noch nicht tot ist 
	       				
	       				Enemy e = (Enemy) enemys.get(i);
	       				if (e.isVisible())
	       				g.drawImage(e.getImage(), e.getX(), e.getY(), this);
	       			}

	       			for (int i = 0; i < walls.size(); i++) {										//  NICHT LOESCHEN FUER DAS TESTEN DER WAENDE 
	       				
	       				Wall w = (Wall) walls.get(i);
	       				if (w.isVisible())
	       				g.drawImage(w.getImage(), w.getX(), w.getY(), this);
	       			}
	       			for (int i = 0; i < coins.size(); i++) {										// Muenzen sollen gezeichnet werden bei Tod
	       				
	       				Coin c = (Coin) coins.get(i);
	       				if (c.isVisible())
	       				g.drawImage(c.getImage(), c.getX(), c.getY(), this);
	       			}
}
    
        public void paint(Graphics g){
		super.paint(g);
	
		if(ingame){																					// falls Spiel nicht verloren
			buildWorld(g);																			// zeichnet Welt mit Punktestand..
	        String msg = "Money: "+ (ruban+xruban);
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (200 - metr.stringWidth(msg)) / 2,
                     50 / 2);
            }else{																					// was bei Niederlage passieren soll..
            	 }
        }
	
	public ArrayList<Shot> getShots() {																// gibt die Schuesse der Positionen wieder
	        return shots;
	    }

	private class Ap extends KeyAdapter{															// fuer rechts: holt das Bild mit Position rechts
																									// durch die class Character bewegt sich Diggy in die entsprechende Richtung
		public  void keyPressed(KeyEvent e){

			int key = e.getKeyCode();

			if(key == KeyEvent.VK_RIGHT){		

				Image image1 = image = r.getImage();																		//Image vom Spieler der nach rechts laeuft

				Jay.setImage(image);
				position = 1;
				collision(BLOCK,0, image1);
			}

			else if(key == KeyEvent.VK_LEFT){

				Image image2 = image = l.getImage();

				Jay.setImage(image);
				position = 2;
				collision(-BLOCK,0, image2);
			}


			else if(key == KeyEvent.VK_UP){

				Image image3= image = t.getImage() ;

				Jay.setImage(image);
				position = 3;
				collision(0,-BLOCK,image3);
			}
			
			else if(key == KeyEvent.VK_DOWN){

				Image image4 = image = b.getImage();

				Jay.setImage(image);
				position = 4;
				collision(0,BLOCK, image4);
			}
			else if (key == KeyEvent.VK_SPACE) {													// Taste -Space ruft die Funktion fire auf
	            fire();
	            
	        }


			repaint();
			

			if ((Jay.getY()==-BLOCK)||(Jay.getY()==0))  {	
				if (lr.charAt(3)=='1') lr=lr.substring(0,3)+"2";									//Wenn der Spieler am Ausgang des 1. Raums ist dann ueberwechseln
				else if (lr.charAt(3)=='2') lr=lr.substring(0,3)+'3';								//Wenn der Spieler am Ausgang des 2. Raums ist dann ueberwechseln
				else if (lr.charAt(3)=='3') lr=lr.substring(0,3)+'4';								//Wenn der Spieler am Ausgang des 3. Raums ist dann ueberwechseln
				else if (lr.charAt(3)=='4') lr=lr.substring(0,3)+'5';								//Wenn der Spieler am Ausgang des 4. Raums ist dann ueberwechseln
				xruban=xruban+ruban;
				System.out.print("xruban = ");
				System.out.println(xruban);
				ruban=0;
				System.out.print("ruban = ");
				System.out.println(ruban);
				loeschen(true);
				try {
					initWorld(Jay.getImage());
				} catch (IOException e1) {
					e1.printStackTrace();
				}																					//world initialisieren 

			}
			if (Jay.getX() ==950 ){																	//Bedingung erfuellt nur am Ausgang des 2. Raums
				if (lr.charAt(3)=='1') lr=lr.substring(0,3)+"2";									//Wenn der Spieler am Ausgang des 1. Raums ist dann ueberwechseln
				else if (lr.charAt(3)=='2') lr=lr.substring(0,3)+'3';								//Wenn der Spieler am Ausgang des 2. Raums ist dann ueberwechseln
				else if (lr.charAt(3)=='3') lr=lr.substring(0,3)+'4';								//Wenn der Spieler am Ausgang des 3. Raums ist dann ueberwechseln
				else if (lr.charAt(3)=='4') lr=lr.substring(0,3)+'5';								//Wenn der Spieler am Ausgang des 4. Raums ist dann ueberwechseln
				xruban=xruban+ruban;
				System.out.print("xruban = ");
				System.out.println(xruban);
				System.out.print("ruban = ");
				System.out.println(ruban);
				ruban=0;
				System.out.print("ruban = ");
				System.out.println(ruban);
				loeschen(true);
				try {
					initWorld(Jay.getImage());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}

			
	}
	public void restartLevel(boolean test,Image image2) throws IOException {			
		if (lr.length()==5){
			if (lr.charAt(3)=='2') lr=lr.substring(0, 3)+'1';
			else if (lr.charAt(3)=='3') lr=lr.substring(0, 3)+'2';
		}
		loeschen(test);
		initWorld(Jay.getImage());
		
	}
																					
	 public void fire() {
		 	if(position==1){
		 		shots.add(new Shot(Jay.getX() + BLOCK, Jay.getY()));								// Posistion der Schussrichtung, je in welche Richtung Diggy guckt
		 		k = 00;
		 	}
		 	if(position==2){																		// der Schuss soll nicht ueber Diggy gehen 
		 		shots.add(new Shot(Jay.getX() - BLOCK, Jay.getY()));								// k als Flag
		 		k = 01;
		 	}
		
		 	if(position==3){
		 		shots.add(new Shot(Jay.getX(), Jay.getY() - BLOCK));
		 		k = 10;
		 	}
		
		 	if(position==4){
		 		shots.add(new Shot(Jay.getX(), Jay.getY() + BLOCK));	
		 	    k = 11;
		 	}
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {													// zeichnet die Schuesse 
	       
		 ArrayList<Shot> shots = getShots();										
			
		 	for (int i = 0; i < shots.size(); i++) {
		 		Shot m = (Shot) shots.get(i);
		 	
		 		if(m.isVisible()){	 																// falss limit des Boards nicht ueberschritten
		 																							// wird je nach Blickrichtung in die richtgige
		 																							// Richtung geschossen
		 		if(k==00) m.move_r();
		 		if(k==01) m.move_l();
		 		if(k==10) m.move_u();
		 		if(k==11) m.move_d();
		 		 
		 			}else shots.remove(i);
		 		
		 		check_coll_wall();																	// Kollisionabfrage mit Schuss
		 		check_coll_enemy();
		 		check_coll_coin();
		 		
		 	repaint();																				// alle 5 ms werden die Schuss-Bewegungen gezeichnet
		 }
	 }
	 
		public Rectangle getBounds(){
			return new Rectangle(Jay.getX(),Jay.getY(),50,50);				
		}

		
		
		public void Dialogue(){																		//definiert die Methode Dialogue genauer, mit Close-Operation, Name, Layout und Position
			
			JFrame Dialogue = new Dialogue("Weiser Zauberer");
			
			Dialogue.setSize(600,300);
			Dialogue.setLocationRelativeTo(null);
			Dialogue.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			Dialogue.setVisible(true);
			Dialogue.setFocusable(true);
			Dialogue.setLayout(new BorderLayout());
			Dialogue.setLayout(null);
			Dialogue.add(new Dialogue("Weiser Zauberer"));
		}
		
	/*	public void DialogueShop(){																	//definiert die Methode DialogueShop genauer, mit Close-Operation, Name, Layout und Position
			
			JFrame DialogueShop = new DialogueShop("Ladenbesitzer");
			
			DialogueShop.setSize(600,300);
			DialogueShop.setLocationRelativeTo(null);
			DialogueShop.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			DialogueShop.setVisible(true);
			DialogueShop.setFocusable(true);
			DialogueShop.setLayout(new BorderLayout());
			DialogueShop.setLayout(null);
			DialogueShop.add(new Dialogue("Ladenbesitzer"));
		}*/




		public void check_coll_coin() {																// schiesst nicht durch Coins


			ArrayList<Shot> shots = getShots();

			    for (int i = 0; i < shots.size(); i++) {
			        Shot m = (Shot) shots.get(i);
			        
			        Rectangle r1 = m.getBounds();
			        
			        for (int j = 0; j < coins.size(); j++) {
				        Coin c = (Coin) coins.get(j);
				        Rectangle r2 = c.getBounds();

			            if (r1.intersects(r2)) {
			                m.setVisible(false);
			                c.setVisible(true);
			            }
			        }
			    }
			}
	
		public void check_coll_wall() {																// Wandkollision

			ArrayList<Shot> shots = getShots();

		    for (int i = 0; i < shots.size(); i++) {
		        Shot m = (Shot) shots.get(i);
		        
		        Rectangle r1 = m.getBounds();
		        
		        for (int j = 0; j < walls.size(); j++) {
			        Wall w = (Wall) walls.get(j);
			        Rectangle r2 = w.getBounds();

		            if (r1.intersects(r2)) {
		                m.setVisible(false);
		                w.setVisible(true);
		       
		             }
		        }
		    }
		}
		public void check_coll_enemy() {								


			ArrayList<Shot> shots = getShots();


		    for (int i = 0; i < shots.size(); i++) {
		        Shot m = (Shot) shots.get(i);


		        Rectangle r1 = m.getBounds();


		        for (int j = 0; j<enemys.size(); j++) {
		            Enemy e = (Enemy) enemys.get(j);
		            Rectangle r2 = e.getBounds();
		            int xx = (int) ((r1.getX())/BLOCK);																	//xx und yy sind die imaginaere Koordinaten innerhalb des Strings Variable (level).
	        		int yy=(int)(r1.getY())/BLOCK;


		            if (raum.charAt(yy*20+xx)=='*') {
		                m.setVisible(false);						
		        		int xxx = ((Jay.getX())/BLOCK);																	//xx und yy sind die imaginaere Koordinaten innerhalb des Strings Variable (level).
		        		int yyy=(Jay.getY())/BLOCK;	
		        		raum=raum.substring(0,yy*20+xx)+' '+raum.substring(yy*20+xx+1);	
		        				int c =raum.lastIndexOf("@");						
		    					raum=raum.substring(0,c)+' '+raum.substring(c+1);
		    					raum=raum.substring(0,yyy*20+xxx)+'@'+raum.substring(yyy*20+xxx+1);
		    					try {
		    						restartLevel(false, (Jay.getImage()));
		    					} catch (IOException e1) {


		    						e1.printStackTrace();
		    				}
		            }
		        }
		    }
		}

	
public void Game_over(){
	 
	JFrame Game_over = new JFrame();
	 
	 Game_over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 Game_over.setSize(500,500);
	 Game_over.setVisible(true);
	 Game_over.setFocusable(true);
	 Game_over.setLocationRelativeTo(null);   																			// Fenster in der MItte 
	 Game_over.add(new Game_over());
	}
}
 
