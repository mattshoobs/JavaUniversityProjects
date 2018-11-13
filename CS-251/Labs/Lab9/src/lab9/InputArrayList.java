package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class InputArrayList {
	
	public static void inputArrayList() {
	
		Scanner reader = new Scanner(System.in);
		ArrayList<String> input = new ArrayList<String>();
		boolean run = true;
		System.out.println("\nWelcome! We are using an ArrayList to store User Input.");
		
		while (run) {
			System.out.println("\nEnter some text or (quit) to stop: ");
			String userInput = reader.next();
			int count = 0;	
			if (userInput.equalsIgnoreCase("quit")) {
				run = false;
				System.out.println("Goodbye!");
				break;
			}
			
			input.add(userInput);
			
			for (String s : input) {
				if(userInput.equalsIgnoreCase(s)) {
					count++;
				}
			}
			System.out.println("You have entered \"" + userInput + "\" " + count + " time(s).");	
		}
	}
}
