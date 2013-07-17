package newgame;
<<<<<<< HEAD
=======

>>>>>>> 55f969df40dfc2a006e13902eeaab748b1f950b7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
<<<<<<< HEAD



 
 

 /*
  * Auf einem Rechner wird (new Chatter().start()) auskommentiert.
  * Auf dem anderen (new Server().start())
  */

=======

/*
 * Server erzeugt server Socket und wartet auf Verbindung.
 */

>>>>>>> 55f969df40dfc2a006e13902eeaab748b1f950b7
 public class Verwalter {
	 
 public static void main(String [] args){
	 try {
<<<<<<< HEAD

		 new Servera().start(); 													
	//	 new Chatter().start(); 													

=======
		 new Servera().start(); 													
	//	 new Chatter().start(); 													
>>>>>>> 55f969df40dfc2a006e13902eeaab748b1f950b7
	 }catch (Exception e){
		 	e.printStackTrace();
	 }
 	}
 }
 
<<<<<<< HEAD


/*
 *  Server erzeugt Serversocket auf Port 4711
 */

 class Servera extends Thread{

=======
 class Servera extends Thread{
>>>>>>> 55f969df40dfc2a006e13902eeaab748b1f950b7
 Chat_Frame frame;
 ServerSocket _ServerSocket = null;
 Socket _ClientSocket = null;
 PrintWriter _out = null;
 BufferedReader _in = null;
 
 
<<<<<<< HEAD


 
 	/*
 	 * Es wird auf Verbindung gewartet. 
 	 * @param _out Ausgabestrom
 	 * @param _in Eingabestrom
 	 * Methode addAusgabe zeigt Eingabe des Empfaengers an.
 	 * 
 	 */


 
=======
>>>>>>> 55f969df40dfc2a006e13902eeaab748b1f950b7
 	Servera() throws Exception{
 	_ServerSocket = new ServerSocket(4711);							
 }
 
 public void run(){
	 while(true){
		 try {
		 	_ClientSocket = _ServerSocket.accept(); 
		 	_out = new PrintWriter(_ClientSocket.getOutputStream(),true);
		 	_in = new BufferedReader(new InputStreamReader(_ClientSocket.getInputStream()));
<<<<<<< HEAD

=======
>>>>>>> 55f969df40dfc2a006e13902eeaab748b1f950b7
		 	frame = new Chat_Frame("Chat :: Server", _out, _in);
	 while(true){
		 	String incoming = _in.readLine();
		 	frame.addAusgabe(incoming);
<<<<<<< HEAD

	 	} 

=======
	 	} 
>>>>>>> 55f969df40dfc2a006e13902eeaab748b1f950b7
	}catch (IOException e){
		 		System.out.println("Fehler - ServerSocket.accept()");
	}
   }
  }
 }
