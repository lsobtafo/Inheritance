package shapes;

import java.awt.geom.Point2D;

public class ShapeException extends Exception {
	public ShapeException(Point2D.Double one, Point2D.Double two, Point2D.Double three, Point2D.Double four)
	{
		super("Invalid shape\n" + one + "\n"+ two +"\n"+ three +"\n"+ four); //string with info about the points
	}	
	/*public ShapeException(Point one, Point two, Point three, Point four)

	{
		super();
		//throw new ShapeException();
		//if(one==three && two==four)
		//{
			
		//}
		//if()
		
	}*/

}
