/**
 * 
 */
package com.java.algorithms.sorting;

import static com.java.algorithms.sorting.Util.*;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Nov 27, 2017
 */
public class ShellSort {

	public static void sort(int[] array) {

		int increment = array.length / 2;

		while (increment >= 1) {
			for (int startIndex = 0; startIndex < increment; startIndex++) {
				insertionSort(array, startIndex, increment);
			}
			increment = increment / 2;
		}

	}

	public static void insertionSort(int[] array, int startIndex, int increment) {

		for (int i = startIndex; i < array.length; i = i + increment) {
			for (int j = Math.min(array.length - 1, i + increment); j - increment >= 0; j = j - increment) {
				if (array[j - increment] > array[j])
					swap(array, j - increment, j);
				else
					break;
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 4, 3, 1, 2, 5, 9, 8, 7, 10, 6 };
		sort(array);
		printElements(array);
	}

}
