package lab5;

public class Triangle extends RegularPolygon {

	public Triangle(int sideLength) {
		super(3, sideLength);
	}
	
	@Override
	public double area() {
		return (Math.sqrt(3)/4)*(Math.pow(getSideLength(), 2));
	}

	
	
}
