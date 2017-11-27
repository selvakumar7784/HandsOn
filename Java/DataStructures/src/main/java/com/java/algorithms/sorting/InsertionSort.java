/**
 * 
 */
package com.java.algorithms.sorting;
import static com.java.algorithms.sorting.Util.*;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 * Nov 27, 2017
 */
public class InsertionSort {
	
	/**
	 * @param array
	 */
	public static void sort(int[] array) {
		
    for(int i=0;i<array.length-1;i++){
    	for(int j=i+1;j>0;j--){
    		if(array[j]<array[j-1])
    			swap(array, j-1,j);
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
