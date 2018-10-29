package Lab7;

public class Driver {

	public static void main(String[] args) {

		String[] names = { "Tom", "Steve", "Ann", "Zoe", "Bob", "Moana", "Naomi", "Kevin", "Ryan", "Nina", "Dora", "Wanda", "Eric"};

		System.out.println("Unsorted array:");
		Utility.printArray(names);

		System.out.println("Sorted array:");
		Utility.insertionSort(names);
		Utility.printArray(names);

	}

}
