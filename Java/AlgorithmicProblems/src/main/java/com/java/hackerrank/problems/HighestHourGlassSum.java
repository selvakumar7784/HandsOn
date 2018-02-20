/**
 * 
 */
package com.java.hackerrank.problems;

import java.util.Scanner;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Feb 20, 2018
 */
public class HighestHourGlassSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[][] input = new int[6][6];

		for (int i = 0; i < input.length; i++) {
			String s = scanner.nextLine();
			String[] str = s.split(" ");

			for (int j = 0; j < input.length; j++) {

				input[i][j] = Integer.parseInt(str[j]);
			}
		}

		scanner.close();
		

		System.out.println(calculateHighestHourGlassSum(input));

	}

	private static int calculateHighestHourGlassSum(int[][] array) {
		int rowNum = 0, colNum = 0;
		int maxValue = -64;
		int temp = 0;

		while (rowNum <= 3) {

			while (colNum <= 3) {

				for (int i = rowNum; i <= rowNum + 2; i++)
						for (int j = colNum; j <= colNum + 2; j++){
	                        if(!(((i==rowNum + 1)&&(j==colNum)) || ((i==rowNum + 1)&&(j==colNum+2))))
							temp += array[i][j];
	                    }

				
				maxValue = Math.max(temp, maxValue);
				System.out.println("maxValue: "+maxValue);
				temp = 0;
				colNum++;
			}

			colNum = 0;
			rowNum++;
		}
		return maxValue;
	}
}
