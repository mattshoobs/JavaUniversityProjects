package lab5;

public class RegularPolygon {

	private int numSides;
	private int sideLength;
	
	public RegularPolygon(int numSides, int sideLength) {
		this.numSides = numSides;
		this.sideLength = sideLength;
		
	}

	public int getNumSides() {
		return this.numSides;
	}

	public int getSideLength() {
		
		return this.sideLength;
	}
	
	public double perimeter() {
		return this.sideLength * this.numSides;
	}
	
	public double area() {
		return 0;
	}
	
}
