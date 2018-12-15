import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class File_IO {
	
	public static void main(String[] args) {
		readWrite("input.txt");
	}

	public static void readWrite(String inFile) {
		
		try (Scanner scr = new Scanner(new File(inFile)); 
			 PrintWriter pw = new PrintWriter(new File("outfile.txt"))	) {
			
			while (scr.hasNextLine()) {
				String line = scr.nextLine();
				
				pw.println(line);
			
			}
		} catch(FileNotFoundException e) {
			System.out.print("File Not Found!");
		}
		
		
	}
	
	
}
