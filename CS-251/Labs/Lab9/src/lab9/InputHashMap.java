package lab9;

import java.util.HashMap;
import java.util.Scanner;


public class InputHashMap {

	public static void inputHashMap() {
		
		Scanner reader = new Scanner(System.in);
		HashMap<String,Integer> input = new HashMap<String,Integer>();
		boolean run = true;
		System.out.println("\nWelcome! We are using a HashMap to store User Input.");
		
		while (run) {
			System.out.println("\nEnter some text or (quit) to stop: ");
			String userInput = reader.next().toLowerCase();
			
			if (userInput.equalsIgnoreCase("quit")) {
				run = false;
				System.out.println("Goodbye!");
				break;
			}
			if (input.containsKey(userInput)) {
				input.put(userInput,(input.get(userInput)+1));
			}
			else {
				input.put(userInput,1);
			}
			
			System.out.println("You have entered \"" + userInput + "\" " + input.get(userInput) + " time(s).");	
		}	
		reader.close();
	}		
}
