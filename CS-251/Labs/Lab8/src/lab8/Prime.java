package lab8;

import java.util.ArrayList;

public class Prime {
	
	public static void create(int size) {
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		for (int i = 2; i <= size; i++) {
			data.add(i);
		}
		System.out.print("Initial: " + data + "\n");
		findPrime(data);
	}
	
	public static void findPrime (ArrayList<Integer> data) {
		
		int n = data.size();
		int x = 2;
		while (x < n/2) {
			for(int i = 0; i < data.size();i++) {
				
				if((data.get(i)!= x) && ((data.get(i) % x) == 0)) {
					
						data.remove(i);
					
				}
			
			}
			
			System.out.print("Phase #" + (x-1) +":" + data +"\n");
			x++;
		}
		
	}
	
	
	
}
