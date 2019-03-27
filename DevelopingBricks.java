package GAMES;
import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class DevelopingBricks 
{
	public int rc[][],brickwidth,brickheight;
	
	 public DevelopingBricks(int row,int col)
		{
			rc=new int[row][col];
			for(int i=0;i<rc.length;i++)
				{
					for(int j=0;j<rc[0].length;j++)
						{
						rc[i][j]=1;
						}	
				}
			brickwidth=540/col;//650
			brickheight=150/row;//200
	}
	public void draw(Graphics2D g)
		{
			for(int i=0;i<rc.length;i++)
			{
				for(int j=0;j<rc[0].length;j++)
					{
					if(rc[i][j]>0)
						{
						g.setColor(Color.BLUE);
						g.fillRect(j*brickwidth+80,i*brickheight+50,brickwidth,brickheight);
						
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickwidth+80,i*brickheight+50,brickwidth,brickheight);
						
						}
					}	
			}
		}
	 public void setBrickValue(int value,int row,int col)
	 	{
		rc[row][col]=value;
	 	}
		
}
