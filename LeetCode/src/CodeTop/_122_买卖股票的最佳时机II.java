package CodeTop;

/**
 * @ClassName: _122_买卖股票的最佳时机II
 * @Author: whc
 * @Date: 2021/07/29/23:51
 */
public class _122_买卖股票的最佳时机II {

	/*public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];

		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		for (int i = 1; i < prices.length; i++) {
			// 持有股票
			// (当前买入 + 前一天不持有股票, 一直保持持有股票)  与一次买卖不同的地方为前面,要加上前一天不持有股票所获得的最大利润
			dp[i][0] = Math.max(dp[i-1][1] - prices[i], dp[i-1][0]);

			// 不持有股票
			// (当前卖出 + 前一天持有股票, 一直保持不持有股票)
			dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
		}

		return dp[prices.length-1][1];
	}*/

	// 优化
	/*public int maxProfit(int[] prices) {
		int[] dp = new int[2];

		dp[0] = -prices[0];
		dp[1] = 0;

		for (int i = 1; i < prices.length; i++) {
			// 持有股票
			// (当前买入 + 前一天不持有股票, 一直保持持有股票)  与一次买卖不同的地方为前面,要加上前一天不持有股票所获得的最大利润
			dp[0] = Math.max(dp[1] - prices[i], dp[0]);

			// 不持有股票
			// (当前卖出 + 前一天持有股票, 一直保持不持有股票)
			dp[1] = Math.max(dp[0] + prices[i], dp[1]);
		}

		return dp[1];
	}*/

	// 贪心
	public int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i-1]) {
				res += prices[i] - prices[i-1];
			}
		}

		return res;
	}
}

