package GAMES;
import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class BrickBreaker 
{
	public void brickbreaker()
	{
		JFrame ob=new JFrame();
		BreakBreaker bb=new BreakBreaker();
		ob.setBounds(350,80,700,600);
		ob.setTitle("BRICK BREAKER");
		ob.setVisible(true); 
		ob.setResizable(false);
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ob.add(bb);
	}
	public static void main(String s[])
	{
	BrickBreaker bb=new BrickBreaker();
		bb.brickbreaker();
	}
}
