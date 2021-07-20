package CodeTop;

/**
 * @ClassName: _121_买卖股票的最佳时机
 * @Author: whc
 * @Date: 2021/07/20/13:42
 */
public class _121_买卖股票的最佳时机 {

	/*public int maxProfit(int[] prices) {
		// dp[i][0] 持有股票, dp[i][1] 不持有股票
		int[][] dp = new int[prices.length][2];

		dp[0][0] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(-prices[i], dp[i-1][0]);
			dp[i][1] = Math.max(prices[i] + dp[i-1][0], dp[i-1][1]);
		}

		return dp[prices.length-1][1];
	}*/


	public int maxProfit(int[] prices) {
		// dp[i][0] 持有股票, dp[i][1] 不持有股票
		int[] dp = new int[2];

		dp[0] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp[0] = Math.max(-prices[i], dp[0]);
			dp[1] = Math.max(prices[i] + dp[0], dp[1]);
		}

		return dp[1];
	}

	// 贪心
	/*public int maxProfit(int[] prices) {
		int left = 0; // 找到买入最小值下标
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] < prices[left]) {
				left = i;
			}
			res = Math.max(res, prices[i] - prices[left]);
		}

		return res;
	}*/
}
