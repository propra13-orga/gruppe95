package newgame;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;

 
/*
 * Zwei Textfelder fuer die Eingabe und fuer die Ausgabe werden erzeugt.<<<<<<
 */
 public class Chat_Frame extends JFrame{
 TextArea _Eingabe;										
 TextArea _Ausgabe;
 JButton   _Send;
 

 PrintWriter _out;
 BufferedReader _in;
 ActionListener  _x;
 
 Chat_Frame(String Titel,PrintWriter out, BufferedReader in){
	 _out = out;
	 _in = in;
	 init(Titel);
 }
 
 void init(String Titel){
	 setSize(500,400);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setLocationRelativeTo(null);
	 setVisible(true);
	 
	 this.setTitle(Titel);
	 	_Eingabe = new TextArea();
	 	_Ausgabe = new TextArea();
	 	_Send = new JButton();
	 	_x = new Action(_out, _in, _Eingabe);
	 	_Send.setText("Abschicken");
	 	_Send.setActionCommand("Send");
	 	_Send.addActionListener(_x);
	 	
	 this.setLayout(new BorderLayout());
	 	Container unten = new Container();
	 	unten.setLayout(new BorderLayout());
	 	unten.add(_Eingabe,BorderLayout.CENTER);
	 	unten.add(_Send, BorderLayout.EAST);
	 	this.add(unten,BorderLayout.SOUTH);
	 	this.add(_Ausgabe,BorderLayout.CENTER);
 }
 
/*
 * Methode fuer die Ausgabe der Nachricht des Empfaengers
 */

 	public void addAusgabe(String add){
 	
 		String temp = _Ausgabe.getText()+"\r\nAsma:  ";
 		temp += add;
 		_Ausgabe.setText(temp);
 	
 	}
 }	
 
 class Action implements ActionListener{
 PrintWriter _out;
 BufferedReader _in;
 TextArea _Eingabe;
 TextArea _Ausgabe;


 
 Action(PrintWriter out, BufferedReader in, TextArea Text){
 _out = out;
 _in = in;
 _Eingabe = Text;
 _Ausgabe = Text;
 
}

 /*
  * Das was eingegeben wird, wird als Ausgabe empfangen.
  * 
  */

 public void actionPerformed(ActionEvent arg0) {			
	
	 if(arg0.getActionCommand().equals("Send")){									
		 String Ausgabe = _Eingabe.getText()+" \r\n";
		 _out.print(Ausgabe);
		 _out.flush();
	
	 }

 	}
 }
