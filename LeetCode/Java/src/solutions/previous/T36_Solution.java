package solutions.previous;

public class T36_Solution {
	/**
	 * @author yukunlee
	 * @Description best-time-to-buy-and-sell-stock-iii
	 * @date 2018年10月25日
	 */
	public int maxProfit3(int[] prices) {
		int len = prices.length;
		int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
		for (int i = 0; i < len; ++i) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, prices[i] + buy1);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, prices[i] + buy2);
		}
		return sell2;
	}

	/**
	 * @author yukunlee
	 * @Description best-time-to-buy-and-sell-stock-ii
	 * @date 2018年10月29日
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		int profit = 0;
		int len = prices.length;
		int diff = 0;
		if (len < 2) {
			return 0;
		}
		for (int i = 0; i < len - 1; ++i) {
			diff = prices[i + 1] - prices[i];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}

	/**
	 * @author yukunlee
	 * @Description best-time-to-buy-and-sell-stock-i
	 * @date 2018年10月29日
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int[] prices) {
		int len = prices.length;
		if (len < 2) {
			return 0;
		}
		int buy = Integer.MAX_VALUE, sell = 0;
		for (int i = 0; i < len; ++i) {
			buy = Math.min(buy, prices[i]);
			sell = Math.max(sell, prices[i] - buy);
		}
		return sell;
	}

}
