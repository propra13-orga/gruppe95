package newgame;




import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;




public class Board extends JPanel implements ActionListener{

	Image image;
	Image img;											//Bild fuer den Hintergrund (WEG)
	private Character Jay;
	private String raum;
	private String lr,w,h; 								//lr fuer der Name der raumdatei, w:wandbild , h:hintergrundsbild
	private ArrayList<Shot> shots;						//Array fuer die Zeichnung der Schuesse
	private Timer timer;
	private int BLOCK = 50;								// 50* 50 Pixel


	ImageIcon r = new ImageIcon("src/Resources/r1.png");						// fuer versch. Positionen rechts, links, oben, unten
	ImageIcon l = new ImageIcon("src/Resources/l1.png");
	ImageIcon t = new ImageIcon("src/Resources/Character top.png");
	ImageIcon b = new ImageIcon("src/Resources/Character.png");

	java.util.List<Movement> enemys = new java.util.ArrayList<Movement>();
	java.util.List<Movement> walls = new java.util.ArrayList<Movement>();		// Array fuer die Waende..
	java.util.List<Movement> keys = new java.util.ArrayList<Movement>();
	
	
	public Board() throws IOException{
		lr="l1r1";
		addKeyListener(new Ap());
		setFocusable(true);		
		initWorld();
	    shots = new ArrayList<Shot>();
		timer = new Timer(5, this);												//zeichnet alle  5ms den Board (Schuesse)
        timer.start();
	}


	public Image getImage(){
		return image;

	}

	public final void initWorld() throws IOException{											// zeichnet das Level mit Walls, Character, dem Schluessel und Gegner.
		ImageIcon ii= new ImageIcon ("src/Resources/back"+lr.charAt(1)+".png");					// Den Pfad fuers Hintergrundbild angeben.
		img=ii.getImage();		//Image importieren.		
		
		raum="";
		 FileReader fr = new FileReader("src/Resources/"+lr+".txt");
		    BufferedReader br = new BufferedReader(fr);
		    String zeile = br.readLine();
		    while (zeile != null)
		    {
		      raum=raum+zeile+'\n';
		      zeile = br.readLine();
		    }
		  br.close();

		int x = 0;
		int y = 0;
		Wall wall;
		Enemy enemy;
		Key key;

		for(int i = 0; i < raum.length(); i++){									// level variable Buchstabe fuer Buchstabe durchgehen.

			char obj = raum.charAt(i);										

			if(obj == '\n'){													//y erhoeht sich um ein BLOCK wenn man ein /n im String Level findet.
				y = y + BLOCK;
				x = 0;
			}else if(obj == '#'){												// # bezeichnet ein Stueck Mauer. eine Mauer im array walls an seine Position speichern.
				wall = new Wall(x,y, "wand"+ lr.charAt(1));
				walls.add(wall);
				x = x + BLOCK;
			}else if(obj == '@'){												// Legt die Position des Charakters beim Levelstart fest
				if (lr!="l3r4"){
				Jay = new Character(x,y);
				x = x + BLOCK;}
			}
			else if(obj == ' '){												//x erhoeht sich um einen Block(' ':Bereich wo sich der Spieler bewegen kann)
				x = x + BLOCK;
			}
			else if(obj == '*'){                								// stellt den Enemy in den Levels als * dar
				enemy = new Enemy(x,y);
				enemys.add(enemy);
				x = x + BLOCK;
				}
			else if(obj == '$'){                								// stellt den Schluessel in den Levels als $ dar
				key = new Key(x,y);	
				keys.add(key);
				x = x + BLOCK;
			}


		}
	}

