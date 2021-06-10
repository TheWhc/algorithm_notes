package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_63_股票的最大利润
 * @Author: whc
 * @Date: 2021/04/10/11:18
 */
public class _剑指_Offer_63_股票的最大利润 {

	// 贪心算法
	/*public int maxProfit(int[] prices) {
		int left = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < left) {
				left = prices[i];
			}
			res = Math.max(res, prices[i]-left);
		}

		return res;
	}*/

	// 动态规划
	public int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		// 1. 确定dp数组以及下标含义
		// dp[i][j] 表示第i天 状态为j的最大现金价值
		// dp[i][0] 持有股票   dp[i][1] 不持有股票
		int[][] dp = new int[prices.length][2];

		// 2. 确定递推公式
		/*
			dp[i][0] = max(dp[i-1][0], -prices[i])
			dp[i][1] = max(dp[i-1][1], prices[i] + dp[i-1][0])
		 */

		// 3. 初始化
		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		// 4. 确定遍历顺序
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
		}

		return dp[prices.length-1][1];
	}
}
