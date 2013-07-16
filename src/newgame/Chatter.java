
		package newgame;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



 
 public class Chatter extends Thread{
 Chat_Frame frame;
 Socket _Socket = null;
 PrintWriter _out = null;
 BufferedReader _in = null;
 Scanner _keyboard = new Scanner(System.in);

	 			
 				Chatter(){

 
	 					try{
	 						_Socket = new Socket("10.84.24.91", 4711);// 192.168.2.110, "localhost",4711
	 						_out = new PrintWriter(_Socket.getOutputStream(), true);
	 						_in = new BufferedReader(new InputStreamReader(_Socket.getInputStream()));
	 						frame = new Chat_Frame("Chat :: Client", _out, _in);
	 					}catch(Exception e){
	 						System.exit(1);
	 			} // catch
 } //Chatter

 public void run(){
	 		while(true){
	 			String incoming;
	 					try{
	 						incoming = _in.readLine();
	 						frame.addAusgabe(incoming);
	 					}catch (IOException e){
	 						e.printStackTrace();
	 					 }
	 		} //while
	 			  //} // run()
	 	}

 }

