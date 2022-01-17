package shapes;

import java.util.ArrayList;
import java.awt.geom.Point2D;

public class Square extends Rectangle {
	//In collaboration with Jessica, Samuel, Marc and Moses
	private String name;
	private double sidelength;
	public Square(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four)
	{
		//this.name = name;
		super(one, two, three, four);//"Square"
		this.name = name;
	}
	private double base, otherSide, height;
	
	public String getName()
	{
		return this.name;
	}
	public double area()
	{
		//this.height = (Math.pow(this.otherSide,2))+Math.pow(a, b);
		//return 2*this.sidelength;
		//formula is (1/2)(a+b+c+d)
		
		return sidelength*sidelength;
	}
	
	public static boolean isSquare(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four) {
		// TODO Auto-generated method stub
		if((sameLength(one, two, three, four))==true)
		{
			return true;
		}
		return false;
	}
	static double distSq(Point2D.Double one, Point2D.Double two) 
	{ 
	    return (one.getX() - two.getX()) * (one.getX() - two.getX()) + (one.getY() - two.getY()) * (one.getY() - two.getY()); 
	} 
	public static boolean sameLength(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four)
	{
		//double sideOneTwo = new double((two.getX()-one.getX()),(two.getY()-one.getY()));
		double distance2 = distSq(one, two); // from p1 to p2 
	    double distance3 = distSq(one, three); // from p1 to p3 
	    double distance4 = distSq(one, four); // from p1 to p4 
	  
	    // If lengths if (p1, p2) and (p1, p3) are same, then 
	    // following conditions must met to form a square. 
	    // 1) Square of length of (p1, p4) is same as twice 
	    // the square of (p1, p2) 
	    // 2) Square of length of (p2, p3) is same 
	    // as twice the square of (p2, p4) 
	    if (distance2 == distance3 && 2 * distance2 == distance4 
	            && 2 * distSq(two, four) == distSq(two, three)) 
	        { 
	            return true; 
	        } 
	      
	        // The below two cases are similar to above case 
	        if (distance3 == distance4 && 2 * distance3 == distance2 
	            && 2 * distSq(three, two) == distSq(three, four))  
	        { 
	            return true; 
	        } 
	        if (distance2 == distance4 && 2 * distance2 == distance3 
	            && 2 * distSq(two, three) == distSq(two, four)) 
	        { 
	            return true; 
	        } 
	      
	        return false; 
	}
	

}
