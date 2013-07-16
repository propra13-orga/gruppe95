package newgame;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Server erzeugt server Socket und wartet auf Verbindung.
 */

 public class Verwalter {
	 
 public static void main(String [] args){
	 try {
		 new Servera().start(); 													
	//	 new Chatter().start(); 													
	 }catch (Exception e){
		 	e.printStackTrace();
	 }
 	}
 }
 
 class Servera extends Thread{
 Chat_Frame frame;
 ServerSocket _ServerSocket = null;
 Socket _ClientSocket = null;
 PrintWriter _out = null;
 BufferedReader _in = null;
 
 
 	Servera() throws Exception{
 	_ServerSocket = new ServerSocket(4711);							
 }
 
 public void run(){
	 while(true){
		 try {
		 	_ClientSocket = _ServerSocket.accept(); 
		 	_out = new PrintWriter(_ClientSocket.getOutputStream(),true);
		 	_in = new BufferedReader(new InputStreamReader(_ClientSocket.getInputStream()));
		 	frame = new Chat_Frame("Chat :: Server", _out, _in);
	 while(true){
		 	String incoming = _in.readLine();
		 	frame.addAusgabe(incoming);
	 	} 
	}catch (IOException e){
		 		System.out.println("Fehler - ServerSocket.accept()");
	}
   }
  }
 }