	public void buildWorld(Graphics g){

		g.drawImage(img, 0, 0, null);											//Background Image zeichnen

		ArrayList<Movement> world = new ArrayList<Movement>();

		world.addAll(walls);													//Alle Objekte in einem Array world speichern													//im levelend soll es kein Spielfigur geben
		world.add(Jay);
		world.addAll(enemys);
		world.addAll(keys);


		for(int i = 0; i < world.size(); i++){									// Array world durchgehen um objekte zu zeichnen.
			Movement obj = (Movement) world.get(i);
			g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);			// g.drawImage fuer die Grafische Zeichnung

		}

	}

	public void paint(Graphics g){
		super.paint(g);
		buildWorld(g);
		  ArrayList shots = getShots();											// fuer die grafische Zeichnung der Schuesse

	        for (int i = 0; i < shots.size(); i++ ) {
	            Shot m = (Shot) shots.get(i);
	            g.drawImage(m.getImage(), m.getX(), m.getY(), this);
	        }
	}
	
	 public ArrayList getShots() {												// gibt die Schuesse der Positionen wieder
	        return shots;
	    }

	private class Ap extends KeyAdapter{										// fuer rechts: holt das Bild mit Position rechts
																				// durch die class Character bewegt sich Diggy in die entsprechende Richtung
		public  void keyPressed(KeyEvent e){

			int key = e.getKeyCode();
			int xx;
			int yy;

			if(key == KeyEvent.VK_RIGHT){		

				image = r.getImage();											//Image vom Spieler der nach rechts laeuft
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK)+1;										//xx und yy sind die imaginaere Koordinaten innerhalb des Strings Variable (level).
				yy=Jay.getY()/BLOCK;											//xx und yy werden dafuer gerechnet um zu erkennen, ob an der Stelle wohin sich die Spielfigur bewegen will, kein # im variable level bzw kein Stueck Mauer im Spielfeld gibt
				if ((raum.charAt(yy*20+xx)!='#')||(xx*yy<0))					//yy wird mal 20 multipliziert da es in jeder linie des Spielfelds 20 Bloecke gibt(also in jeder linie des strings level gibt es 20 zeichen)
				{																//Wandkollision:
					Jay.move(BLOCK,0);											//erst wenn es kein Stueck Mauer oder einen Ein-Ausgang gibt(entweder xx oder yy <0 ist) darf/kann sich die Spielfigur bewegen
				}
				if (raum.charAt(yy*20+xx)=='*'){    							// Kollision mit dem Gegner, Neustart des Spiels
					//Game_over();
					try {
						restartLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				if (raum.charAt(yy*20+xx)=='$')									//schluessel gefunden!
				{	if (lr.charAt(1)=='1') lr="l2r1";
					else if (lr.charAt(1)=='2')lr="l3r1"; 
					else if (lr.charAt(1)=='3')lr="l4r1";
					walls.clear();
					enemys.clear();
					keys.clear();
					try {
						initWorld();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}


			}

			else if(key == KeyEvent.VK_LEFT){
				image = l.getImage();
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK)-1;
				yy=Jay.getY()/BLOCK;
				if ((raum.charAt(yy*20+xx)!='#')||(xx*yy<0))
				{
				Jay.move(-BLOCK,0);
				}
				if (raum.charAt(yy*20+xx)=='*')
				{
					//Game_over();
					try {
						restartLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (raum.charAt(yy*20+xx)=='$')
				{
					if (lr.charAt(1)=='1') lr="l2r1";
					else if (lr.charAt(1)=='2')lr="l3r1";
					else if (lr.charAt(1)=='3')lr="l4r1";
					walls.clear();
					enemys.clear();
					keys.clear();
					try {
						initWorld();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}


			else if(key == KeyEvent.VK_UP){


				image = t.getImage();
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK);
				yy=Jay.getY()/BLOCK -1;

				if (raum.charAt(yy*20+xx)!='#')
				{
				Jay.move(0, -BLOCK);
				}
				if (Jay.getY()==0){
					Jay.move(0, -BLOCK);
				}
				if (raum.charAt(yy*20+xx)=='*')
				{
					//Game_over();
					try {
						restartLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (raum.charAt(yy*20+xx)=='$')
				{
					if (lr.charAt(1)=='1') lr="l2r1";
					else if (lr.charAt(1)=='2')lr="l3r1";
					else if (lr.charAt(1)=='3')lr="l4r1";
					walls.clear();
					enemys.clear();
					keys.clear();
					try {
						initWorld();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
			else if (key == KeyEvent.VK_SPACE) {							// Taste -Space ruft die Funktion fire auf
	            fire();
	        }

			else if(key == KeyEvent.VK_DOWN){
				image = b.getImage();
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK);
				yy=Jay.getY()/BLOCK + 1;
				if ((raum.charAt(yy*20+xx)!='#')||(xx*yy<0))
				{
				Jay.move(0, BLOCK);
				}
				if (raum.charAt(yy*20+xx)=='*')
				{
					//Game_over();
					try {
						restartLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (raum.charAt(yy*20+xx)=='$')
				{
					if (lr.charAt(1)=='1') lr="l2r1";
					else if (lr.charAt(1)=='2')lr="l3r1";
					else if (lr.charAt(1)=='3')lr="l3r4";
					walls.clear();
					enemys.clear();
					keys.clear();
					try {
						initWorld();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}


			repaint();
			

			if (Jay.getY()==-BLOCK)  {										//Wenn der Spieler am Ausgang des 1. Raums ist dann 
				if (lr.length()==4){
				if (lr.charAt(3)=='1') lr=lr.substring(0,3)+"2";
				else if (lr.charAt(3)=='2') lr=lr.substring(0,3)+'3';
				}
				else lr=lr.substring(0,4);
				walls.clear();												//alle Waende, Keys und Gegners des vorherigen level loeschen (arrays wieder initialisieren)
				enemys.clear();
				keys.clear();
				try {
					initWorld();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}															//world initialisieren 

			}
			if (Jay.getX() ==950 ){											//Bedingung erfuellt nur am Ausgang des 2. Raums
				if (lr.length()==4){
					if (lr.charAt(3)=='1') lr=lr.substring(0,3)+"2";
					else if (lr.charAt(3)=='2') lr=lr.substring(0,3)+'3';
				}
				else lr=lr.substring(0,4);
				walls.clear();
				enemys.clear();
				keys.clear();
				try {
					initWorld();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Jay.getX() == -BLOCK){												//wenn x=-BLOCK ist, befindet sich der Spieler am eingang von Raum 2 oder 3														//und wenn er dadurch geht dann kehrt er zu einem vorherigen Raum (Raum3-->Raum2 oder Raum2-->Raum1) zur�ck
				if (lr.charAt(3)!='1') lr=lr+'a';	
				walls.clear();														//Den Raum wieder initialisieren (alle Objekte loeschen)
				enemys.clear();
				keys.clear();
				try {
					initWorld();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

			

		private void restartLevel() throws IOException {			
			if (lr.length()==5){
				if (lr.charAt(3)=='2') lr=lr.substring(0, 3)+'1';
				else if (lr.charAt(3)=='3') lr=lr.substring(0, 3)+'2';
			}
			walls.clear();
			enemys.clear();
			keys.clear();
			initWorld();
			
		}
	}
																					
		 public void fire() {
		        shots.add(new Shot(Jay.getX() + BLOCK, Jay.getY() ));			// setzt die Entfernung des Schusses vom Character fest
		    }
		
	
		 @Override
		 public void actionPerformed(ActionEvent e) {							// zeichnet die Schuesse bis w = 950,dann remove
			 ArrayList shots = getShots();										// mit Geschwindigkeit 10 (Shot classe)

			 	for (int i = 0; i < shots.size(); i++) {
			 		Shot m = (Shot) shots.get(i);
			 		if (m.getVisible()) 
	                m.move();
			 		else shots.remove(i);										
			 	}
			 	repaint();														// alle 5 ms werden die Schuss-Bewegungen gezeichnet
		// TODO Auto-generated method stub
		
	}
}


/**public void Game_over(){
	 

		
	 JFrame Game_over = new JFrame();
	 
	 
	 Game_over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 Game_over.setSize(500,500);
	 Game_over.setVisible(true);
	 Game_over.setFocusable(true);
	 Game_over.setLocationRelativeTo(null);   // Fenster in der MItte 
	 Game_over.add(new Game_over());
	

			
		}
*/
