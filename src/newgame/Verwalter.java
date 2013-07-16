package newgame;
<<<<<<< HEAD
=======

>>>>>>> 32abf7ebb36ac55cc6d14777fd18bf4af5deaaec

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
<<<<<<< HEAD
import javax.swing.JFrame;

 
 

 /*
  * Auf einem Rechner wird (new Chatter().start()) auskommentiert.
  * Auf dem anderen (new Server().start())
  */
=======


 
 
>>>>>>> 32abf7ebb36ac55cc6d14777fd18bf4af5deaaec
 public class Verwalter {
	 
 public static void main(String [] args){
	 try {
<<<<<<< HEAD
	//	 new server1().start(); 														// Server
		 new Chatter().start(); 													// Client
=======
		 new Servera().start(); 													
	//	 new Chatter().start(); 													
>>>>>>> 32abf7ebb36ac55cc6d14777fd18bf4af5deaaec
	 }catch (Exception e){
		 	e.printStackTrace();
	 }
 	}
 }
 
<<<<<<< HEAD

/*
 *  Server erzeugt Serversocket auf Port 4711
 */

 class server1 extends Thread{
=======
 class Servera extends Thread{
>>>>>>> 32abf7ebb36ac55cc6d14777fd18bf4af5deaaec
 Chat_Frame frame;
 ServerSocket _ServerSocket = null;
 Socket _ClientSocket = null;
 PrintWriter _out = null;
 BufferedReader _in = null;
 
 
<<<<<<< HEAD
 	server1() throws Exception{
 	_ServerSocket = new ServerSocket(4711);											// Server erzeugt Serversocket
 }

 
 	/*
 	 * Es wird auf Verbindung gewartet. 
 	 * @param _out Ausgabestrom
 	 * @param _in Eingabestrom
 	 * Methode addAusgabe zeigt Eingabe des Empfaengers an.
 	 * 
 	 */


 public void run(){
	 while(true){
		 try {
		 	_ClientSocket = _ServerSocket.accept(); // Warte auf Verbindung
		 	_out = new PrintWriter(_ClientSocket.getOutputStream(),true);// Ausgabestrom
		 	_in = new BufferedReader(new InputStreamReader(_ClientSocket.getInputStream())); // Eingabestrom
=======
 	Servera() throws Exception{
 	_ServerSocket = new ServerSocket(4711);							
 }
 
 public void run(){
	 while(true){
		 try {
		 	_ClientSocket = _ServerSocket.accept(); 
		 	_out = new PrintWriter(_ClientSocket.getOutputStream(),true);
		 	_in = new BufferedReader(new InputStreamReader(_ClientSocket.getInputStream()));
>>>>>>> 32abf7ebb36ac55cc6d14777fd18bf4af5deaaec
		 	frame = new Chat_Frame("Chat :: Server", _out, _in);
	 while(true){
		 	String incoming = _in.readLine();
		 	frame.addAusgabe(incoming);
<<<<<<< HEAD
	 	} //while
=======
	 	} 
>>>>>>> 32abf7ebb36ac55cc6d14777fd18bf4af5deaaec
	}catch (IOException e){
		 		System.out.println("Fehler - ServerSocket.accept()");
	}//catch
   }//while
  }
 }
