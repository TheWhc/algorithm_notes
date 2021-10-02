package cvte;

/**
 * @ClassName: _04_股票的最大利润
 * @Author: whc
 * @Date: 2021/10/01/10:26
 */
public class _04_股票的最大利润 {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}

		int[][] dp = new int[prices.length][2]; // 持有股票、不持有股票
		int maxRes = 0;
		dp[0][0] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
			if(dp[i][1] > maxRes) {
				maxRes = dp[i][1];
			}
		}

		return maxRes;
	}
}
