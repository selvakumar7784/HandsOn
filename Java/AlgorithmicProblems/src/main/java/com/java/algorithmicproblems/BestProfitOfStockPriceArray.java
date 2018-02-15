/**
 * 
 */
package com.java.algorithmicproblems;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Feb 14, 2018
 */
public class BestProfitOfStockPriceArray {

	public static int getMaxProfit(int[] stockPricesYesterday) {

		if (stockPricesYesterday.length < 2) {
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}

		// we'll greedily update minPrice and maxProfit, so we initialize
		// them to the first price and the first possible profit
		int minPrice = stockPricesYesterday[0];
		int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

		// start at the second (index 1) time
		// we can't sell at the first time, since we must buy first,
		// and we can't buy and sell at the same time!
		// if we started at index 0, we'd try to buy *and* sell at time 0.
		// this would give a profit of 0, which is a problem if our
		// maxProfit is supposed to be *negative*--we'd return 0.
		for (int i = 1; i < stockPricesYesterday.length; i++) {
			int currentPrice = stockPricesYesterday[i];

			// see what our profit would be if we bought at the
			// min price and sold at the current price
			int potentialProfit = currentPrice - minPrice;

			// update maxProfit if we can do better
			maxProfit = Math.max(maxProfit, potentialProfit);

			// update minPrice so it's always
			// the lowest price we've seen so far
			minPrice = Math.min(minPrice, currentPrice);
		}

		return maxProfit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] stockPricesYesterday = new int[] { 10, 7, 5, 8, 11, 9 };

		int maxProfile = getMaxProfit(stockPricesYesterday);

		System.out.println(maxProfile);
	}

}
