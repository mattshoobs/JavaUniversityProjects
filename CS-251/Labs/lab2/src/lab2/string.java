package lab2;
import java.util.Scanner; 

public class string {
	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);
	
		System.out.println("Enter Two intgers and a string seperated by colons. ie: 2:5:programming ");
		String input = scr.nextLine(); 
		input = input.trim();
		
		//if char at loop
		
		//empty string, check multiple colons, use char.at
		//import the class scanner, create a scanner object, call the method.
		//int numcol = 0;
		//int col1 = 0;
		//for(int i = 0; i < input.length;i++) {
			//if (charAt(i) == ':')
				//col1 = i;
				//numcol ++; 
		//}
		
		
		if (input == "") {
			error(scr);
			return;
		}
			
		int col1 = input.indexOf(":",0);
		int col2 = input.indexOf(":",col1+1);
		int col3 = input.indexOf(":",col2+1);
		
		if (col1 == -1 || col2 == -1 || col3 != -1) {
			error(scr);
			return;
		}
		
		String num1str = input.substring(0,col1);
		num1str = num1str.trim();
		int num1 = Integer.parseInt(num1str);
		
		String num2str = input.substring(col1+1,col2);
		num2str = num2str.trim();
		int num2 = Integer.parseInt(num2str);
		
		String word = input.substring(col2 + 1);
		word = word.trim();
		
		if (num1 < 0 || num2 < 0 || num1 > word.length() || num2 > word.length() || num1 > num2) {
			error(scr);
			return;
		}
		
		String subWord = word.substring(num1,num2);
		System.out.println(subWord);
		scr.close();		
	}
	
	private static void error (Scanner scr) {
			System.out.println("Error - incorrect format!");
			scr.close();
		}
	
	}
	
