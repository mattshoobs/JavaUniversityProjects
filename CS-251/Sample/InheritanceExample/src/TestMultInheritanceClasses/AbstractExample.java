package TestMultInheritanceClasses;

/**
 * Abstract class that provides some instance variables, some methods, and one abstract method.
 * An abstract class can provide many abstract methods.
 */

public abstract class AbstractExample {

	private int x;
	protected int y;
	
	public AbstractExample() {
		this(1,1);
	}
	
	public AbstractExample(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "x = " + x + ", y = " + y + " ";
	}
	
	public abstract int calcProdSum(int[] array);

}
