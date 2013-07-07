package newgame;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener{


	private static final long serialVersionUID = 1L;
	int a;
	Image image;
	Image img;  																		
	private Character Jay;
	private String raum="";
	private String lr,rooms,lrs; 														
	private ArrayList<Shot> shots;													
	private ArrayList<Sword> swords;
	private ArrayList<Cannon> cannons;
	private Timer timer;
	private int BLOCK = 50;															
	private int position;
	private int ruban=0,xruban;
	private int life=3, xlife;
	private int mana = 3;
	private int use_invisible=3;
	private int k,z,posX,posY;
	boolean ingame,failed,get_sword, get_cannon, get_invisible, armor_ice, armor_fire;
	boolean bought1, bought2, bought3, bought4;
	private checkpoint check;
	private Ghost Geist,geist2;
	private Boss Monster;
	private Boss2 Monster2;
	private Boss3 Monster3;
	private Ball ball;
	private Ice ice;
	private boolean besuch = false;
	Font smallfont = new Font("Helvetica", Font.BOLD, 12);
	
	
	ImageIcon r = new ImageIcon("src/Resources/r1.png");					// Positionen von Diggy					
	ImageIcon l = new ImageIcon("src/Resources/l1.png");
	ImageIcon t = new ImageIcon("src/Resources/Character top.png");
	ImageIcon b = new ImageIcon("src/Resources/Character.png");

	ImageIcon m1 = new ImageIcon("src/Resources/m1.png");					// Mana auf der Anzeige
	ImageIcon m2 = new ImageIcon("src/Resources/m2.png");	
	ImageIcon m3 = new ImageIcon("src/Resources/m3.png");	

	ImageIcon h1 = new ImageIcon("src/Resources/herz.png");					// Objekte fuer die Anzeige
	ImageIcon s = new ImageIcon("src/Resources/schatz.png");
	ImageIcon sw = new ImageIcon("src/Resources/sword.png");
	ImageIcon ca = new ImageIcon("src/Resources/missiler.png");
	ImageIcon sb = new ImageIcon("src/Resources/swordb.png");
	ImageIcon pa = new ImageIcon("src/Resources/pantumime.png");
	
	ImageIcon dr = new ImageIcon("src/Resources/digright.png");				// Positionen fuer Schwertkampf			
	ImageIcon dl = new ImageIcon("src/Resources/digleft.png");
	ImageIcon du = new ImageIcon("src/Resources/digup.png");
	ImageIcon db = new ImageIcon("src/Resources/digb.png");
	
	ImageIcon ir = new ImageIcon("src/Resources/endgegner right.png");		// Positionen mit Eisruestung
	ImageIcon il = new ImageIcon("src/Resources/endgegner left.png");
	ImageIcon it = new ImageIcon("src/Resources/endgegner front.png");
	ImageIcon ib = new ImageIcon("src/Resources/endgegner back.png");
	
	ImageIcon dfr = new ImageIcon("src/Resources/digfireright.png");		// Positionen mit Feuerruestung
	ImageIcon dfl = new ImageIcon("src/Resources/digfireleft.png");
	ImageIcon dff = new ImageIcon("src/Resources/digfirefront.png");
	ImageIcon dfb = new ImageIcon("src/Resources/digfireback.png");
	


	java.util.List<Movement> enemys = new java.util.ArrayList<Movement>();
	java.util.List<Movement> walls = new java.util.ArrayList<Movement>();				
	java.util.List<Movement> keys = new java.util.ArrayList<Movement>();
	java.util.List<Movement> wizards = new java.util.ArrayList<Movement>();
	java.util.List<Movement> coins = new java.util.ArrayList<Movement>();
	java.util.List<Movement> shopkeepers = new java.util.ArrayList<Movement>();
	java.util.List<Movement> Jays = new java.util.ArrayList<Movement>();
	java.util.List<Movement> swordsa = new java.util.ArrayList<Movement>();
	java.util.List<Movement> buyswords = new java.util.ArrayList<Movement>();
	java.util.List<Movement> buycannons = new java.util.ArrayList<Movement>();
	java.util.List<Movement> buyarmorsice = new java.util.ArrayList<Movement>();
	java.util.List<Movement> buyarmorsfire = new java.util.ArrayList<Movement>();
	
	
	Image image1 = image = r.getImage();											
	Image image2 = image = l.getImage();												
	Image image3 = image = t.getImage();	
	Image image4 = image = b.getImage();
	Image image1i = image = ir.getImage();											
	Image image2i = image = il.getImage();												
	Image image3i = image = ib.getImage();	
	Image image4i = image = it.getImage();
	Image image1f = image = dfr.getImage();											
	Image image2f = image = dfl.getImage();												
	Image image3f = image = dff.getImage();	
	Image image4f = image = dfb.getImage();
	Image im1 = image = m1.getImage();
	Image im2 = image = m2.getImage();
	Image im3 = image = m3.getImage();
	Image herz1 = image = h1.getImage();
	Image schatz = image = s.getImage();
	Image image5 = image = dr.getImage();
	Image image6 = image = dl.getImage();
	Image image7 = image = du.getImage();
	Image image8 = image = db.getImage();
	Image swor = image = sw.getImage();
	Image cannon = image = ca.getImage();
	Image pantumime = image = pa.getImage();
	Image invisib = image = sb.getImage();

	
	/* l1r1 steht fuer Level 1, Raum 1
	 * 
	 */
	public Board() throws IOException{

		lr="l1r3";																		
		addKeyListener(new Ap());
		setFocusable(true);
		setDoubleBuffered(true);
		initWorld(image4);															
		ingame = true;
		armor_ice = false;
		armor_fire = false;		
		get_invisible = true;															
	    shots = new ArrayList<Shot>();
		swords = new ArrayList<Sword>();
	    cannons = new ArrayList<Cannon>();
	    timer = new Timer(5, this);														
        timer.start();
    }

	/*
	 * Methode, die die Objekte des Raumes fuer einen neuen Raum loescht
	 * 
	 */
	public void loeschen(boolean b){													
		coins.clear();
		walls.clear();
		enemys.clear();
		keys.clear();
		wizards.clear();
		shopkeepers.clear();
		buycannons.clear();
		buyswords.clear();
		buyarmorsice.clear();
		buyarmorsfire.clear();
		if (b) raum="";
		if (failed) {
			if (lr==lrs){
				raum=rooms;
			}
			ruban = 0;
			life = 3;
			mana = 3;
		}
	}
	
	/*
	 * Methode Kollision uebernimmt die Kollision von Diggy mit den Objekten in den Raeumen
	 * Durch Kollision mit Coin (a) sammelt Diggy Geld.
	 * Durch Kollision mit Enemy (*) verliert Diggy ein von drei Leben. Wenn er kein Leben mehr hat, verliert er das Spiel.
	 * Durch Kollision mit Dialogue (`) gibt der Shopkeeper Auskunft.
	 * Durch Kollision mit Dialogue (s) gibt der Shopkeeper im Shop Auskunft.
	 * Durch Kollision mit Sword (h) kauft Diggy im Shop ein Schwert, das 20 $ kostet.
	 * Durch Kollision mit Cannon (q) kauft Diggy im Shop eine Kannone, das 30 $ kostet.
	 * Durch Kollision mit Buy_Armor_Ice (1) kauft Diggy im Shop eine Eisruestung, das 5 $ kostet.
	 * Durch Kollision mit Buy_Armor_Fire (2) kauft Diggy im Shop eine Feuerruestung, das 5 $ kostet.
	 * Durch Kollision mit Key ($) gelangt Diggy im naechsten Level.
	 * Durch Kollision mit checkpoint (b) gelangt Diggy bei Niederlage wieder im checkpoint statt das Spiel neu zu starten.
	 */

	private static int puzzle_nr = 0;
	public void collision(int movx,int movy,Image image){																				// char pos mit image geaendert um statt mit  t,v Bild festzulegen man abfragt wo er guckt 
		int xx = ((Jay.getX()+movx)/BLOCK);																	 							//xx und yy sind die imaginaere Koordinaten innerhalb des Strings Variable (level).
		int yy=(Jay.getY()+movy)/BLOCK;																									//xx und yy werden dafuer gerechnet um zu erkennen, ob an der Stelle wohin sich die Spielfigur bewegen will, kein # im variable level bzw kein Stueck Mauer im Spielfeld gibt
		if ((raum.charAt(yy*20+xx)!='#')&&(raum.charAt(yy*20+xx)!='~')&&(raum.charAt(yy*20+xx)!='s')&&(xx>=0)||(Jay.getY()<0))		    //yy wird mal 20 multipliziert da es in jeder linie des Spielfelds 20 Bloecke gibt(also in jeder linie des strings level gibt es 20 zeichen)
		{																							        							//Wandkollision
			Jay.move(movx,movy);																		    							//erst wenn es kein Stueck Mauer, keinen NPC/Ladenbesitzer oder einen Ein-Ausgang gibt(entweder xx oder yy <0 ist) darf/kann sich die Spielfigur bewegen
			System.out.println(Jay.getY());
			if ((raum.charAt(yy*20+xx)=='n')&&(ps.visible==true)){
				if (besuch==false)puzzle_nr=puzzle_nr+1;
				System.out.println(puzzle_nr);
				ps.setVisible(false);

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
				try {
					raetsel();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
																	    
			if (raum.charAt(yy*20+xx)=='a'){
				ruban= ruban+1;
				if (raum.contains("@") )
				{	int c =raum.lastIndexOf("@");						
					raum=raum.substring(0,c)+' '+raum.substring(c+1);
					raum=raum.substring(0,yy*20+xx)+'@'+raum.substring(yy*20+xx+1);
					g1x=Geist.getX();
					g2x=geist2.getX();
					g1y=Geist.getY();
					g2y=geist2.getY();
					try {
						restartLevel(false,Jay.getImage());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}else {
			if ((raum.charAt(yy*20+xx)=='#')&&((luecke.visible==false))){
				if ((xx==0)&&(yy==1)){
					Jay.move(movx,movy);
				}
			}
		}

		if (raum.charAt(yy*20+xx)=='*'){    											
			life=life-1;
			if(life==0){
				failed=true;
				try {
					restartLevel(true,Jay.getImage());
					//life=life-1;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else{
				//Game_over();
			}
	   }
		if (raum.charAt(yy*20+xx)=='~'){    														
			Dialogue();
		}
		if (raum.charAt(yy*20+xx)=='s'){    													
			DialogueShop();
		}
		if (raum.charAt(yy*20+xx)=='h'){															
			if((ruban>= 20)||(xruban>=20)){
			get_sword = true;
			xruban = xruban - 20;
			buy_sword();
			bought4 = true;
			}																					
	}else if (raum.charAt(yy*20+xx)=='q'){
			if ((ruban >= 30)||(xruban>=30)){
				get_cannon = true;
				xruban = xruban - 30;
				buy_cannon();
				bought3 = true;
			}
	}else if (raum.charAt(yy*20+xx)=='1'){
		if ((ruban >= 5)||(xruban>=5)){
			xruban = xruban - 5;
			buy_armor_ice_shop();
			armor_ice = true;
			armor_fire = false;
			bought1 = true;     
		}
	}else if (raum.charAt(yy*20+xx)=='2'){	
		if ((ruban >= 5)||(xruban>=5)){
			xruban = xruban - 5;
			buy_armor_fire_shop();
			armor_fire = true;
			armor_ice = false;
			bought2 = true;
		}			
	}else if (raum.charAt(yy*20+xx)=='$'){													
			if (lr.charAt(1)=='1') lr="l2r1";
			else if (lr.charAt(1)=='2')lr="l3r1"; 
			else if (lr.charAt(1)=='3')lr="l3r6";
			loeschen(true);
			try {
				initWorld(Jay.getImage());
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
	/*	else if (raum.charAt(yy*20+xx)=='b'){												
			  xruban=xruban+ruban;															
			  xlife=xlife+life;
			  ruban=0;
			  posX=Jay.getX();
			  posY=Jay.getY();
			  rooms=raum;
			  lrs=lr;
			}*/
		}


	/*
	 * Die Obergegner Boss, Boss2, Boss3 bewegen sich durch diese drei Methoden, die in Richtung Diggy laufen.
	 */
	public void movemonster() {

			if (Jay.getY()<Monster.getY()){
				Monster.move(0,-Monster_speed);
			}
			else if (Jay.getY()>Monster.getY()){
				Monster.move(0,Monster_speed);
			}
			if (Jay.getX()>Monster.getX()){
				Monster.move(Monster_speed,0);
			}
			else if (Jay.getX()<Monster.getX()){
				Monster.move(-Monster_speed,0);
			}
		kollision_boss_spieler();	
	}

	public void movemonster2() {

		if (Jay.getY()<Monster2.getY()){
			Monster2.move(0,-Monster_speed);
		}
		else if (Jay.getY()>Monster2.getY()){
			Monster2.move(0,Monster_speed);
		}
		if (Jay.getX()>Monster2.getX()){
			Monster2.move(Monster_speed,0);
		}
		else if (Jay.getX()<Monster2.getX()){
			Monster2.move(-Monster_speed,0);
		}
		
	}
	public void movemonster3() {

		if (Jay.getY()<Monster3.getY()){
			Monster3.move(0,-Monster_speed);
		}
		else if (Jay.getY()>Monster3.getY()){
			Monster3.move(0,Monster_speed);
		}
		if (Jay.getX()>Monster3.getX()){
			Monster3.move(Monster_speed,0);
		}
		else if (Jay.getX()<Monster3.getX()){
			Monster3.move(-Monster_speed,0);
		}
	}


	public void MoveGeist(Ghost b) {
		if (counter<50)
			b.move(0, -1);
		if ((counter>50)&&(counter<200))b.move(-1, 0);
		if ((counter>200)&&(counter<250))b.move(0, 1);
		if (counter>250)b.move(1, 0);
		if (counter==400)counter=0;
	}
	
	public void movegeist(Ghost b) {
		int xx=b.getX()/50;
		int yy=b.getY()/50;
		 if ((Jay.getX()>b.getX())&&(raum.charAt(yy*20+xx+1)!='#')){
				b.move(Geist_speed,0);
			}
		else if ((Jay.getY()>b.getY())&&(raum.charAt((yy+1)*20+xx)!='#')){
			b.move(0,Geist_speed);
		}
		else if ((Jay.getY()<b.getY())&&(raum.charAt((yy-1)*20+xx)!='#')){
			b.move(0,-Geist_speed);
		}
		else if ((Jay.getX()<b.getX())&&(raum.charAt(yy*20+xx-1)!='#')){
			b.move(-Geist_speed,0);
		}
		else if (raum.charAt((yy-1)*20+xx)!='#') b.move(0,-Geist_speed);
	}

	private int mx,my,counter,Monster_speed,Geist_speed,schuss_speed;
	
	/*
	 * Der erste Obergegner hat keine Schussfunktion. Der zweite Obergegner schiesst mit Eisbällen in richtung Diggy.
	 * Der dritte Obergegner schiesst mit Feuerbaellen in richtung Diggy.
	 */

	public void moveIce2() {
		if (ice.getX()<mx){
			ice.move(schuss_speed, 0);
		}
		else if (ice.getX()>mx){
			ice.move(-schuss_speed, 0);
		}
		if (ice.getY()<my){
			ice.move(0, schuss_speed);
		}
		else if (ice.getY()>my){
			ice.move(0,-schuss_speed);
		}

		kollision_eis_spieler();

		if (counter % 150==0){
			ice.setX(Monster2.getX());
			ice.setY(Monster2.getY());
			mx=0;my=0;
		}
	
	}
	public void moveBall3() {

		if (ball.getX()<mx){
			ball.move(schuss_speed, 0);
		}
		else if (ball.getX()>mx){
			ball.move(-schuss_speed, 0);
		}
		if (ball.getY()<my){
			ball.move(0, schuss_speed);
		}
		else if (ball.getY()>my){
			ball.move(0,-schuss_speed);
		}

		kollision_ball_spieler();

		if (counter % 150==0){
			ball.setX(Monster3.getX());
			ball.setY(Monster3.getY());
			mx=0;my=0;
		}
	}

	/* Bei Kollision mit dem ersten Obergegner verliert Diggy ein Leben.
	 * Wenn Diggy im Kampf mit dem zweiten Obergegner eine Eisruestung traegt, verliert er kein Leben.
	 * Im Kampf mit dem dritten Obergegner verliert Diggy kein Leben wenn er eine Feuerruestung traegt.
	 * Sonst verliert Diggy bei Kollision ein Leben.
	 */
	
	private void kollision_boss_spieler() {
		if ((Math.abs(Jay.getX()-Monster.getX())<50)&&(Math.abs(Jay.getY()-Monster.getY())<50)){
			if(life==1){
				Game_over();
				failed=true;
				try {
					restartLevel(true,Jay.getImage());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else{
				life=life-1;
			}
		}
	}
	
	private void kollision_eis_spieler() {
	if ((Math.abs(Jay.getX()-ice.getX())<50)&&(Math.abs(Jay.getY()-ice.getY())<50)){
		if(life==1){
			Game_over();
			failed=true;
			try {
				restartLevel(true,Jay.getImage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else{
			if(armor_ice!=true) life=life-1;
			if(armor_ice==true) life = life - 0;
		
		}
	 }
	}
	private void kollision_ball_spieler() {
		if ((Math.abs(Jay.getX()-ball.getX())<50)&&(Math.abs(Jay.getY()-ball.getY())<50)){
			if(life==1){
				Game_over();
				failed=true;
				try {
					restartLevel(true,Jay.getImage());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else{
				if(armor_fire!=true) life=life-1;
				if(armor_fire==true) life = life - 0;
			}
		}
	}


	public Image getImage(){																	
		return image;
	}
	
	/*
	 * Methode fuer das lesen der txt Datei
	 */



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

	
	/*
	 *  Die Methode initWorld zeichnet alle Objekte im Spiel
	 */
	
	private PuzzleSt ps;
	public final void initWorld(Image image) throws IOException{						

		setBackground(Color.BLACK);																		
		if (raum=="") raum=raumeinlesen();
		int x = 0;
		int y = 0;
		Wall wall;
		Coin coin;
		Enemy enemy;
		Key key;
		Wizard wizard;
		Shopkeeper shopkeeper;
		Buy1 buy1;
		Buy2 buy2;
		Buy_Armor_Ice bai;
		Buy_Armor_Fire baf;
		

		for(int i = 0; i < raum.length(); i++){																	
			char obj = raum.charAt(i);										
				if(obj == '\n'){																					
					y = y + BLOCK;
					x = 0;
				}else if(obj == '#'){																					
					wall = new Wall(x,y, "wand"+ lr.charAt(1));
					walls.add(wall);
					x = x + BLOCK;
				}else if(obj == '@'){																					
					if (lr!="l3r4"){	
					if (failed==false)Jay = new Character(x,y);
					else if (failed){
						if (lr==lrs) Jay=new Character(posX,posY);
						else Jay = new Character(x,y);
							failed=false;
						}
					if (image==image1){
						image =	r.getImage();																		
						Jay.setImage(image);}															
					if (image==image2){
						image =	l.getImage();
						Jay.setImage(image);}
					if (image==image3){
						image =	t.getImage();
						Jay.setImage(image);}
					if (image==image4){
						image =	b.getImage();
						Jay.setImage(image);}	
					if (image==image5){
						image =	dr.getImage();
						Jay.setImage(image);}	
					if (image==image6){
						image =	dl.getImage();
						Jay.setImage(image);}
					if (image==image7){
						image =	du.getImage();
						Jay.setImage(image);}
					if (image==image8){
						image =	db.getImage();
						Jay.setImage(image);}
					if (image==image1i){
						image =	ir.getImage();
						Jay.setImage(image);}	
					if (image==image2i){
						image =	il.getImage();
						Jay.setImage(image);}
					if (image==image3i){
						image =	ib.getImage();
						Jay.setImage(image);}
					if (image==image4i){
						image =	it.getImage();
						Jay.setImage(image);}
					if (image==image1f){
						image =	dfr.getImage();
						Jay.setImage(image);}	
					if (image==image2f){
						image =	dfl.getImage();
						Jay.setImage(image);}
					if (image==image3f){
						image =	dfb.getImage();
						Jay.setImage(image);}
					if (image==image4f){
						image = dfb.getImage();
						Jay.setImage(image);}
					}
					x = x + BLOCK;
					
			}else if(obj == 'n'){	
				ps= new PuzzleSt(x,y);
				x = x + BLOCK;
			}else if(obj == ' '){																
				x = x + BLOCK;
			}else if(obj == '*'){                													
				enemy = new Enemy(x,y);
				enemys.add(enemy);
				x = x + BLOCK;
			}else if(obj == '$'){                													
				key = new Key(x,y);	
				keys.add(key);
				x = x + BLOCK;
			}else if (obj=='a'){																		
				coin=new Coin(x,y);
				coins.add(coin);
				x=x+BLOCK;
			}else if(obj == '~'){																
				wizard = new Wizard(x,y);
				wizards.add(wizard);
				x = x + BLOCK;
			}else if(obj == 's'){																	
				shopkeeper = new Shopkeeper(x,y);
				shopkeepers.add(shopkeeper);
				x = x + BLOCK;
			}else if(obj == 'b'){																	
				check = new checkpoint(x,y);
				x=x+BLOCK;
			}else if(obj == 'k'){															
				Monster = new Boss(x,y);
				x=x+BLOCK;
			}else if(obj == 'p'){															
				Monster2 = new Boss2(x,y);
				x=x+BLOCK;
			}else if(obj == 'o'){																	
				Monster3 = new Boss3(x,y);
				x=x+BLOCK;	
			}else if(obj == 'w'){																	
				Geist = new Ghost(x,y);
				x=x+BLOCK;
			}else if(obj == 'v'){																
				geist2 = new Ghost(x,y);
				x=x+BLOCK;
			}else if(obj == 'r'){																	
				ball = new Ball(x,y);
				x=x+BLOCK;
			}else if(obj == 'i'){																	
				ice = new Ice(x,y);
				x=x+BLOCK;
				/*
				 *  Falls Objekt x im Shop schon gekauft wurde, wird es in anderen Shops nicht mehr 
				 *  verfuegbar sein.
				 */
			}else if(obj == '1' && bought1==false){												
				bai = new Buy_Armor_Ice(x,y);
				buyarmorsice.add(bai);
				x=x+BLOCK;
			}else if(obj == '1' && bought1==true){
				image = sw.getImage();
				this.setImage(image);
				x=x+BLOCK;
			}else if(obj == '2' && bought2==false){												
				baf= new Buy_Armor_Fire(x,y);
				buyarmorsfire.add(baf);
				x=x+BLOCK;
			}else if(obj == '2' && bought2==true){
				image = sw.getImage();
				this.setImage(image);
				x=x+BLOCK;
			}else if(obj == 'q' && bought3==false){												
				buy2 = new Buy2(x,y);
				buycannons.add(buy2);
				x=x+BLOCK;
			}else if(obj == 'q' && bought3==true){
				image = sw.getImage();
				this.setImage(image);
				x=x+BLOCK;
			}else if(obj == 'h' && bought4==false){																	
				buy1 = new Buy1(x,y);
				buyswords.add(buy1);
				x=x+BLOCK;
			}else if(obj == 'h' && bought4==true){
				image = sw.getImage();
				this.setImage(image);
				x=x+BLOCK;
			}
		}
	}
	private void setImage(Image image9) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Fuer die grafische Zeichnung mit Graphics g
	 */

	public void buildWorld( Graphics g){

		g.drawImage(img, 0, 0, null);																
		ArrayList<Movement> world = new ArrayList<Movement>();

		if (raum.contains("b")==true)world.add(check);															
		if (lr!="l3r6")world.add(Jay);
		if (raum.contains("k")) world.add(Monster);
		if (raum.contains("p")) world.add(Monster2);
		if (raum.contains("o")) world.add(Monster3);
		if (raum.contains("r")) world.add(ball);
		if (raum.contains("i")) world.add(ice);
		if (raum.contains("n")) world.add(ps);
		if (raum.contains("w")) {
			world.add(Geist);
		}
		if (raum.contains("v")) {
			world.add(geist2);
		}
		world.addAll(keys);
		world.addAll(wizards);
		world.addAll(coins);
		world.addAll(shopkeepers);

		for(int i = 0; i < world.size(); i++){													
			Movement obj = (Movement) world.get(i);
			g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);								
		}
		
		ArrayList<Shot> shots = getShots();
	       	for (int j = 0; j < shots.size(); j++){
	       		Shot m = (Shot) shots.get(j);
	       		g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }

        ArrayList<Sword> swords = getSwords();
	       		for (int i = 0; i < swords.size(); i++){
	       			Sword s = (Sword) swords.get(i);
	       			g.drawImage(s.getImage(), s.getX(), s.getY(), this);
               }
	       		
	    ArrayList<Cannon> cannons = getCannons();
	       		for (int j = 0; j < cannons.size(); j++){
	       			Cannon m = (Cannon) cannons.get(j);
	       		if (m.isVisible())
	       			g.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }	

	       		for (int i = 0; i < enemys.size(); i++){									
	       			Enemy e = (Enemy) enemys.get(i);
	       			if (e.isVisible())
	       				g.drawImage(e.getImage(), e.getX(), e.getY(), this);
	       			}
	       			
	       		for (int i = 0; i < buyswords.size(); i++){										
	       			Buy1 s = (Buy1) buyswords.get(i);
	       			if (s.isVisible())
	       				g.drawImage(s.getImage(), s.getX(), s.getY(), this);
	       			}
	       		
	       		for (int i = 0; i < buycannons.size(); i++){									
	       			Buy2 ca = (Buy2) buycannons.get(i);
	       			if (ca.isVisible())
	       				g.drawImage(ca.getImage(), ca.getX(), ca.getY(), this);
	       			}
	
	       		for (int i = 0; i < walls.size(); i++){											
	       			Wall w = (Wall) walls.get(i);
	       			if (w.isVisible())
	       				g.drawImage(w.getImage(), w.getX(), w.getY(), this);
	       			}
	       		
	       		for (int i = 0; i < coins.size(); i++){										
	       			Coin c = (Coin) coins.get(i);
	       			if (c.isVisible())
	       				g.drawImage(c.getImage(), c.getX(), c.getY(), this);
	       			}
	       		for (int i = 0; i < buyarmorsice.size(); i++){											
	       			Buy_Armor_Ice bi = (Buy_Armor_Ice) buyarmorsice.get(i);
	       			if (bi.isVisible())
	       				g.drawImage(bi.getImage(), bi.getX(), bi.getY(), this);
	       			}
	       		for (int i = 0; i < buyarmorsfire.size(); i++){											
	       			Buy_Armor_Fire bf = (Buy_Armor_Fire) buyarmorsfire.get(i);
	       			if (bf.isVisible())
	       				g.drawImage(bf.getImage(), bf.getX(), bf.getY(), this);
	       			}
	}
	
    

	public void paint(Graphics g){
		super.paint(g);
		
	if(ingame){																					
		buildWorld(g);																			
		if (raum.contains("k")){
			if (lr.charAt(1)=='1') Monster_speed=2;
			else Monster_speed=1;
			movemonster();
		}if (raum.contains("p")){
			if (lr.charAt(1)=='2') Monster_speed=2;
			else Monster_speed=1;
			movemonster2();
		}if (raum.contains("o")){
			if (lr.charAt(1)=='3') Monster_speed=2;
			else Monster_speed=1;
			movemonster3();
		}if (raum.contains("w")){
			if (lr.charAt(1)=='1') Geist_speed=1;
			else if (lr.charAt(1)=='2')Geist_speed=1;
			else Geist_speed=1;
			if (g1x!=0){
				Geist.setX(g1x);
				g1x=0;
			}if (g1y!=0){
				Geist.setY(g1y);
				g1y=0;
			}
			MoveGeist(Geist);
		}if (raum.contains("v")){
			if (lr.charAt(1)=='1') Geist_speed=1;
			else if (lr.charAt(1)=='2')Geist_speed=1;
			else Geist_speed=1;
			if (g2x!=0){
				geist2.setX(g2x);
				g2x=0;
			}if (g2y!=0){
				geist2.setY(g2y);
				g2y=0;
			}
			movegeist(geist2);
		}if (raum.contains("r")){
			if (mx==0)mx=Jay.getX();
			if (my==0)my=Jay.getY();
	
			 if (lr.charAt(1)=='3'){
				schuss_speed=3;
				moveBall3();
			}
				}if (raum.contains("i")){
				if (mx==0)mx=Jay.getX();
				if (my==0)my=Jay.getY();
				if (lr.charAt(1)=='2') {
					schuss_speed=4;
					moveIce2();
				}
			}

		counter=counter+1;
		int countsmoney= ruban + xruban;		
		
		/* Fuer die Anzeige von Leben, Mana, Geld,
		 * 
		 */
        String s,w,l;

        g.setFont(smallfont);																
        g.setColor(new Color(20,200,155));
        s = "Money: " + (countsmoney);
        g.drawString(s,970,150);
    	g.drawImage(schatz,970,190,this);													
	
    	int lifebar= life;
    	
		String t,k;
																						
		t = "Leben: " + (lifebar);
		g.drawString(t,970,40);
		
		if(life==3){																	
		g.drawImage(herz1,970,60,this);
		g.drawImage(herz1,1020, 60, this);
		g.drawImage(herz1,1070, 60, this);
		}
		if(life==2){						
			g.drawImage(herz1,970,60,this);
			g.drawImage(herz1,1020, 60, this);
		}																	
		if(life==1){
			g.drawImage(herz1,970,60,this);
		}
		
		/*
		 *  Diggy hat die Moeglichkeit eine Ruestung durch Verbauch von einem Mana zu tragen oder sich unsichbar zu machen.
		 *  Aussderm hat er die Moeglichkeit, die Ruestungen im Shop fuer 5 $ zu kaufen.
		 */
		
		   String mes;
		        g.setFont(smallfont);																
		        mes = "Mana: ";
		        g.drawString(mes,970,280);
		 
		    if(mana==3){
				g.drawImage(im3,970,300,this);
				w = "Mach dich unsichtbar (i)";
				g.drawString(w,970,380);
				l = "Benutze deine Feuerrüstung (f)";
				g.drawString(l,970,400);
				k = "Benutze deine Eisrüstung (e)";
				g.drawString(k,970,420);
				
		    }
		    if(mana == 2){
		    	g.drawImage(im2,970, 300, this);
				w = "Mach dich unsichtbar (i)";
				g.drawString(w,970,380);
				l = "Benutze deine Feuerrüstung (f)";
				g.drawString(l,970,400);
				k = "Benutze deine Eisrüstung (e)";
				g.drawString(k,970,420);
		    }
		    if(mana==1){
				g.drawImage(im1,970,300,this);
				w = "Mach dich unsichtbar (i)";
				g.drawString(w,970,380);
				l = "Benutze deine Feuerrüstung (f)";
				g.drawString(l,970,400);
				k = "Benutze deine Eisrüstung (e)";
				g.drawString(k,970,420);
		    }
        	
		    /*
		     *  Falls Diggy eine Waffe kauft, wird angezeigt, mit welcher Taste er die neue Waffe benutzen soll
		     */
    
       if(get_sword==true){
   			g.drawImage(swor, 970, 500, this);
   			l = "Benutze deine Waffe";
   			t = "(v)";
   			g.drawString(l,970,480);
   			g.drawString(t,970,510);
       }if(get_cannon==true){
    		g.drawImage(cannon, 1020, 500, this);
   			l = "Benutze deine Waffe";
   			t = "(m)";
   			g.drawString(l,970,480);
   			g.drawString(t,1020,510);
       }

	}else{																		
	}    
	}
  public ArrayList<Shot> getShots() {																
	        return shots;
	    }
  
  public ArrayList<Sword> getSwords() {																
	     return swords;
  }
    
  public ArrayList<Cannon> getCannons() {										
        return cannons;
  }
  
  /*
   * Falls Diggy ein Mana fuer eine Eis- bzw. Feuerruesstung verbraucht traegt er diese Rüstung als Schutz gegen die Obergegner.
   * Mit der Eisrusestung schuetzt er sich vor dem zweiten Obergegner.
   * Mit der Feuerruestung schuetzt er sich vor dem dritten Obergegner.
   */
 
  private String room;
  private class Ap extends KeyAdapter{														
																		
		public  void keyPressed(KeyEvent e){

			int key = e.getKeyCode();

			if(key == KeyEvent.VK_RIGHT && armor_ice != true && armor_fire != true){		
				
				Image image1 = image = r.getImage();										
				Jay.setImage(image1);
				position = 1;
				collision(BLOCK,0, image1);
				
			}else if(armor_ice == true && key == KeyEvent.VK_RIGHT){
				
				Image image1i = image = ir.getImage();										
				Jay.setImage(image1i);
				position = 1;
				collision(BLOCK,0, image1i);
				
			}else if(armor_fire == true && key == KeyEvent.VK_RIGHT){
				
				Image image1f = image = dfr.getImage();										
				Jay.setImage(image1f);
				position = 1;
				collision(BLOCK,0, image1f);
				
			}else if(key == KeyEvent.VK_LEFT && armor_ice != true && armor_fire != true){

				Image image2 = image = l.getImage();
				Jay.setImage(image);
				position = 2;
				collision(-BLOCK,0, image2);
				
			}else if(armor_ice == true && key == KeyEvent.VK_LEFT){
					
					Image image2i = image = il.getImage();										
					Jay.setImage(image2i);
					position = 2;
					collision(-BLOCK,0, image2i);
					
			}else if(armor_fire == true && key == KeyEvent.VK_LEFT){
				
				Image image2f = image = dfl.getImage();										
				Jay.setImage(image2f);
				position = 2;
				collision(-BLOCK,0, image2f);

			}else if(key == KeyEvent.VK_UP && armor_ice !=true && armor_fire != true){

				Image image3= image = t.getImage() ;
				Jay.setImage(image);
				position = 3;
				collision(0,-BLOCK,image3);
				
			}else if(armor_ice == true && key == KeyEvent.VK_UP){
					
					Image image3i = image = ib.getImage();										
					Jay.setImage(image3i);
					position = 3;
					collision(0,-BLOCK, image3i);
					
			}else if(armor_fire == true && key == KeyEvent.VK_UP){
				
				Image image3f = image = dfb.getImage();										
				Jay.setImage(image3f);
				position = 3;
				collision(0,-BLOCK, image3f);

			}else if(key == KeyEvent.VK_DOWN && armor_ice != true && armor_fire != true){
				
				Image image4 = image = b.getImage();
				Jay.setImage(image);
				position = 4;
				collision(0,BLOCK, image4);
				
			}else if(armor_ice == true && key == KeyEvent.VK_DOWN){
					
					Image image4i = image = it.getImage();										
					Jay.setImage(image4i);
					position = 4;
					collision(0,BLOCK, image4i);
					
			}else if(armor_fire == true && key == KeyEvent.VK_DOWN){
				
				Image image4f = image = dff.getImage();										
				Jay.setImage(image4f);
				position = 4;
				collision(0,BLOCK, image4f);

			}else if (key == KeyEvent.VK_SPACE) {													
				fire();
				
			}else if (key == KeyEvent.VK_M && get_cannon==true) {								
				cannon();
				
			}else if (key == KeyEvent.VK_V && get_sword==true) {								
				sword_play();
				
			}else if (key == KeyEvent.VK_I && get_invisible==true) {									
				if(mana>0){
				use_mana_invisible();
				use_invisible = use_invisible -1;
				if(use_invisible==0){
					get_invisible = false;
					mana = mana -1;
				}
			}
				
				/*
				 * Falls die Taste F fuer Feuerruestung oder E fuer Eisruestung bedient wird, und Diggy noch die 
				 * Ruestung nihct hat traegt er diese und verliert ein Mana
				 */
			}else if(key == KeyEvent.VK_F && armor_fire!=true){
			
				if(mana>1)	{
					armor_fire=true;
					mana = mana -1;
					if(armor_ice!=false){
						armor_ice =false;
					}
				}
			}else if(key == KeyEvent.VK_E && armor_ice!=true){
					if(mana>1)	{
						armor_ice = true;
						mana = mana - 1;
						if(armor_fire!=false){
							armor_fire =false;
						}
					}
			}	
	
			repaint();

			/*
			 *  Hierdurch findet der Uebergang von den Raeumen der Levels statt
			 */
			if ((Jay.getY()==-BLOCK)||(Jay.getY()==0))  {	
				if (lr.charAt(3)=='1') lr=lr.substring(0,3)+"2";									
				else if (lr.charAt(3)=='2') lr=lr.substring(0,3)+'3';							
				else if (lr.charAt(3)=='3') lr=lr.substring(0,3)+'4';						
				else if (lr.charAt(3)=='4') lr=lr.substring(0,3)+'5';
				besuch=false;
				xruban=xruban+ruban;
				xlife=xlife+life;
				ruban=0;
				loeschen(true);
				try {
					initWorld(Jay.getImage());
				} catch (IOException e1) {
					e1.printStackTrace();
				}																			
			}
			if (Jay.getX() ==950 ){																
				if (lr.length()==5){
					lr=lr.substring(0,4);
					raum=room;
					besuch=true;
					loeschen(false);
					try {
						initWorld(Jay.getImage());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else {
					if (lr.charAt(3)=='1') lr=lr.substring(0,3)+"2";								
					else if (lr.charAt(3)=='2') lr=lr.substring(0,3)+'3';							
					else if (lr.charAt(3)=='3') lr=lr.substring(0,3)+'4';								
					else if (lr.charAt(3)=='4') lr=lr.substring(0,3)+'5';								
					besuch=false;
					xruban=xruban+ruban;
					xlife=xlife+life;
					ruban=0;
					loeschen(true);
					try {
						initWorld(Jay.getImage());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			if ((Jay.getX() ==0 )&&(Jay.getY()<500)){
				if (luecke.visible==false)
				{	lr=lr+'a';


					room=raum;
					int c =room.lastIndexOf("@");						
					room=room.substring(0,c)+' '+room.substring(c+1);
					room=room.substring(0,(Jay.getY()/50)*20+(Jay.getX()/50)+1)+'@'+room.substring((Jay.getY()/50)*20+(Jay.getX()/50)+2);
					luecke.setVisible(true);
					loeschen(true);
					try {
						initWorld(Jay.getImage());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}


			}
		}
	}

 
	public void restartLevel(boolean test,Image image2) throws IOException {			
		loeschen(test);
		initWorld(Jay.getImage());
	}
	
	/*
	 *  Methoden fuer die Waffennutzung
	 */

	 public void fire() {
		 	if(position==1){
		 		shots.add(new Shot(Jay.getX() + BLOCK, Jay.getY()));							
		 		k = 00;}
		 	if(position==2){																	
		 		shots.add(new Shot(Jay.getX() - BLOCK, Jay.getY()));							
		 		k = 01;}
		 	if(position==3){
		 		shots.add(new Shot(Jay.getX(), Jay.getY() - BLOCK));
		 		k = 10;}
		 	if(position==4){
		 		shots.add(new Shot(Jay.getX(), Jay.getY() + BLOCK));	
		 	    k = 11;}
	}
	 
	 public void cannon() {
		 	if(position==1){ 
		 		cannons.add(new Cannon(Jay.getX() + BLOCK, Jay.getY()));							
		 		k = 00;}
		 	if(position==2){																		
		 		cannons.add(new Cannon(Jay.getX() - BLOCK, Jay.getY()));								
		 		k = 01;}
		 	if(position==3){
		 		cannons.add(new Cannon(Jay.getX(), Jay.getY() - BLOCK));
		 		k = 10;}
		 	if(position==4){
		 		cannons.add(new Cannon(Jay.getX(), Jay.getY() + BLOCK));	
		 	    k = 11;}
	}

	 public void sword_play(){																					

	 	 	if(position==1){																		
		 		image = dr.getImage();
				Jay.setImage(image);
				swords.add(new Sword(Jay.getX() + 2, Jay.getY()));							  
		 		z = 00;}																		
		 	if(position==2){			
		 		image = dl.getImage();
				Jay.setImage(image);																	
			 	swords.add(new Sword(Jay.getX() - 2, Jay.getY()));									
			 	z = 01;}
		 	if(position==3){
		 		image = du.getImage();
				Jay.setImage(image);
				swords.add(new Sword(Jay.getX(), Jay.getY() - 2));
		 		z = 10;}
			if(position==4){
		 		image = db.getImage();
				Jay.setImage(image);
				swords.add(new Sword(Jay.getX(), Jay.getY() + 2));	
		 	    z = 11;}
		 	}
	 
	 	public void use_mana_invisible(){
	 		if(get_invisible==true){
	 			image = sb.getImage();
	 			Jay.setImage(image);
	 		}
	 	}
	 	
	 	/*
	 	 * Die Schuesse der Waffen von Diggy werden gezeichnet, wobei abgefragt wird in welche richtung es geschossen werden soll.
	 	 * Es werden Kollsionsabfragen von Schuessen und Objekten gemacht.
	 	 * Der erste und der zweite Obergegner koennen mit Feuerbaellen getoeten werden.
	 	 * Der dritte Obergegner kann nur durch Schuss mit der Kannone besiegt werden.
	 	 * 
	 	 */

	 @Override
	 public void actionPerformed(ActionEvent e) {													

    ArrayList<Shot> shots = getShots();
     
     for (int i = 0; i < shots.size(); i++) {
    	 Shot m = (Shot) shots.get(i);														
		 																					
    	 if(m.isVisible()){	 	
    		if(k==00) m.move_r();
			if(k==01) m.move_l();
			if(k==10) m.move_u();
			if(k==11) m.move_d();
    	 }else shots.remove(i);
    	 
    	 	check_shot_vs_wall();																	
			check_shot_vs_enemy();
			check_shot_vs_coin();
			
			if (raum.contains("k")){
				check_shot_vs_boss();
			}
			if (raum.contains("p")){
				check_shot_vs_boss2();
			}
     	}

	   ArrayList<Cannon> cannons = getCannons();
	   
	       for (int j = 0; j < cannons.size(); j++){
	       		Cannon m = (Cannon) cannons.get(j);
	       	
           		if(m.isVisible()){	 	
		 			if(k==00) m.move_r();
		 			if(k==01) m.move_l();
		 			if(k==10) m.move_u();
		 			if(k==11) m.move_d();
           		}else cannons.remove(j);
           		
           		check_shot_vs_wall();																
           		
           		check_shot_vs_coin();
			if (raum.contains("o")){
				check_cannon_vs_boss3();
			}
			
	    }
	
	    ArrayList<Sword> swords = getSwords()
					 ;
			 for (int j = 0; j < swords.size(); j++) {												
				 Sword s = (Sword) swords.get(j);

				 if(s.isVisible()){
					 if(z==00) s.move_r_sword();
					 if(z==01) s.move_l_sword();
					 if(z==10) s.move_u_sword();
			    	 if(z==11) s.move_d_sword();

				 }else swords.remove(j);
				 	check_sword_vs_wall();													
				 	check_sword_vs_coin();
	 		}	
			 repaint();	
	}
	 
	 
	 
	 /*
		 * Der erste Obergegner kann nur durch 6 Feuerebaellen besiegt werden.
		 * Boss2 durch 12 Fauerbaelle. Boss3 durch 12 Kannonenschuesse.
		 * Der einfache Gegner wie der Vogel kann durch Kannonenschuss, Feuerball und Schwertkampf besiegt werden.
		 * 
		 */
	
		private int boss_leben_shot = 6;
		public void check_shot_vs_boss() {																
			ArrayList<Shot> shots = getShots();

		    for (int i = 0; i < shots.size(); i++) {
		        Shot m = (Shot) shots.get(i);
		        Rectangle r1 = m.getBounds();
		        
		       

		        if ((Math.abs(r1.x-Monster.getX())<50)&&(Math.abs(r1.y-Monster.getY())<50)) {		
		        
		        		boss_leben_shot=boss_leben_shot-1;
		        		if (boss_leben_shot==0){
		        			if (lr.charAt(3)=='5')lr=lr.substring(0,3)+'6';
		        			else if (lr.charAt(3)=='4')lr=lr.substring(0, 3)+'5';
		        			loeschen(true);
		        			try {
		        				initWorld(Jay.getImage());
		        			} catch (IOException e1) {
		        				e1.printStackTrace();
		        			}
		        		}
		    	}
		    }

		}
		
		private int boss2_leben_shot = 12;
		public void check_shot_vs_boss2() {																
			ArrayList<Shot> shots = getShots();

		    for (int i = 0; i < shots.size(); i++) {
		        Shot m = (Shot) shots.get(i);
		        Rectangle r1 = m.getBounds();

		        if ((Math.abs(r1.x-Monster2.getX())<50)&&(Math.abs(r1.y-Monster2.getY())<50)) {													 		
		        	boss2_leben_shot=boss2_leben_shot-1;
		        		if (boss2_leben_shot==0){
		        			if (lr.charAt(3)=='5')lr=lr.substring(0,3)+'6';
		        			else if (lr.charAt(3)=='4')lr=lr.substring(0, 3)+'5';
		        			loeschen(true);
		        			try {
		        			initWorld(Jay.getImage());
		        			} catch (IOException e1) {


		        				e1.printStackTrace();
		        			}
		        		}
		    	}
		    }

		}
	
 			private int boss3_leben_cannon = 12;
 	        public void check_cannon_vs_boss3() {	 
 					        	
 	            ArrayList<Cannon> cannons = getCannons();
 	        	for (int j = 0; j < cannons.size(); j++) {
 	    	        Cannon g = (Cannon) cannons.get(j);
 	    	        Rectangle r2 = g.getBounds();
 

 	    	        if ((Math.abs(r2.x-Monster3.getX())<50)&&(Math.abs(r2.y-Monster3.getY())<50)) {													 		
 	    	        	boss3_leben_cannon=boss3_leben_cannon-1;
 	    	        		if (boss3_leben_cannon==0){
 	    	        			if (lr.charAt(3)=='5')lr=lr.substring(0,3)+'6';
 	    	        			else if (lr.charAt(3)=='4')lr=lr.substring(0, 3)+'5';
 	    	        			loeschen(true);
 	    	        			try {
 	    	        				initWorld(Jay.getImage());
 	    	        			} catch (IOException e1) {
 	    	        				e1.printStackTrace();
 	    	        			}
 	    	        		}
 	    	        		
 	        		}
 	        	}
 	        }
			


		public void check_shot_vs_coin() {														
			

			ArrayList<Shot> shots = getShots();

				for (int i = 0; i < shots.size(); i++) {
					Shot m = (Shot) shots.get(i);
					Rectangle r1 = m.getBounds();

			        for (int k = 0; k< coins.size(); k++) {
				        Coin c = (Coin) coins.get(k);
				        Rectangle r2 = c.getBounds();

			            if (r1.intersects(r2)) {													 	
			                m.setVisible(false);
			                c.setVisible(true);

			             }
			        }
				}
		    ArrayList<Cannon> cannons = getCannons();
				 	   
				for (int k = 0; k < cannons.size(); k++){
				 	 Cannon ca = (Cannon) cannons.get(k);        
				 	  Rectangle r3 = ca.getBounds();

				        for (int i = 0; i< coins.size(); i++) {
					        Coin c = (Coin) coins.get(i);
					        Rectangle r2 = c.getBounds();

		            if (r3.intersects(r2)) {													 		
		                ca.setVisible(false);
		                c.setVisible(true);

		             }
		        }
		  }
	}
		public void check_sword_vs_coin() {										


			 ArrayList<Sword> swords = getSwords();


				for (int j = 0; j < swords.size(); j++) {										
					Sword s = (Sword) swords.get(j);


			        Rectangle r1 = s.getBounds();


			        for (int i = 0; i< coins.size(); i++) {
				        Coin c = (Coin) coins.get(i);
				        Rectangle r2 = c.getBounds();


			            if (r1.intersects(r2)) {
			                s.setVisible(false);
			                c.setVisible(true);
			            }
			        }
			    }
			}
		public void check_sword_vs_wall() {																


			 ArrayList<Sword> swords = getSwords();


				for (int j = 0; j < swords.size(); j++) {										
					Sword s = (Sword) swords.get(j);


			        Rectangle r1 = s.getBounds();


			        for (int i = 0; i< walls.size(); i++) {
				        Wall w = (Wall) walls.get(i);
				        Rectangle r2 = w.getBounds();


			            if (r1.intersects(r2)) {
			                s.setVisible(false);
			                w.setVisible(true);
			            }
			        }
			    }
			}
		
		private Wall luecke;
		public void check_shot_vs_wall() {														

			ArrayList<Shot> shots = getShots();

		    for (int i = 0; i < shots.size(); i++) {
		        Shot m = (Shot) shots.get(i);
		        Rectangle r1 = m.getBounds();

		        for (int j = 0; j < walls.size(); j++) {
			        Wall w = (Wall) walls.get(j);
			        Rectangle r2 = w.getBounds();

		            if (r1.intersects(r2)) {												
		                if ((w.getX()==0)&&(w.getY()==50)){
		                	m.setVisible(false);
		                    w.setVisible(false);
		                    luecke=w;
		                }
		                else{
		                	m.setVisible(false);
		                    w.setVisible(true);
		                }
		             }
		        }
		    }
		    ArrayList<Cannon> cannons = getCannons();

			for (int k = 0; k < cannons.size(); k++){
			 	 Cannon ca = (Cannon) cannons.get(k);        
			 	  Rectangle r3 = ca.getBounds();

			 	  for (int j = 0; j < walls.size(); j++) {
				        Wall w = (Wall) walls.get(j);
				        Rectangle r2 = w.getBounds();
				        
				        if (r3.intersects(r2)) {												
				        	ca.setVisible(false);
				        	w.setVisible(true);
				        }
			 	  }
			}  
		}

		public void check_shot_vs_enemy() {								


			for (int i = 0; i < shots.size(); i++) {
		        Shot m = (Shot) shots.get(i);
		        Rectangle r1 = m.getBounds();


		   	      	int xx = (int) ((r1.getX())/BLOCK);																	
	        		int yy=(int)(r1.getY())/BLOCK;
	     
	        		if (raum.charAt(yy*20+xx)=='*') {																															
		        		int xxx = ((Jay.getX())/BLOCK);																	
		        		int yyy=(Jay.getY())/BLOCK;	


		        		raum=raum.substring(0,yy*20+xx)+' '+raum.substring(yy*20+xx+1);	
		        				int c =raum.lastIndexOf("@");						
		    					raum=raum.substring(0,c)+' '+raum.substring(c+1);
		    					raum=raum.substring(0,yyy*20+xxx)+'@'+raum.substring(yyy*20+xxx+1);
		    					try {
		    						restartLevel(false,Jay.getImage());
		    					} catch (IOException e1) {
		    						e1.printStackTrace();
		    					}
	        		
	        		}

		        }
			}
		
		public void check_cannon_vs_enemy() {								


			for (int i = 0; i < cannons.size(); i++) {
		        Cannon g = (Cannon) cannons.get(i);
		        Rectangle r1 = g.getBounds();


		   	      	int xx = (int) ((r1.getX())/BLOCK);																	
	        		int yy=(int)(r1.getY())/BLOCK;
	     
	        		if (raum.charAt(yy*20+xx)=='*') {																																					
		        		int xxx = ((Jay.getX())/BLOCK);																	
		        		int yyy=(Jay.getY())/BLOCK;	


		        		raum=raum.substring(0,yy*20+xx)+' '+raum.substring(yy*20+xx+1);	
		        				int c =raum.lastIndexOf("@");						
		    					raum=raum.substring(0,c)+' '+raum.substring(c+1);
		    					raum=raum.substring(0,yyy*20+xxx)+'@'+raum.substring(yyy*20+xxx+1);
		    					try {
		    						restartLevel(false, Jay.getImage());
		    					} catch (IOException e1) {
		    						e1.printStackTrace();
		    					}
	        		
	        		}

		        }
			}
		private int g1x,g2x,g1y,g2y;
		
		public void check_sword_vs_enemy() {	
			 ArrayList<Sword> swords = getSwords();


			for (int i = 0; i < swords.size(); i++) {
		        Sword s = (Sword) swords.get(i);
		        Rectangle r1 = s.getBounds();


		            int xx = (int) ((r1.getX())/BLOCK);					
	        		int yy=(int)(r1.getY())/BLOCK;


	        		if (raum.charAt(yy*20+xx)=='*') {														
	        			g1x=Geist.getX();
		    			g2x=geist2.getX();
		    			g1y=Geist.getY();
		    			g2y=geist2.getY();
	        			int xxx = ((Jay.getX())/BLOCK);						
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

		/*
		 *  Es gibt 4 Artikel im Shop die Diggy bei Kollision und genuegend Guthaben aufnimmt.
		 *  Diese sind dann verkauft.
		 */

		public void buy_sword() {																									

			  	Rectangle r1 = Jay.getBounds();

		        for (int j = 0; j < buyswords.size(); j++) {
			        Buy1 b = (Buy1) buyswords.get(j);
			        Rectangle r2 = b.getBounds();
			        
		            if (r1.intersects(r2)) {													 		
		                Jay.setVisible(true);
		                b.setVisible(false);
		            }
		        }
		}

		public void buy_cannon(){

		  		Rectangle r1 = Jay.getBounds();

		  		for (int j = 0; j < buycannons.size(); j++) {
		  			Buy2 ca = (Buy2) buycannons.get(j);
		  			Rectangle r3 = ca.getBounds();


		  			if (r1.intersects(r3)) {													 		
		  				Jay.setVisible(true);
		  				ca.setVisible(false);
		  			}
		  		}
		}


		public void buy_armor_ice_shop(){


		  		Rectangle r1 = Jay.getBounds();
		  		
		  		for (int i = 0; i < buyarmorsice.size(); i++){								
	       			Buy_Armor_Ice k = (Buy_Armor_Ice) buyarmorsice.get(i);
	       			Rectangle r2 = k.getBounds();

	       			if (r1.intersects(r2)) {													 		
		  				Jay.setVisible(true);
		  				k.setVisible(false);
		  			}
		  		}
		}
		
		public void buy_armor_fire_shop(){


	  		Rectangle r1 = Jay.getBounds();
	  		
	  		for (int i = 0; i < buyarmorsfire.size(); i++){										
       			Buy_Armor_Fire f = (Buy_Armor_Fire) buyarmorsfire.get(i);
       			Rectangle r2 = f.getBounds();

       			if (r1.intersects(r2)) {													 		
	  				Jay.setVisible(true);
	  				f.setVisible(false);
	  			}
	  		}
	}

		 public Rectangle getBounds(){
				return new Rectangle(Jay.getX(),Jay.getY(),50,50);				
			}

		 /*
		  * Dialogue() und DialogueShop() sind die Frames mit Auskunft vom Zauberer und Ladenbesitzer
		  */
		 
			public void Dialogue(){																

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

			public void DialogueShop(){                                  								      
				
			JFrame DialogueShop = new DialogueShop("Ladenbesitzer");
			DialogueShop.setSize(600,300);
			DialogueShop.setLocationRelativeTo(null);
			DialogueShop.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			DialogueShop.setVisible(true);
			DialogueShop.setFocusable(true);
			DialogueShop.setLayout(new BorderLayout());     
			DialogueShop.setLayout(null);
		    DialogueShop.add(new Dialogue("Ladenbesitzer"));
		    }
			
			
			public static void raetsel() throws IOException{	
				
			JFrame Raetsel = new Raetsel(puzzle_nr);
			Raetsel.setSize(600,600);
			Raetsel.setLocationRelativeTo(null);
			Raetsel.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			Raetsel.setVisible(true);
			Raetsel.setFocusable(true);
			Raetsel.setLayout(new BorderLayout());
			Raetsel.setLayout(null);
			Raetsel.add(new Raetsel(puzzle_nr));
			}

			/*
			 * Fenster bei Niederlage, die zum Menue fuehrt.
			 */
			
			public void Game_over(){

			JFrame Game_over = new JFrame();
			Game_over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Game_over.setSize(500,500);
			Game_over.setVisible(true);
			Game_over.setFocusable(true);
			Game_over.setLocationRelativeTo(null);   																		 
			Game_over.add(new Game_over());
			}
	}


 
