package TestMultInheritanceClasses;

/**
 * An interface that declares a static final variable and two methods.
 * Any class that implements this interface must override method1() and method2()
 * If they are not overriden, the class that implements this interface will be abstract also.
 */

public interface Inf1 {

	int n = 15;
	//public static final int n = 15;
	
	public abstract void method1();
	int method2(int x);

	
}
