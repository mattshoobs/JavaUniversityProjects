package TesMultInheritance;

import TestMultInheritanceClasses.Inf1;

public class MultInherDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ConcreteExample mi = new ConcreteExample(1,2,3);
		System.out.println(mi);
		
		int[] arr = {1,2,3,4,5};
		//Call overriden abstract method in ConcreteExample ojbect that was inherited from AbstractExample
		System.out.println("CalcProdSum = " + mi.calcProdSum(arr));
		
		System.out.println();
		System.out.println("Static variable from interface1: " + Inf1.n);
		System.out.println();
		
		//Call overriden abstract method in ConcreteExample object that was inherited from both interfaces.
		mi.method1();
		
		System.out.println();
		//Call overriden abstract method in ConcreteExample object that was inherited from Inf1.
		System.out.println("Value return from method m1 is: " + mi.method2(1000));
		System.out.println();

		//Call overriden abstract method in ConcreteExample object that was inherited from Inf2.
		if(mi.method3(-10)) {
			System.out.println("Value was positive.");
		} else {
			System.out.println("Value was negative.");
		}
		
		if(mi.method3(25)) {
			System.out.println("Value was positive.");
		} else {
			System.out.println("Value was negative.");
		}
				
	}

}
