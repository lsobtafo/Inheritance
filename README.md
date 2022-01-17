# Inheritance
Introduction: This assignment will work with an inheritance hierarchy of shapes.  Information on shapes will be obtained from an input file that will be specified as a command line argument to your program.  This input file will contain sets of x-y coordinates for a two-dimensional shape composed of four lines.   More specifically the points should represent either a square, rectangle, or parallelogram.  You are guaranteed the first point is connected to the second, the second to the third, the third to the fourth, and the fourth to the first.  You are also guaranteed that there will be sufficient data to represent a shape (i.e there will be four sets of x-y coordinates).  It is your job to determine what shape the points represent (square, rectangle, or parallelogram).  It is possible that the points do not represent any of the three shapes.  In this case, you must throw an exception and write all the information (the points) about the invalid shape to an output file called shape_errors.txt (hard code this into your program).  Here is a sample input file (comments to the right won't be in actual file):

0.0        //x coord of first point
0.0        //y coord of first point
0.0        //x coord of second point
1.0        //y coord of second point
1.0        //etc.
1.0
1.0
0.0       
0.0        //next shape, x coord of first point
0.0       
-2.0
0.0
-2.0
-1.0
0.0
-1.0
1.0        //next "shape"
1.0
2.0
2.0
3.0
3.0
4.0
4.0
0.0       //next shape
0.0
1.0
1.0
4.0
1.0
3.0
0.0

After reading in shape information (or while reading the shape information if you wish), the shapes should be sorted alphabetically according to name.  If there is more than one of the same shape, sort by area of that shape from smallest to largest.  Once this is done, a menu should be displayed to the user that allows her to (a) print all information about each shape -- its name, its area, and its perimeter -- to an output file called shapes.out (hard code this into your program) (each time the user chooses to do this, the entire file should be rewritten), (b) print information about just one shape category (square, rectangle, or parallelogram) to the monitor, (c) quit.   

Requirements: Create FourSidedShape, Rectangle, Square, Parallelogram, ShapeException and ShapeTester classes.  Implement the Comparable<FourSidedShape> interface so you can compare shapes using compareTo

Specifications: Your solution must conform to the following specifications:

FourSidedShape should be an abstract base class with at least a data member to represent a shape name and methods to calculate the area and perimeter of the shape.  Constructor(s) and toString() methods should be used as you see fit.  You are welcome to add other items to this class if you feel it necessary/useful.
Parallelogram should extend FourSidedShape.  Add features to properly calculate the area and perimeter along with anything else you deem necessary.
Rectangle should extend Parallelogram.  Add features to properly calculate the area and perimeter along with anything else you deem necessary.
Square should extend Rectangle.  All sides of a square must be the same (and greater than 0) for the square to be valid.
ShapeException should extend some class in the Exception hierarchy.  It should be designed such that all information about the ShapeException that occurred is reported.
ShapeTester should contain a main method that drives the program.  Inside the main method you should:
invoke a method that opens the input file
invoke a method that reads the data from the input file -- exceptions should be reported as part of this process -- and places the data in an ArrayList of FourSidedShape
invoke a method to sort the shapes -- the sort you use is up to you but sort first by name then by area if the names are the same (ascending order of course)
print the shapes before and after sorting -- make sure and label each so it is clear to the user
This class should contain an ArrayList of FourSidedShape references.  The input file will contain at least one valid shape.
Design your code in as modular a fashion as possible.  You will be graded on this (in addition to everything else).
