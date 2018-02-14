/**
 * 
 */
package com.java.algorithms.sorting;

import static com.java.algorithms.sorting.Util.printElements;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 * Dec 1, 2017
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 4, 3, 1, 2, 5, 9, 8, 7, 10, 6 };
		sort(array);
		printElements(array);

	}

}
