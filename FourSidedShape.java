package shapes;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

//import java.awt.Shape;
//In collaboration with Jessica, Samuel, Marc and Moses

public abstract class FourSidedShape implements Comparable<FourSidedShape>{
	private String name;
	private double sidelength;
	protected Point2D.Double one,two,three,four;
	protected String shape ;
	protected FourSidedShape(Double one, Double two, Double three, Double four,String name)
	{
		this.name = name;
		this.sidelength = sidelength;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.shape = shape;
		
	}
	public String getName()
	{
		return this.name;
	}
	public double area()
	{
		return 2*this.sidelength;//formula is (1/2)(a+b+c+d)
	}
	public int compareTo(FourSidedShape that)
	{
		if(that==null)
			throw new IllegalArgumentException("Bad param in compareTo");
		if(this.name.compareTo(that.name)>0)
			return 1;
		if(this.name.compareTo(that.name)<0)
			return -1;
		if(this.area()>that.area())
			return 1;
		if(this.area()>that.area())
			return -1;
		return 0;
		
	}
	public double perimeter(){
		return sidelength*4;
	}
	@Override
	public String toString ()
	{
		String str = "Name: " + name + "\nArea: " + area() + "\nPerimeter: " + perimeter();
		return str;
		
	}
	

}
