package TestMultInheritanceClasses;

/**
 * An interface that declares a static final variable and two methods.
 * Any class that implements this interface must override method1() and method3()
 * If they are not overriden, the class that implements this interface will be abstract also.
 */

public interface Inf2 {

	void method1();
	boolean method3(int z);
	
}
