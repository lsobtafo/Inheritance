package shapes;

import java.util.ArrayList;
import java.awt.geom.Point2D;
//import java.awt.geom.Point2D.Double;



public class Parallelogram extends FourSidedShape
{
	//In collaboration with Jessica, Samuel, Marc and Moses
	private String name;
	public Parallelogram(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four)
	{
		super(one, two, three,four,"Parallelogram");
		this.name = name;
	}
	
	protected Parallelogram(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four, String name) {
		super(one, two , three, four, name);
	}

	



	private double base, otherSide, height;
	
	public String getName()
	{
		return this.name;
	}
	@Override
	public double area()
	{
		//this.height = (Math.pow(this.otherSide,2))+Math.pow(a, b)
		//return 2*this.sidelength;
		//formula is (1/2)(a+b+c+d)
		return base*height;
	}
	public static boolean isParallelogram(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four)
	{
		if(slope(one, two, three, four)==true)
		{
			return true;
		}
		
		return true;
	}
	
	
	public static boolean slope (Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four) {
		double oneTwo = (one.getY()-two.getY())/(one.getX()-one.getX());
		double twoThree = (three.getY()-two.getY())/(three.getX()-two.getX());
		double threeFour = (four.getY()-three.getY())/(four.getX()-three.getX());
		double fourOne = (one.getY()-four.getY())/(one.getX()-four.getX());
		if(oneTwo==threeFour&&twoThree==fourOne)
		{
			return true;
		}
		return false;
		
	}
	@Override
	public double perimeter() {
		return (one.distance(two)*2)+(two.distance(three)*2);
	}
	

}
