package newgame;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import java.io.IOException;

public class Dialogue extends JFrame implements ActionListener{
	
private JButton weiter;
private JButton schliessen;
private JLabel text;
	
public static void main(String[] args){ 

frame Dialogue = new frame ("Weiser Zauberer");
}

public Dialogue(String title){
super(title);

setSize(250,250);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
setLayout(new BorderLayout());
setLayout(null);

text = new JLabel("Test");
text.setFont(new Font("Serif", Font.PLAIN, 36));
getContentPane().add(text);

weiter = new JButton("Weiter");
weiter.setBounds(170,95,150,80);
weiter.addActionListener(this);

schliessen = new JButton("Schlieﬂen");
schliessen.setBounds(170,265,150,80);
schliessen.addActionListener(this);

add(weiter);
add(schliessen);

}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub

if (e.getSource()==weiter)
	System.exit(0);

if (e.getSource()==schliessen)																// schliesst Menue
System.exit(0);
}
}
