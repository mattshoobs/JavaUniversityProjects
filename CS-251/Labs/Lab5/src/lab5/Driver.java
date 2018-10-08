package lab5;
public class Driver {

	public static void main(String[] args) {
		
		System.out.println("Simple way to create objects, as you've seen before.");
		System.out.println("Area of each object is: ");
		
		//Below shows how to make objects of each type as you've seen before.
		
		//If you never used printf and are curious, read comments below, otherwise don't worry about printf too much for this lab.
		//printf is different way to print strings.  It is very useful for truncating decimals.
		//it reads as %[.decimal length][type], so %.4f means print float with 4 decimals after.
		//value after comma determines what gets printed, so below %.4f == t.area().
		//\t inserts tabs and \n inserts new lines for those not familiar with this.
		
		Triangle t = new Triangle(4);
		System.out.printf("Triangle area:\t%.4f", t.area());
		System.out.println();
		
		Square s = new Square(3);
		System.out.printf("Square area:\t%.4f", s.area());
		System.out.println();
		
		Hexagon h = new Hexagon(2);
		System.out.printf("Hexagon area:\t%.4f\n", h.area());

		
		System.out.println();
		System.out.println();

		
		//Below shows polymorphism, where we store a subclass in it's parent class.
		//Notice the benefits of this below in each loop.
		RegularPolygon[] polygons = new RegularPolygon[9];
		int count = 0;
		int value = 3;
		RegularPolygon tmpPolygon;
		
		while(count < polygons.length) {
			
			//using modulus operator to alternate between adding different polygons to array
			if(value % 3 == 0) {
				tmpPolygon = new Triangle(value++);
			} else if (value % 3 == 1) {
				tmpPolygon = new Square(value++);
			} else {
				tmpPolygon = new Hexagon(value++);
			}
			
			polygons[count++] = tmpPolygon;
		}
		
		System.out.println("An array containing triangles, squares, and hexagons has been created.");
		System.out.println("How can this be?  Polymorphism.  Output is below:\n");

		String classStr;
		
		//Dynmaic binding binds the method call of a class to an object.
		//So even though we save everthing as a RegularPolygon, it still rememember whether it is a Triangle, Square, or Hexagon.
		//That is why when we call area on each polygon in the array, we get the correct output for each polygon.
		for(RegularPolygon p: polygons) {
			
			//Typically when you call getClass, it returns "class + <class name>".
			//I am removing the "class" part for display purposes.
			classStr = p.getClass() + "";
			classStr = classStr.substring(classStr.indexOf(" ") + 1);
			
			System.out.println("Class:\t\t\t" + classStr);
			System.out.println("Number of sides:\t" + p.getNumSides());
			System.out.println("Side length:\t\t" + p.getSideLength());
			System.out.printf("Area:\t\t\t%.4f\n\n", p.area());

		}
		
	}
	
}
