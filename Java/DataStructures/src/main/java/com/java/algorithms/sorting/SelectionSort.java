/**
 * 
 */
package com.java.algorithms.sorting;
import static com.java.algorithms.sorting.Util.*;
/**
 * @author Selvakumar Samuel Dhanraj
 *
 * Nov 26, 2017
 */
public class SelectionSort {

	public static int[] sort(int[] array){
		
		for(int i=0; i<array.length; i++){
			for (int j=i+1; j<array.length;j++){
				if(array[i]>array[j])
					swap(array, i , j);
			}
		}
		return array;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array ={4,3,1,2,5,9,8,7,10,6};
		sort(array);
		printElements(array);

	}

}
