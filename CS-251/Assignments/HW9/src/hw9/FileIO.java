package hw9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FileIO {

	/**
	 * Open inFile for reading and outFile for writing. Print out each character 5
	 * times if it is NOT a space, period, comma, question mark, or exclamation
	 * point. If it is any of these characters, it only gets printed once. See
	 * output example given.
	 * 
	 * @param inFile
	 * @param outFile
	 */
	public static void stretch(String inFile, String outFile) {
		System.out.println("stretch opening files " + inFile + ", " + outFile);

		try (Scanner scr = new Scanner(new File("./docs/" + inFile));
				PrintWriter pw = new PrintWriter("./docs/" + outFile)) {
			while (scr.hasNextLine()) {
				String inLine = scr.nextLine();

				for (int i = 0; i < inLine.length(); i++) {
					char c = inLine.charAt(i);
					if (!(c == '!' || c == ',' || c == '.' || c == '?' || Character.isSpaceChar(c))) {
						for (int r = 1; r <= 5; r++) {
							pw.print(c);
						}

					}

					else {
						pw.print(c);
					}
				}
				pw.println("");
			}
			System.out.print("File writing complete! \nThe output file is located in \"./docs/" + outFile + "\"\n");
		} catch (FileNotFoundException e) {
			System.out.print("File Not Found");
		}

		System.out.println("stretch finished");
	}

	/**
	 * Open inFile for reading and outFile for writing. inFile is supposed to
	 * contain only whole integers, but sometimes they don't. Read all numbers, sort
	 * them in increasing order, and write them to the output file. You will need to
	 * finish sortNumbers to help sort your numbers. If you a read a line that is
	 * not an int or is not a number, your program must not crash. Instead, ignore
	 * this line. See output example given.
	 * 
	 * @param inFile
	 * @param outFile
	 */
	public static void sortNumbers(String inFile, String outFile) {
		System.out.println("sortNumbers opening files " + inFile + ", " + outFile);

		try (Scanner scr = new Scanner(new File("./docs/" + inFile));
				PrintWriter pw = new PrintWriter("./docs/" + outFile)) {

			ArrayList<Integer> numList = new ArrayList<Integer>();

			while (scr.hasNextLine()) {

				String inLine = scr.nextLine();

				try {
					int x = Integer.parseInt(inLine);

					numList.add(x);

				} catch (NumberFormatException e) {

				}
			}

			sortNumbers(numList);

			for (Integer i : numList) {
				pw.println(i);
			}

			System.out.print("File writing complete! \nThe output file is located in \"./docs/" + outFile + "\"\n");
		} catch (FileNotFoundException e) {
			System.out.print("File Not Found");
		}

		System.out.println("sortNumbers finished");

	}

	/**
	 * Open inFile for reading and outFile for writing. This is a method that counts
	 * all occurrences of all words in a file. When done, output each word found and
	 * its count to the output file in sorted order. You will need to call sortWords
	 * to help sort your words at the end. After writing all words, give the total
	 * count of words for all words in the file. See output example given.
	 * 
	 * @param inFile
	 * @param outFile
	 */
	public static void wordCount(String inFile, String outFile) {
		System.out.println("wordCount opening files " + inFile + ", " + outFile);

		try (Scanner scr = new Scanner(new File("./docs/" + inFile));
				PrintWriter pw = new PrintWriter("./docs/" + outFile)) {

			HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
			ArrayList<String> totalWords = new ArrayList<String>();

			while (scr.hasNextLine()) {
				String inLine = scr.nextLine();

				inLine = inLine.toLowerCase();
				inLine = inLine.replace('!', ' ');
				inLine = inLine.replace('.', ' ');
				inLine = inLine.replace(',', ' ');
				inLine = inLine.replace('?', ' ');

				String[] words = inLine.split(" ");

				for (int i = 0; i < words.length; i++) {

					if (wordCounts.containsKey(words[i])) {
						wordCounts.put(words[i], wordCounts.get(words[i]) + 1);
					} else {
						wordCounts.put(words[i], 1);
						totalWords.add(words[i]);
					}
				}

			}

			sortWords(totalWords);
			int wordTotal = 0;
			for (String s : totalWords) {
				pw.println(s + ": " + wordCounts.get(s));
				wordTotal += wordCounts.get(s);
			}
			pw.println("Total Words: " + wordTotal);

			System.out.print("File writing complete! \nThe output file is located in \"./docs/" + outFile + "\"\n");
		} catch (FileNotFoundException e) {
			System.out.print("File Not Found");
		}

		System.out.println("wordCount finished");
	}

	/**
	 * Open inFile1 and inFile2 for reading and outFile for writing. The contents of
	 * inFile1 and inFile2 will contain a list of numbers and names in the following
	 * format.
	 * 
	 * <File> <id>:<name> <id>:<name> <id>:<name> and so on.
	 * 
	 * Assume the files are always in this format, and the ids are always sorted in
	 * increasing order. Assume each file does not contain duplicates with in their
	 * file. You do NOT need to verify the file is in the correct format. You do NOT
	 * need to sort anything, they should already be sorted. Perform the merge of
	 * the two lists and write out the contents to the output file. A merge is
	 * exactly the same as a union. All <id>:<name> from each file should be merged
	 * into one file. If a duplicate <id>:<name> occurs in both files, only one
	 * <id>:<name> is written to the output file.
	 * 
	 * Merge example
	 * 
	 * inFile1.txt inFile2.txt 2:Nate 4:Alan 4:Alan 12:Chelsea 15:Kristin 18:Valory
	 * 
	 * mergeOutput.txt 2:Nate 4:Alan 12:Chelsea 15:Kristin 18:Valory
	 * 
	 * Also see output example given.
	 * 
	 * @param inFile
	 * @param outFile
	 */
	public static void mergeFileContents(String inFile1, String inFile2, String outFile) {
		System.out.println("merge opening file " + inFile1 + ", " + inFile2 + ", " + outFile);

		try (Scanner scr = new Scanner(new File("./docs/" + inFile1));
				Scanner scr2 = new Scanner(new File("./docs/" + inFile2));
				PrintWriter pw = new PrintWriter("./docs/" + outFile)) {

			HashMap<Integer, String> endMerge = new HashMap<Integer, String>();
			ArrayList<Integer> allIds = new ArrayList<Integer>();

			while (scr.hasNextLine()) {
				String inLine = scr.nextLine();
				String[] lineSplit = inLine.split(":");

				int id = Integer.parseInt(lineSplit[0]);
				String tmpName = lineSplit[1];

				if (endMerge.containsKey(id)) {
					// no need to add, already exists

				} else {
					endMerge.put(id, tmpName);
					allIds.add(id);
				}
			}

			while (scr2.hasNextLine()) {
				String inLine2 = scr2.nextLine();
				String[] lineSplit2 = inLine2.split(":");

				int id2 = Integer.parseInt(lineSplit2[0]);
				String tmpName2 = lineSplit2[1];

				if (endMerge.containsKey(id2)) {
					// no need to add, already exists

				} else {
					endMerge.put(id2, tmpName2);
					allIds.add(id2);
				}

			}

			sortNumbers(allIds);

			for (int i : allIds) {
				pw.println(i + ":" + endMerge.get(i));
			}

			System.out.print("File writing complete! \nThe output file is located in \"./docs/" + outFile + "\"\n");
		} catch (FileNotFoundException e) {
			System.out.print("File Not Found");
		}

		System.out.println("merge finished");
	}

	/**
	 * Sort list from smallest to largest numbers.
	 * 
	 * @param list
	 */
	public static void sortNumbers(List<Integer> list) {

		Collections.sort(list);

	}

	/**
	 * Sort list alphabetically, meaning a - z
	 * 
	 * @param list
	 */
	public static void sortWords(List<String> list) {

		Collections.sort(list);

	}

}
