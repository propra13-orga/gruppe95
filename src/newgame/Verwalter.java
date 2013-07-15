package newgame;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;

 
 
 public class Verwalter {
	 
 public static void main(String [] args){
	 try {
	//	 new Server().start(); 														// Server
		 new Chatter().start(); 													// Client
	 }catch (Exception e){
		 	e.printStackTrace();
	 }
 	}
 }
 
 class Server extends Thread{
 Chat_Frame frame;
 ServerSocket _ServerSocket = null;
 Socket _ClientSocket = null;
 PrintWriter _out = null;
 BufferedReader _in = null;
 
 
 	Server() throws Exception{
 	_ServerSocket = new ServerSocket(4711);											// Server erzeugt Serversocket
 }
 
 public void run(){
	 while(true){
		 try {
		 	_ClientSocket = _ServerSocket.accept(); // Warte auf Verbindung
		 	_out = new PrintWriter(_ClientSocket.getOutputStream(),true);// Ausgabestrom
		 	_in = new BufferedReader(new InputStreamReader(_ClientSocket.getInputStream())); // Eingabestrom
		 	frame = new Chat_Frame("Chat :: Server", _out, _in);
	 while(true){
		 	String incoming = _in.readLine();
		 	frame.addAusgabe(incoming);
	 	} //while
	}catch (IOException e){
		 		System.out.println("Fehler - ServerSocket.accept()");
	}//catch
   }//while
  }
 }
