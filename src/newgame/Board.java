package newgame;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Board extends JPanel{

Image image;
Image img;		//Bild fuer den Hintergrund (WEG)

	ImageIcon r = new ImageIcon("src/Resources/r1.png");									// fuer versch. Positionen rechts, links, oben, unten
	ImageIcon l = new ImageIcon("src/Resources/l1.png");
	ImageIcon t = new ImageIcon("src/Resources/Character top.png");
	ImageIcon b = new ImageIcon("src/Resources/Character.png");

	private int BLOCK = 50;								// 50* 50 Pixel

	java.util.List<Movement> enemys = new java.util.ArrayList<Movement>();
	java.util.List<Movement> walls = new java.util.ArrayList<Movement>();					// Array fuer die Waende
	java.util.List<Movement> keys = new java.util.ArrayList<Movement>();
	
	private Character Jay;

	


	private String level1 = "########### #######\n"				//Level1 : der 1. Raum veranstalten. #:wand, @:Spielfigur , *:Gegner
		 	+	"#         #       #\n"
			+	"# ## ####  ###### #\n"
			+	"# ## #   #        #\n"
			+	"# ##*# # ##########\n"
			+	"# ## # # ##########\n"
			+	"#                 #\n"
			+	"### ###############\n"
			+	"### ########    ###\n"
			+	"###          ##   #\n"
			+	"################# #\n"			
			+	"#              ## #\n"
			+	"@   ##########    #\n"
			+	"###################\n";

	private String level11 ="###########@#######\n"				//Level 11 ist dafuer da, wenn man von Level 2 zu Level 1 umkehrt. Unterschied zu level1: Spieler liegt am Ausgang des Raums.
		 	+	"#         #       #\n"
			+	"# ## ####  ###### #\n"
			+	"# ## #   #        #\n"
			+	"# ##*# # ##########\n"
			+	"# ## # # ##########\n"
			+	"#                 #\n"
			+	"### ###############\n"
			+	"### ########    ###\n"
			+	"###          ##   #\n"
			+	"################# #\n"			
			+	"#              ## #\n"
			+	"    ##########    #\n"
			+	"###################\n";


	private String level2 = "###################\n"				//Level2 : Raum 2 veranstaltet gemaeß zu Raum 1.
			+	"####        ##    #\n"
			+	"#### ###### ##    #\n"
			+	"#### ######       #\n"
			+	"####    *   ##### #\n"
			+	"##   ### #######  #\n"
			+	"## ##### ####     #\n"
			+	"##           ##  ##\n"
			+	"############ ### ##\n"
			+	"#              #  #\n"
			+	"#  ####  #######  #\n"			
			+	"#  ####  #        #\n"
			+	"@        #  ####   \n"
			+	"###################\n";

	private String level22= "###################\n"				//Gnauso wie Level11 und Level1, oeffnet sich Level22 beim Umkehr vom Level3. Spieler liegt am Ausgang.
			+	"####        ##    #\n"
			+	"#### ###### ##    #\n"
			+	"#### ######       #\n"
			+	"####    *   ##### #\n"
			+	"##   ### #######  #\n"
			+	"## ##### ####     #\n"
			+	"##           ##  ##\n"
			+	"############ ### ##\n"
			+	"#              #  #\n"
			+	"#  ####  #######  #\n"			
			+	"#  ####  #        #\n"
			+	"         #  ####  @\n"
			+	"###################\n";

	private String level3 =	"###################\n"				//Gemaeß zu Raum1 veranstaltet. $: Schluessel.
			+	"####*$*####       #\n"
			+	"#           ##### #\n"
			+	"###########  *    #\n"
			+	"######    #####  ##\n"
			+	"#      ## ##    ###\n"
			+	"#####  ## ## ######\n"
			+	"##        ##      #\n"
			+	"## ############## #\n"
			+	"## ###     #####  #\n"
			+	"## ###  ##  #### ##\n"
			+	"## #### ###  ##  ##\n"
			+	"@       ####      #\n"
			+	"###################\n";
	private String levelend = "###################\n"				
			+	  "#                 #\n"
			+	  "#                 #\n"
			+	  "#                 #\n"
			+  	  "# #### #  # ##    #\n"
			+	  "# #    ## # # #   #\n"
			+	  "# ###  # ## #  #  #\n"
			+	  "# #    #  # # #   #\n"
			+	  "# #### #  # ##    #\n"
			+	  "#                 #\n"
			+	  "#                 #\n"
			+	  "#                 #\n"
			+	  "#                 #\n"
			+	  "###################\n";

	private String level=level1;							//level mit level1 initialisieren, weil level1 als erster geoeffnet wird.

	public Board(){

		addKeyListener(new Ap());
		setFocusable(true);
		ImageIcon i= new ImageIcon ("src/Resources/back1.png");			// Den Pfad fuers Hintergrundbild angeben.
		img=i.getImage();							//Image importieren.
		initWorld();
	}


	public Image getImage(){
		return image;

	}

	public final void initWorld(){							// zeichnet das Level mit Walls, Character, dem Schluessel und Gegner.

		int x = 0;
		int y = 0;
		Wall wall;
		Enemy enemy;
		Key key;

		for(int i = 0; i < level.length(); i++){				// level variable Buchstabe fuer Buchstabe durchgehen.

			char obj = level.charAt(i);										

			if(obj == '\n'){						//y erhoeht sich um ein BLOCK wenn man ein /n im String Level findet.
				y = y + BLOCK;
				x = 0;
			}else if(obj == '#'){						// # bezeichnet ein Stueck Mauer. ein Mauer im array walls an seine Position speichern.
				wall = new Wall(x,y);
				walls.add(wall);
				x = x + BLOCK;
			}else if(obj == '@'){						// Legt die Position des Charakters beim Levelstart fest
				Jay = new Character(x,y);
				x = x + BLOCK;
			}
			else if(obj == ' '){						//x erhoeht sich um einen Block(' ':Bereich wo sich der Spieler bewegen kann)
				x = x + BLOCK;
			}
			else if(obj == '*'){                				// stellt den Enemy in den Levels als * dar
				enemy = new Enemy(x,y);
				enemys.add(enemy);
				x = x + BLOCK;
				}
			else if(obj == '$'){                				// stellt den Schluessel in den Levels als $ dar
				key = new Key(x,y);	
				keys.add(key);
				x = x + BLOCK;
			}


		}
	}

	public void buildWorld(Graphics g){

		g.drawImage(img, 0, 0, null);

		ArrayList<Movement> world = new ArrayList<Movement>();

		world.addAll(walls);
		if (level!=levelend)
			{world.add(Jay);}
		world.addAll(enemys);
		world.addAll(keys);


		for(int i = 0; i < world.size(); i++){					// g.drawImage fuer die Grafische Zeichnung
			Movement obj = (Movement) world.get(i);
			g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);

		}

	}

	public void paint(Graphics g){
		super.paint(g);
		buildWorld(g);
	}

	private class Ap extends KeyAdapter{													// fuer rechts: holt das Bild mit Position rechts
																							// durch die class Character bewegt sich Diggy in die entsprechende Richtung
		public  void keyPressed(KeyEvent e){

			int key = e.getKeyCode();
			int xx;
			int yy;

			if(key == KeyEvent.VK_RIGHT){

				image = r.getImage();
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK)+1;
				yy=Jay.getY()/BLOCK;
				if ((level.charAt(yy*20+xx)!='#')||(xx*yy<0))
				{
					Jay.move(BLOCK,0);
				}
				if (level.charAt(yy*20+xx)=='%'){
					level=levelend;
					walls.clear();
					enemys.clear();
					keys.clear();
					initWorld();
				}
				if (level.charAt(yy*20+xx)=='*'){    // Kollision mit dem Gegner, Neustart des Spiels
					Game_over();
					//restartLevel();
					
				}
				if (level.charAt(yy*20+xx)=='$')
				{
					level=levelend;
					walls.clear();
					enemys.clear();
					keys.clear();
					initWorld();
				}


			}

			else if(key == KeyEvent.VK_LEFT){
				image = l.getImage();
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK)-1;
				yy=Jay.getY()/BLOCK;
				if ((level.charAt(yy*20+xx)!='#')||(xx*yy<0))
				{
				Jay.move(-BLOCK,0);
				}
				if (level.charAt(yy*20+xx)=='*')
				{
					Game_over();
					//restartLevel();
				}
				if (level.charAt(yy*20+xx)=='$')
				{
					level=levelend;
					walls.clear();
					enemys.clear();
					keys.clear();
					initWorld();
				}

			}


			else if(key == KeyEvent.VK_UP){


				image = t.getImage();
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK);
				yy=Jay.getY()/BLOCK -1;

				if (level.charAt(yy*20+xx)!='#')
				{
				Jay.move(0, -BLOCK);
				}
				if (Jay.getY()==0){
					Jay.move(0, -BLOCK);
				}
				if (level.charAt(yy*20+xx)=='*')
				{
					Game_over();
					//restartLevel();
				}
				if (level.charAt(yy*20+xx)=='$')
				{
					level=levelend;
					walls.clear();
					enemys.clear();
					keys.clear();
					initWorld();
				}

			}


			else if(key == KeyEvent.VK_DOWN){
				image = b.getImage();
				Jay.setImage(image);
				xx = (Jay.getX()/BLOCK);
				yy=Jay.getY()/BLOCK + 1;
				if ((level.charAt(yy*20+xx)!='#')||(xx*yy<0))
				{
				Jay.move(0, BLOCK);
				}
				if (level.charAt(yy*20+xx)=='*')
				{
					Game_over();
					//restartLevel();
				}
				if (level.charAt(yy*20+xx)=='$')
				{
					level=levelend;
					walls.clear();
					enemys.clear();
					keys.clear();
					initWorld();
				}

			}

			repaint();
		//	System.out.println(Jay.getX());
		//	System.out.println(Jay.getY());

			if ((Jay.getY()==-BLOCK) & ((level==level1)||(level==level11))) {
				level=level2;
				walls.clear();
				enemys.clear();
				keys.clear();
				initWorld();

			}
			if ((Jay.getX() ==950 )& ((level==level2) || (level==level22))){
				level=level3;
				walls.clear();
				enemys.clear();
				keys.clear();
				initWorld();
			}
			if (Jay.getX() == -BLOCK){
				if (level==level2){
				level=level11;}
				else if (level==level3){
				level=level22;}	
				walls.clear();
				enemys.clear();
				keys.clear();
				initWorld();
			}

		}

		/**private void restartLevel() {			// Durch Game_over ersetzt...zum Start Men�
			level=level1;
			walls.clear();
			enemys.clear();
			keys.clear();
			initWorld();
			
		}*/
		
		 public void Game_over(){
			 

				
			 JFrame Game_over = new JFrame();
			 
			 
			 Game_over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 Game_over.setSize(500,500);
			 Game_over.setVisible(true);
			 Game_over.setFocusable(true);
			 Game_over.setLocationRelativeTo(null);   // Fenster in der MItte 
			 Game_over.add(new Game_over());
			
			
			 

			
				
				

					
				}
		 

	}

}
