/**
 * 
 */
package com.java.algorithms.sorting;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 * Nov 26, 2017
 */
public class Util {

	public static void printElements(int[] array){
		for (int t: array){
			System.out.print(t+", ");
		}
		System.out.println();
	}
	
	public static void swap(int[] array, int index1, int index2){
		int temp= array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}
