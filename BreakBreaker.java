package GAMES;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class BreakBreaker extends JPanel implements KeyListener,ActionListener
{
	private int x=310;//350
	boolean play=false;
	Timer t;
	int score=0;
	static int highscore=0;
	private int totalBricks=21;
	private  int delay=1;
	private int bx=120;//370,350;
	private int by=350;//460,530;
	int ballx=-1;
	int bally=-2;
	DevelopingBricks mg;
	public BreakBreaker()
	{
		mg = new DevelopingBricks(3,7); 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
	    t = new Timer(delay,this);
	    t.start();
	}
	
	
	
	public void paint(Graphics g)
	{
	g.setColor(Color.BLACK);
	g.fillRect(1,1,692,592);//g.fillRect(1,1,807,600);
		
	mg.draw((Graphics2D)g);
	 
	g.setColor(Color.YELLOW);	
	g.fillRect(0,0,3,592);//g.fillRect(10,0,5,800);  //left
	g.fillRect(0,0,692,3);//g.fillRect(0,30,810,5);  //top
	g.fillRect(691,0,3,592);//g.fillRect(805,0,5,700);  //right
	
	g.setColor(Color.RED);
	g.setFont(new Font("Garmond",Font.BOLD,20));
	g.drawString("SCORE IS:"+score,500,30);
	
	g.setColor(Color.RED);
	g.setFont(new Font("Garmond",Font.BOLD,20));
	g.drawString("HIGHEST SCORE IS:"+highscore,200,30);
	
	
	g.setColor(Color.CYAN);	
	g.fillRect(x,550,100,8);//g.fillRect(x,580,60,10);
	
	if(score==210)
		{
		play=false;
		ballx=0;
		bally=0;
		highscore=210;
		g.setColor(Color.RED);
		g.setFont(new Font("Garmond",Font.BOLD,20));
		g.drawString("GAME FINISH",200,100);
		g.setFont(new Font("Garmond",Font.BOLD,20));
		g.drawString("YOU WON",200,200);
		g.setFont(new Font("Garmond",Font.BOLD,20));
		g.drawString("PRESS ENTER TO RESTART",200,300);
		g.setFont(new Font("Garmond",Font.BOLD,20));
		g.drawString("PRESS ESCAPE TO EXIT",200,400);

		}
	
	
	 if(by>570)
	 	{
		 play=false;
		ballx=0;
		bally=0;
		if(highscore < score)
			{
			highscore=score;
			}
		g.setColor(Color.RED);
		g.setFont(new Font("Garmond",Font.BOLD,20));
		g.drawString("GAME OVER YOUR SCORE IS:"+score,200,300);
		g.setFont(new Font("Garmond",Font.BOLD,20));
		g.drawString("PRESS ENTER TO RESTART",200,350);
		g.setFont(new Font("Garmond",Font.BOLD,20));
		g.drawString("PRESS ESCAPE TO EXIT",200,450);

	 	}
	g.setColor(Color.YELLOW);	
	g.fillOval(bx,by,20,20);//g.fillOval(bx,by,20,20);
	
	g.dispose();
	
	}
	
	
	public void actionPerformed(ActionEvent ae) 
		{
		t.start();
		if(play)
			{
			if(new Rectangle(bx,by,20,20).intersects(x, 550, 100,8))//intersects(x, 580, 60,10))
				{
				bally=-bally;
				}
			for(int i=0;i<mg.rc.length;i++)
				{
				for(int j=0;j<mg.rc[0].length;j++)
					{
					if(mg.rc[i][j]>0)
						{
						int brickx=j*mg.brickwidth+80;
						int bricky=i*mg.brickheight+50;
						int brickwidth=mg.brickwidth;
						int brickheight=mg.brickheight;
						
						Rectangle r1=new Rectangle(brickx,bricky,brickwidth, brickheight);
						Rectangle r2=new Rectangle(bx,by,20,20);
						Rectangle r3=r1;
						
						if(r2.intersects(r3))
							{
							mg.setBrickValue(0,i,j);
							totalBricks--;
							score+=5;
							
							if(bx+19<=r3.x || bx+1>=r3.x + r3.width)
								{
								ballx=-ballx;
								score+=5;
								}
							else
								{
								bally=-bally;
								score+=5;
								}
							}
						}
					}	
				}
			bx+=ballx;
			by+=bally;
			if(bx<0)//10
				ballx=-ballx;
			 else if(by<0)//30
				bally=-bally;
			 else if(bx>670)//780
				ballx=-ballx;
		
			}	
		repaint();
	}
	
	public void keyPressed(KeyEvent ke) 
		{
		if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
			{
			if(x>=600) //745
				x=600;
			else
				moveRight();
			}
		if(ke.getKeyCode()==KeyEvent.VK_LEFT)
			{
			if(x<=10)
				x=10;
			else
				moveLeft();
			}
		if(ke.getKeyCode()==KeyEvent.VK_ENTER)
			{
			if(!play)
				{
				play=true;
				bx=120;
				by=350;
				ballx=-1;
			    bally=-2;
			    x=310;
			    highscore=highscore;
			    score=0;
			    mg=new DevelopingBricks(3,7);
			    repaint();
				}	
			}
		if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
			{
			System.exit(0);
			}
		}
	
	public void moveRight()
	{
		play=true;
		x=x+20;
	}
	
	public void moveLeft()
	{
		play=true;
		x=x-20;
	}
	
	public void keyReleased(KeyEvent ke) {}
	public void keyTyped(KeyEvent ke) {}
	
public static void main(String s[])
	{
	BreakBreaker bb=new BreakBreaker();
	//bb.init();
	}

}
