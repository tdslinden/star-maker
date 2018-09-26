import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.util.ArrayList;

// File: StarComponent
// Name: Linden Kyaw
// Student ID: 100263295

/**
   StarComponent creates the new Star objects where they are called to draw.
*/

public class StarComponent extends JComponent
{	
	private int y;
	private int x;
	private ArrayList<Star> outStars = new ArrayList<Star>();
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
	
		
		this.y = getHeight()/2; //will always be in the middle no matter the width and height of the frame
		this.x = getWidth()/2;
		
		Star bigStar = new Star(225, x, y);
		
		bigStar.draw(g2);
		
		int i;
		for(i = 0; i < 15; i++)
		{
			Star cascade = new Star(225-(i*15), x,y);
			cascade.draw(g2);
		}
		
		double theta = Math.toRadians(36);
		int k;
		for(k = 0; k < 10; k++)
		{	
			int a = (int)(x + (225 * Math.cos(theta)));//creates new x position
			int b = (int)(y + (225 * Math.sin(theta)));//creates new y position
			Star theStar = new Star(30, a, b);
			outStars.add(theStar);
			theta +=  Math.toRadians(36);//increase the angle
		}
		
		for(Star a : outStars)
		{
			a.draw(g2);
		}
	}
	
}