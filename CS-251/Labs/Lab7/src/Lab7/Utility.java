package Lab7;

public class Utility {

	public static void insertionSort(String[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j - 1].compareTo(array[j]) > 0) {
				String swap = array[j - 1];
				array[j - 1] = array[j];
				array[j] = swap;
				j--;
			}
		}
	}

	public static void printArray(String[] array) {
		if (array == null) {
			return;
		}

		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.print(array[i] + "\n\n");
				return;
			}
			System.out.print(array[i] + ", ");
		}
	}
	
}
