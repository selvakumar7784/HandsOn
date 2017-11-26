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
public class BubbleSort {
	
	public static void sort(int[]array){
		
		for (int i=0;i<array.length;i++){
			boolean isSwapped=false;
			for(int j=array.length-1;j>i;j--){
				if(array[j-1]>array[j]){
					swap(array, j-1, j);
					isSwapped = true;
				}
			}
			
			if(!isSwapped)
				break;
		}
		
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
