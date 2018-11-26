package lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import lab11.FileParser;


public class FileParserDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner prompt = new Scanner(System.in);
		
		System.out.println("What is the name of the input file?");
		String inName = prompt.nextLine();
		
		System.out.println("What is the name of the output file?");
		String outName = prompt.nextLine();

		try(Scanner scr = new Scanner(new File("./docs/" + inName));
			PrintWriter pw = new PrintWriter("./docs/" + outName)) {
			while(scr.hasNextLine()) {
				String inLine = scr.nextLine();
				FileParser f = new FileParser(inLine);
				pw.println(f.parse());
			}
			System.out.print("File writing complete! \nThe output file is located in \"./docs/" + outName + "\"");
		} 
		catch (FileNotFoundException e) {
			System.out.print("File Not Found");
		}
		
		prompt.close();
	}

}
