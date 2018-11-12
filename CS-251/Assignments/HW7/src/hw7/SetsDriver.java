package hw7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import hw7.Sets;


public class SetsDriver {

	public static void main(String[] args) {
		List<Integer> a1 = new ArrayList<Integer>(4);
		for (int i = 0; i < 4; i++) {
			a1.add(i);
		}
		ArrayList<Integer> a2 = new ArrayList<Integer>(4);
		for (int i = 3; i > -1; i--) {
			a2.add(i);
		}
		ArrayList<Integer> a3 = new ArrayList<Integer>(4);
		for (int i = -2; i < 2; i++) {
			a3.add(i);
		}
		
		
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		for (int i = 0; i < 4; i++) {
			l1.add(i);
		}
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		for (int i = 3; i > -1; i--) {
			l2.add(i);
		}
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		for (int i = -2; i < 2; i++) {
			l3.add(i);
		}
		
		/** isEllement Tests **/
		System.out.println("isElement ArrayList test True");
		System.out.println(Sets.isElement(3, a1));
		
		System.out.println("isElement ArrayList test False");
		System.out.println(Sets.isElement(10, l1));
		
		System.out.println("isElement LinkedList test True");
		System.out.println(Sets.isElement(3, a1));
		
		System.out.println("isElement ArrayList test False");
		System.out.println(Sets.isElement(10, l1));
		
		
		/** isSubset Tests **/
		System.out.println("isSubset test True");
		System.out.println(Sets.isSubset(a1,l2));
		
		System.out.println("isSubset test False");
		System.out.println(Sets.isSubset(a1,l3));

		
		/** isSuperSet Tests **/
		System.out.println("isSuperSet test True");
		System.out.println(Sets.isSuperSet(l1,a2));
		
		System.out.println("isSuperSet test False");
		System.out.println(Sets.isSuperSet(l1,a3));
		
	
		/** union Tests **/
		System.out.println("union test -2,-1,0,1,2,3");
		System.out.println(Sets.union(a1,l3));
		
		
		/** intersection Tests **/
		System.out.println("intersection test 0,1");
		System.out.println(Sets.intersection(a1,l3));
		
		
		/** subtract Tests **/
		System.out.println("subtract test 2,3");
		System.out.println(Sets.subtract(a1,l3));
		
		
		/** equals Tests **/
		System.out.println("equals test True");
		System.out.println(Sets.equals(l1, a2));
		
		System.out.println("equals test False");
		System.out.println(Sets.equals(l3, l2));
		
		
		/** cartesianProduct Tests **/
		System.out.println("cartesianProduct test (0,0), (0,1), (0,2), (0,3), (1,0), (1,1), (1,2), (1,3), (2,0), (2,1), (2,2), (2,3), (3,0), (3,1), (3,2), (3,3)");
		System.out.println(Sets.cartesianProduct(l1, a1));
		
		
		/** sort Tests **/
		System.out.println("sort test (3,2,1,0)");
		Sets.sort(l2);
		System.out.print(l2);
		
		
	}

}
