package newgame;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Board extends JPanel{

Image image;
Image img;

	ImageIcon r = new ImageIcon("src/Resources/r1.png");				// fuer versch. Positionen rechts,links,oben,unten
	ImageIcon l = new ImageIcon("src/Resources/l1.png");
	ImageIcon t = new ImageIcon("src/Resources/Character top.png");
	ImageIcon b = new ImageIcon("src/Resources/Character.png");

	private int BLOCK = 50;								// 50* 50 Pixel

	java.util.List<Movement> enemys = new java.util.ArrayList<Movement>();
	java.util.List<Movement> walls = new java.util.ArrayList<Movement>();		// Array fuer die Waende
	java.util.List<Movement> gegners = new java.util.ArrayList<Movement>();
	java.util.List<Movement> keys = new java.util.ArrayList<Movement>();
	private Character Jay;
	private int w = 0;
	private int h = 0;


	private String level1 = "########### #######\n"									//Level 11 ist dafür da, wenn man von Level 2 umkehrt. Unterschied zu level1: Spieler liegt am Ausgang des Raums.
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

	private String level11 ="###########@#######\n"									//Level 11 ist dafür da, wenn man von Level 2 umkehrt. Unterschied zu level1: Spieler liegt am Ausgang des Raums.
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


	private String level2 = "###################\n"									//Level 11 ist dafür da, wenn man von Level 2 umkehrt. Unterschied zu level1: Spieler liegt am Ausgang des Raums.
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

	private String level22= "###################\n"									//Level 11 ist dafür da, wenn man von Level 2 umkehrt. Unterschied zu level1: Spieler liegt am Ausgang des Raums.
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

	private String level3 =	"###################\n"
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

	private String level=level1;

	public Board(){

		addKeyListener(new Ap());
		setFocusable(true);
		ImageIcon i= new ImageIcon ("src/Resources/back1.png");		//Background image vom Raum (Die Wege)
		img=i.getImage();
		initWorld();
	}


	public Image getImage(){
		return image;

	}

	public final void initWorld(){						// zeichnet das level mit walls, character und gegner.

		int x = 0;
		int y = 0;
		Wall wall;
		Enemy enemy;
		Key key;

		for(int i = 0; i < level.length(); i++){

			char obj = level.charAt(i);										

			if(obj == '\n'){
				y = y + BLOCK;
				x = 0;
			}else if(obj == '#'){
				wall = new Wall(x,y);
				walls.add(wall);
				x = x + BLOCK;
			}else if(obj == '@'){						// wo character sich beim Start befinden soll beim starten der Level
				if (level!=levelend)
					{Jay = new Character(x,y);
				x = x + BLOCK;}
			}
			else if(obj == ' '){
				x = x + BLOCK;}

			else if(obj == '*'){                // stellt den Enemy in den Levels als * dar
				enemy = new Enemy(x,y);
				enemys.add(enemy);
				x = x + BLOCK;
				}
			else if(obj == '$'){                // stellt den Enemy in den Levels als * dar
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


		for(int i = 0; i < world.size(); i++){						// g.drawImage für die Grafsische Zeichnung
			Movement obj = (Movement) world.get(i);
			g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);

		}

	}

	public void paint(Graphics g){
		super.paint(g);
		buildWorld(g);
	}

	private class Ap extends KeyAdapter{					// fuer rechts: holt das Bild mit Position rechts
										// durch die class Charackter bewegt sich Jay ein Block nach rechts..
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
				if (level.charAt(yy*20+xx)=='*'){     //Kollision mit dem Gegner
					restartLevel();
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
					restartLevel();
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
					restartLevel();
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
					restartLevel();
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
			System.out.println(Jay.getX());
			System.out.println(Jay.getY());

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

		private void restartLevel() {
			level=level1;
			walls.clear();
			enemys.clear();
			keys.clear();
			initWorld();
			
		}

	}

}