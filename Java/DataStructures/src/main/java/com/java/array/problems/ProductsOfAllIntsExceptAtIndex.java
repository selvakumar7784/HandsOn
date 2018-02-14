/**
 * 
 */
package com.java.array.problems;

import java.util.Arrays;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Dec 27, 2017
 */
public class ProductsOfAllIntsExceptAtIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 2,4,10 };

		int[] output = getProductsOfAllIntsExceptAtIndex(input);
		//System.out.println(Arrays.toString(output));
	}

	/**
	 * @param input
	 * @return
	 */
/*	private static int[] getProductsOfAllIntsExceptAtIndex(int[] input) {
		int[] output = new int[input.length];

		for (int i = 0; i < output.length; i++) {
			int product = 1;
			for (int j = 0; j < input.length; j++) {
				if (!(i == j))
					product = product * input[j];
			}
			output[i] = product;
		}
		return output;
	}
*/
	  public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
		  System.out.println("Input:"+ Arrays.toString(intArray));
		    if (intArray.length < 2) {
		        throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
		    }

		    // we make an array with the length of the input array to
		    // hold our products
		    int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

		    // for each integer, we find the product of all the integers
		    // before it, storing the total product so far each time
		    int productSoFar = 1;
		    for (int i = 0; i < intArray.length; i++) {
		        productsOfAllIntsExceptAtIndex[i] = productSoFar;
		        productSoFar *= intArray[i];
		    }
		    System.out.println("Phase 1:"+ Arrays.toString(productsOfAllIntsExceptAtIndex));
		    // for each integer, we find the product of all the integers
		    // after it. since each index in products already has the
		    // product of all the integers before it, now we're storing
		    // the total product of all other integers
		    productSoFar = 1;
		    for (int i = intArray.length - 1; i >= 0; i--) {
		        productsOfAllIntsExceptAtIndex[i] *= productSoFar;
		        productSoFar *= intArray[i];
		    }
		    System.out.println("Output:"+ Arrays.toString(productsOfAllIntsExceptAtIndex));
		    return productsOfAllIntsExceptAtIndex;
		}

}
