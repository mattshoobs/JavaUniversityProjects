package hw7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sets {

	/**
	 * Check if passed in Integer is part of passed in List.
	 * 
	 * @param i
	 * @param list
	 * @return booelan
	 */
	public static boolean isElement(Integer i, List<Integer> list) {
		//TODO
		return list.contains(i);
		
	}
	
	/**
	 * Check if list1 is a subset of list2.
	 * Subset means all elements in list1 must be in list2.
	 * If so return true, else return false.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean isSubset(List<Integer> list1, List<Integer> list2) {
		//TODO
		
		if (list2 == null) {
			return false;
		}
		for (Integer num : list1) {
			if (!list2.contains(num)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if list1 is a super set of list2.
	 * Super set means all elements in list2 must be in list1.
	 * Return true if so, false otherwise.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean isSuperSet(List<Integer> list1, List<Integer> list2) {
		//TODO
		if (list1 == null) {
			return false;
		}
		for (Integer num : list2) {
			if (!list1.contains(num)) {
				return false;
			}
		}
		return true;
		
	}
	
	
	/**
	 * Perform the union of list1 and list2.
	 * Union means take all elements from each List and combine them into one List.
	 * If duplicate elements, only include one of the element.
	 * For example, if 3 occurred in both Lists, the resulting List will only contain one 3.
	 * This method will return a new combined List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<Integer> union(List<Integer> list1, List<Integer> list2){
		//TODO
		ArrayList<Integer> list = new ArrayList<Integer>(list1.size() + list2.size());
		
		for(Integer num : list1) {
			list.add(num);
		}
		for(Integer num : list2) {
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		Collections.sort(list);
		return list;
		
	}
	
	/**
	 * Perform intersection of list1 and list2.
	 * Intersection means to only include an element if it is in both Lists.
	 * This method will return a new interesected List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<Integer> intersection(List<Integer> list1,List<Integer> list2){
		//TODO
		ArrayList<Integer> list = new ArrayList<Integer>(list1.size() + list2.size());
		
		for(Integer num : list1) {
			if(list2.contains(num)) {
				list.add(num);
			}
		}
	
		Collections.sort(list);
		return list;
	}
	
	/**
	 * Perform subtract of sets.  list1 - list2.
	 * The result will be a List that contains all elements in list1 minus any elements that also occur in list2.
	 * This method will return a new subtracted List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<Integer> subtract(List<Integer> list1, List<Integer> list2){
		//TODO
		ArrayList<Integer> list = new ArrayList<Integer>(list1.size() + list2.size());
		
		for(Integer num : list1) {
			if(!list2.contains(num)) {
				list.add(num);
			}
		}
	
		Collections.sort(list);
		return list;
	}
	
	/**
	 * Two lists are equal if all the elements in list1 occur in list2, and all elements in list2 occur in list1.
	 * Order does matter here.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean equals(List<Integer> list1, List<Integer> list2) {
		//TODO
		if (list1.size() != list2.size()) {
			return false;
		}
		for(int i = 0; i < list1.size(); i++) {
			if (!list2.contains(list1.get(i))) {
				return false;
			}
		}
		return true;
		
		
	}
	
	/**
	 * Perform the cartesian product of two lists.
	 * This method will store the result as a List that holds strings since Java does not allow Tuples.
	 * Both lists must be sorted before performing the cartesian product.
	 * Elements in list1 should be the first element in each product.
	 * If the either list is empty, return a empty List.
	 * 
	 * See handout for example.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<String> cartesianProduct(List<Integer> list1, List<Integer> list2){
		//TODO
		if (list1 == null 
				|| list2 == null 
				|| (list1.size() == 0) 
				|| (list2.size() == 0)) {
			ArrayList<String> list = new ArrayList<String>(1);
			list.add("");
			return list;
		}
		Collections.sort(list1);
		Collections.sort(list2);
		ArrayList<String> list = new ArrayList<String>(list1.size() * list2.size());
		
		for(int i = 0; i < list1.size(); i++) {
			for(int j = 0; j < list2.size(); j++) {
				list.add("(" + list1.get(i) + "," + list2.get(j) + ")");	
			}
		}
	
		
		return list;
	}
	
	
	/**
	 * Sort the list passed in from smallest to the larget.
	 * Notice, there is no return type, so this sorts the List in place.
	 * 
	 * @param list
	 */
	public static void sort(List<Integer> list) {
		//TODO
		Collections.sort(list);
	}
	
}
