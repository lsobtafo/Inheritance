package shapes;

//import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Rectangle extends Parallelogram
{
	private String name;
	public Rectangle(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four)//ArrayList<FourSidedShape> list
	{
		super(one, two, three, four, " Rectangle");
	}
	
	

	private double length, width;
	public String getName()
	{
		return this.name;
	}
	public double area()
	{
		return length*width;
	}
	/*public static boolean isRectangle(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four) {
		// TODO Auto-generated method stub
		return false;
	}*/
	public static boolean isRectangle(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four) {	
		Parallelogram.isParallelogram(one, two, three, four);
		if (rightAngle(one, two, three)==true&&rightAngle(two, three, four)==true
			&&rightAngle(three, four, one)==true&&rightAngle(four, one, two)==true) {
			return true;
		}
		
		return false;
	}
	
public static boolean rightAngle(Point2D.Double one, Point2D.Double two, Point2D.Double three) {
	//take dot product of points to check orthogonality 
	double res = ((two.x - one.x) * (two.x - three.x)) + ((two.y - one.y) * (two.y - three.y));
	if(res==0) {
		return true;
		}
	return false;
	}
	

}
