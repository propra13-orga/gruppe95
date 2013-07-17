

package newgame;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/*
 * Hier verbindet sich der Client mit Server.
 * @param _out gibt die verschickte Nachricht wieder
 * @param _in liest die empfangene Nachricht 
 * @param frame gibt der Methode Chat_Frame was Eingabe und Ausgabe ist
 */
 
 public class Chatter extends Thread{
 Chat_Frame frame;
 Socket _Socket = null;
 PrintWriter _out = null;
 BufferedReader _in = null;
 Scanner _keyboard = new Scanner(System.in);

	 			
 				Chatter(){
	 					try{
	 						_Socket = new Socket("192.168.2.110", 4711);// 192.168.2.110, "localhost",4711
	 						_out = new PrintWriter(_Socket.getOutputStream(), true);
	 						_in = new BufferedReader(new InputStreamReader(_Socket.getInputStream()));
	 						frame = new Chat_Frame("Chat :: Client", _out, _in);
	 					}catch(Exception e){
	 						System.exit(1);
	 						} 
 						}
 			
 				
 		/*
 		 * Nachricht wird empfangen, Methode addAusgabe gibt das geschriebene aus
 		 * 
 		 */

 		public void run(){
	 		while(true){
	 			String incoming;
	 					try{
	 						incoming = _in.readLine();
	 						frame.addAusgabe(incoming);
	 					}catch (IOException e){
	 						e.printStackTrace();
	 					 	}
	 					} 
	 		} 
 		}


