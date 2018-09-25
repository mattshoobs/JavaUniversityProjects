package cs251_HW2;

import java.util.Scanner;

public class DateConversion {

	// Static variable you can use throughout this class
	// contains the months in shorter form
	private static String[] abbrMonths = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov",
			"dec" };

	// Another static variable you can use, except these contain the months fully
	// spelled out
	private static String[] fullNameMonths = { "january", "february", "march", "april", "may", "june", "july", "august",
			"september", "october", "november", "december" };

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);

		System.out.println("Welcome to the CS251 Date Converter!\n");

		String dateEntries = null;

		while (true) {
			System.out.print("Enter line of dates:");
			dateEntries = stdIn.nextLine();

			// TODO
			if (dateEntries != "") {
				break;
			}
			System.out.println("Please enter a Date.\n");
		}

		String[] dates = dateEntries.split("and");

		for (int dateCount = 0; dateCount < dates.length; dateCount++) {
			String dateStr = dates[dateCount].trim();
			System.out.print("Date " + dateCount + ": ");

			if (dateStr.matches("[0-9]{1,2}[\\s]*[-]+[\\s]*[0-9]{1,2}[\\s]*[-]+[\\s]*[0-9]{4}[-]*")) {
				parseAllNumbers(dateStr);

			} else if (dateStr.matches("[a-z|A-Z]{3,9}[\\s]*[0-9]{1,2},[\\s]*[0-9]{4}")) {
				parseMonthFirst(dateStr);
			} else if (dateStr.matches("[0-9]{1,2}[\\s]+[a-z|A-Z]{3,9}[\\s]+[0-9]{4}")) {
				parseDayFirst(dateStr);
			} else
				System.out.println("Invalid Date Format, try again.\n");
		}

		System.out.println("\nGoodbye!");

		stdIn.close();
	}

	public static void parseDayFirst(String dateStr) {

		// TODO
		String[] datePart = dateStr.split("\\s+");
		int day = Integer.parseInt(datePart[0]);

		String month = datePart[1];

		int year = Integer.parseInt(datePart[2]);

		if (isValidMonthAbbr(month)) {
			if (isValidMonthDay(day, monthToNumber(month))) {
				if (isValidYear(year)) {
					System.out.print(standardDateString(day, monthToNumber(month), year) + "\n");
				} else {
					System.out.print("Error - Invalid Year.\n");
				}
			} else {
				System.out.print("Error - Invalid day or month.\n");
			}
		} else {

			System.out.print("Invalid Month Abreviation.\n");
		}
	}

	public static void parseMonthFirst(String dateStr) {

		// TODO
		dateStr = dateStr.replace(",", "");
		String[] datePart = dateStr.split("\\s+");

		int day = Integer.parseInt(datePart[1]);

		String month = datePart[0];

		int year = Integer.parseInt(datePart[2]);

		if (isValidMonthAbbr(month)) {
			if (isValidMonthDay(day, monthToNumber(month))) {
				if (isValidYear(year)) {
					System.out.print(standardDateString(day, monthToNumber(month), year) + "\n");
				} else {
					System.out.print("Error - Invalid Year.\n");
				}
			} else {
				System.out.print("Error - Invalid day or month.\n");
			}
		} else {

			System.out.print("Invalid Month Abreviation.\n");
		}
	}

	public static void parseAllNumbers(String dateStr) {

		// TODO
		String[] datePart = dateStr.split("[\\s]*[-][\\s]*");

		int day = Integer.parseInt(datePart[1]);

		int month = Integer.parseInt(datePart[0]);

		int year = Integer.parseInt(datePart[2]);

		if (isValidMonthDay(day, month)) {
			if (isValidYear(year)) {
				System.out.print(standardDateString(day, month, year) + "\n");
			} else {
				System.out.print("Error - Invalid Year.\n");
			}
		} else {
			System.out.print("Error - Invalid day or month.\n");
		}
	}

	public static boolean isValidMonthDay(int day, int month) {

		//TODO
		
		if(day > 31 || day <= 0) {

		    return false;
		}
		switch(month) {
		    case 2: // feb
		        if (day > 28) {
		            return false;
		        }
		        break;
		    case 4: // apr
		    case 6: // jun
		    case 9: // sep
		    case 11: // nov
		        if (day > 30) {
		            return false;
		        }
		        break;
		    case 1: // jan
		    case 3: // mar
		    case 5: // may
		    case 7: // jul
		    case 8: // aug
		    case 10: // oct
		    case 12: // dec
		        if (day > 31) {
		            return false;
		        }
		        break;
		    default:
		        return false;
		}
		return true;
	}

	public static int monthToNumber(String monthStr) {

		String lowerCaseMonthStr = monthStr.toLowerCase().substring(0, 3);

		int mNumber = 0;

		for (int i = 0; i < abbrMonths.length; i++) {
			if (abbrMonths[i].equals(lowerCaseMonthStr)) {
				mNumber = i + 1;

				break;
			}
		}

		return mNumber;

	}

	public static boolean isValidMonthAbbr(String month) {

		// TODO

		return (month.length() >= 3)
				&& (month.substring(0, 3).toLowerCase().equals(abbrMonths[0]) || monthToNumber(month) != 0);

	}

	public static boolean isValidYear(int year) {
		// TODO
		return !(year < 1900 || year > 2018);
	}

	public static String standardDateString(int d, int m, int y) {

		// TODO
		return String.format("%s %s %s", d,
				fullNameMonths[m - 1].substring(0, 1).toUpperCase() + fullNameMonths[m - 1].substring(1).toLowerCase(),
				y);

	}
}