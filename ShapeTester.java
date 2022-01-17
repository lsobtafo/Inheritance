package tester;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import shapes.Point;
import shapes.Rectangle;
import shapes.ShapeException;
import shapes.Square;
import shapes.FourSidedShape;
import shapes.Parallelogram;

public class ShapeTester 
{
	static ArrayList<FourSidedShape> list = new ArrayList<FourSidedShape>();
	private static PrintStream output;
	private static ArrayList<Double> coordArray;
	private static ArrayList<FourSidedShape> shapeArray;
	private static ArrayList<FourSidedShape> squareArray;
	private static ArrayList<FourSidedShape> rectangleArray;
	private static ArrayList<FourSidedShape> paraArray;
	public static void main(String [] args) throws FileNotFoundException, ShapeException
	{
		PrintStream errorFile = new PrintStream(new File("shape_errors.txt"));
		Scanner kb = new Scanner(System.in);
		shapeArray = new ArrayList<FourSidedShape>();
		squareArray = new ArrayList<FourSidedShape>();
		rectangleArray = new ArrayList<FourSidedShape>();
		paraArray = new ArrayList<FourSidedShape>();
		if(args.length == 0)
		{
			System.out.println("No file name specified as a common line argument.");
			System.out.println("Usage : java shapeTester file_name.txt");
			
		}
		try {
			Scanner input = new Scanner(new File("shapes.txt"));
			errorFile =new PrintStream("shape_errors.txt");
			readShapes(input);
			menu(kb);
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
			printShapes(shapeArray);
			selectionSort(shapeArray);
			menu(kb);
		}
	}
	public static void menu(final Scanner kb) throws FileNotFoundException
	{
		//if(kb == null)
			//throw new IllegalArgumentException("Bad Scanner in menu");
    //int choice;
		
		//do
		//{
			System.out.println("Please choose one of the options below");
			System.out.println("Option 1: Print all the shapes to an output File");
			System.out.println("Option 2: Print all Squares to the screen");
			System.out.println("Option 3: Print all Rectangles to the screen");
			System.out.println("Option 4: Print all Parallelograms to the screen");
			System.out.println("Option 5: Quit");
			int choice = 0;
			do
			{
				System.out.print("Choice: ");
				choice = Integer.parseInt(kb.nextLine());
			}while(1>choice || choice>5);
			
			do{
				switch(choice) {
			
				case 1: printToFile(shapeArray);
				break;
				
				case 2: printShapeType(choice, shapeArray); 
				break;
				
				case 3: printShapeType(choice, shapeArray);
				break;
				
				case 4: printShapeType(choice, shapeArray);
				break;
				
				default: System.out.println("Goodbye.");
				}
				do
				{
					System.out.print("Choice -->");
					choice = Integer.parseInt(kb.nextLine());
				}while(1>choice || choice>5);
			}while (choice!=5);
			
			
		
		
		//System.out.println();

		// choice;
	}

	
	public static void readShapes(Scanner inputFile) throws ShapeException, FileNotFoundException
	{
		//Point one ,two,three,four;
		PrintStream errorFile = new PrintStream(new File("shape_errors.txt"));
		Point2D.Double one, two, three, four;

		while(inputFile.hasNextDouble()) {
			try
			{
				one = new Point2D.Double(inputFile.nextDouble(),inputFile.nextDouble());
				two = new Point2D.Double(inputFile.nextDouble(),inputFile.nextDouble());
				three = new Point2D.Double(inputFile.nextDouble(),inputFile.nextDouble());
				four = new Point2D.Double(inputFile.nextDouble(),inputFile.nextDouble());
				
				if (Square.isSquare(one, two, three, four)) {
					Square newSquare = new Square(one, two, three, four);
					shapeArray.add(newSquare);
				}
				
				if (Rectangle.isRectangle(one, two, three, four)) {
					Rectangle newRectangle = new Rectangle(one, two, three, four);
					shapeArray.add(newRectangle);
				}
				
				if (Parallelogram.isParallelogram(one, two, three, four)) {
					Parallelogram newParallelogram = new Parallelogram(one, two, three, four);
					shapeArray.add(newParallelogram);
				}
				
				else {
					throw new ShapeException(one, two, three, four);
				}
				
				}catch(ShapeException e)
				{errorFile.println(e.getMessage());
				}
			
			
		}
	}
	public static void readFile(Scanner input) {
		while(input.hasNextDouble()) {
			coordArray.add(input.nextDouble());
		}input.close();
	}
	public static void selectionSort(ArrayList<FourSidedShape> array) {
		if(array==null||array.size()<2)
		{
			return;
		}
		int start, smallest, cur;
		FourSidedShape temp;
		for(start=0; start<array.size()-1;start++)
		{
			smallest = start;
		
		for(cur=start+1; cur<array.size();cur++)
		{
			if(array.get(cur).compareTo(array.get(smallest))<0)
				smallest = cur;
			
		}
		temp = array.get(start);
		array.set(start,array.get(smallest));
		array.set(smallest,temp);
		}
	}
	private static void printToFile(ArrayList<FourSidedShape> shapeArray) throws FileNotFoundException{ 
		PrintStream output = new PrintStream(new File("output.txt"));
		for(FourSidedShape x: shapeArray) {
		            output.println(x.getName());
		            output.println("Area: " + x.area() + "\n");
		            output.println("Perimeter" + x.perimeter()+ "\n");
		}
		output.close();
	}
	private static void printShapes(ArrayList<FourSidedShape>array) throws FileNotFoundException
	{
		output = new PrintStream("shapes.out");
		System.setOut(output);
		for(FourSidedShape i: shapeArray) {
			System.out.println(i.getName());
			System.out.println(i.area());
			System.out.println(i.perimeter());
		}
		System.out.println(shapeArray);
	}
	public static void printShapeType(int choice, ArrayList<FourSidedShape> shapeArray) {
		if(choice==2) {
			for(int x=0; x<shapeArray.size(); x++) {
				if(shapeArray.get(x) instanceof Square) {
					System.out.println(shapeArray.get(x));
				}
			}
		}
		if(choice==3) {
			for(int x=0; x<shapeArray.size(); x++) {
				if((shapeArray.get(x) instanceof Rectangle) && !(shapeArray.get(x) instanceof Square)){
					System.out.println(shapeArray.get(x));
				}
			}
		}
		if(choice==4) {
			for(int x=0; x<shapeArray.size(); x++) {
				if((shapeArray.get(x) instanceof Parallelogram) && !(shapeArray.get(x) instanceof Rectangle) && !(shapeArray.get(x) instanceof Square)) {
					System.out.println(shapeArray.get(x));
				}
			}
		}
	}
	public static void printArray(ArrayList<FourSidedShape> array) {
		for(int i = 0; i < array.size(); i++) {  
		   System.out.print(array.get(i));
		}  
	}
	


	}



