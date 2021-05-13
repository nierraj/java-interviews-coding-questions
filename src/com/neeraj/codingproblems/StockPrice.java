package com.neeraj.codingproblems;

public class StockPrice {

	public static void main(String[] args) {
		int[] prices = new int[] { 1, 2, 100 };
		System.out.println(getMaxProfit(prices));
		System.out.println(getMaxProfit1(prices));
	}

	public static long getMaxProfit(int[] prices) {
		long profit = 0L;
		int maxSoFar = 0;
		for (int i = prices.length - 1; i > -1; i--) {
			if (prices[i] >= maxSoFar) {
				maxSoFar = prices[i];
			}
			profit += maxSoFar - prices[i];
		}
		return profit;
	}

	public static long getMaxProfit1(int[] prices) {
		int minPrice = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		return profit;
	}

}
