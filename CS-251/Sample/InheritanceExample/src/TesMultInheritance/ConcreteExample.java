package TesMultInheritance;
import TestMultInheritanceClasses.AbstractExample;
import TestMultInheritanceClasses.Inf1;
import TestMultInheritanceClasses.Inf2;

/**
 * A concrete class that can be instantiated if all inherited abstract methods are overriden.
 */

public class ConcreteExample extends AbstractExample implements Inf1, Inf2  {

	private int z;
	
	public ConcreteExample() {
		this(1,1,1);
	}
	
	public ConcreteExample(int x, int y, int z) {
		super(x,y);
		setZ(z);
//		this.z = z;
//		setX(x);
//		this.y = y;
	}
	
	public int getZ() {
		return this.z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", z = " + z;
	}
	
	
	/**
	 * Inherited from AbstractExample, an abstract class
	 * This method must be overriden, if it wasn't ConcreteExample would also become an abstract class.
	 */
	@Override
	public int calcProdSum(int[] array) {
		int total = 0; 
		
		for(int i: array) {
			total = total + (i * z * getX() * y);
		}
		
		return total;
	}
	
	/**
	 * Method definition inherited from both Inf1 and Inf2 interfaces.
	 * Because method is abstract, no method body is provided. Means no ambiguity is created when calling method.
	 */
	public void method1() {
		System.out.println("In method1, which came from interface1.");
	}

	/**
	 * Method definition inherited from Inf1 only.
	 */
	public int method2(int x) {
		System.out.println("In method2 from interface1, x passed in is " + x);
		//ConcreteExample inherits a "x" instance variable from AbstractExample
		System.out.println("Don't confuse the x's: " + getX());
		return 0;
	}
	
	/**
	 * Method definition inherited from Inf2 only.
	 */
	public boolean method3(int z) {
		System.out.println("In method3 from interface2, z = " + z);
		if(z <= 0) {
			return false;
		}
		return true;
	}

}
