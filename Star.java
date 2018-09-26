import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

// File: Star
// Name: Linden Kyaw
// Student ID: 100263295

/**
   A Star shape that can be positioned anywhere on the screen.
*/
public class Star
{	
	private int R = (int)(Math.random()*256);//creates random int between 0 - 256 for red
	private int G = (int)(Math.random()*256);//creates random int between 0 - 256 for green
	private int B = (int)(Math.random()*256);//creates random int between 0 - 256 for blue
		
	private final static double FACTOR = 2.63;
	private final static double ALFA = 18*Math.PI/180;
	private final static double BETA = 54*Math.PI/180;
	
	private final static double[] X = {0,Math.cos(BETA)/FACTOR, Math.cos(ALFA ),
                                            Math.cos(ALFA )/FACTOR,	Math.cos(BETA),0,
                                            -Math.cos(BETA),-Math.cos(ALFA)/FACTOR,
                                            -Math.cos(ALFA ),-Math.cos(BETA)/FACTOR,0};
                                            
	private final static double[] Y = {-1,-Math.sin(BETA)/FACTOR, -Math.sin(ALFA ),
                                            Math.sin(ALFA )/FACTOR,	Math.sin(BETA),1/FACTOR,
                                            Math.sin(BETA),Math.sin(ALFA )/FACTOR,
                                            -Math.sin(ALFA ),-Math.sin(BETA)/FACTOR,-1};
	
	private int[] xCoordOfStar; // x coordinates of the vertices of the star as pixel
	private int[] yCoordOfStar; // y coordinates of the vertices of the star as pixel			
					    
	 /**
	Creates a star object that passes the parameters to setStarCoordinates
	@param radius, the length in pixel of each arm of the star from its center 
	@param x the x coordinate of the center of the star
	@param y the y coordinate of the center of the star
	*/
					    
	public Star(double r, double x, double y)
	{
		setStartCoordinates(r, x, y);
	}
			
	 /**
	Calculates the coordinates of a 5 points star 
	@param radius, the length in pixel of each arm of the star from its center 
	@param x the x coordinate of the center of the star
	@param y the y coordinate of the center of the star
	*/
	
	public void setStartCoordinates(double radius , double x, double y){
		
		xCoordOfStar= new int[X.length];
		yCoordOfStar= new int[Y.length];
		int i; 
		for (i=0; i<X.length; i++){
			xCoordOfStar[i] = (int)(radius*X[i]+x);
			yCoordOfStar[i] = (int)(radius*Y[i]+y);
		}	
	}
	
	 /**
	The draw method that contains the drawing instructions
	@param Graphics2D g2, the drawing component
	*/
	
	public void draw(Graphics2D g2)
	{
		int i;
		for(i = 1; i < X.length; i++)
		{
			Point2D.Double from = new Point2D.Double(xCoordOfStar[i-1], yCoordOfStar[i-1]);//sets the start point
			Point2D.Double to = new Point2D.Double(xCoordOfStar[i], yCoordOfStar[i]);//sets the end point
			g2.setStroke(new BasicStroke(4));//line width is 4
			g2.setColor(new Color(R, G, B));//sets the line colour to a new colour
			Line2D.Double segment = new Line2D.Double(from,to);//creates the line from the two set points
			g2.draw(segment);
			g2.setColor(new Color(R, G, B));//sets new colour
			g2.fillPolygon(xCoordOfStar, yCoordOfStar, 10);//fills the polygon with a colour
		}	
	}

}
