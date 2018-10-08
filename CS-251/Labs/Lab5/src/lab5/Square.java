package lab5;

public class Square extends RegularPolygon {

	public Square(int sideLength) {
		super(4, sideLength);
		
	}
	
	@Override
	public double area() {
		return Math.pow(getSideLength(), 2);
	}


	
}
