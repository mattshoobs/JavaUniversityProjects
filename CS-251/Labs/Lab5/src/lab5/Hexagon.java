package lab5;

public class Hexagon extends RegularPolygon {

	public Hexagon(int sideLength) {
		super(6, sideLength);
		
	}
	
	@Override
	public double area() {
		return ((3*Math.sqrt(3))/2)*(Math.pow(getSideLength(), 2));
	}


}
