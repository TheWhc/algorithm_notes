package 待分类;

/**
 * @ClassName: 待分类._122_买卖股票的最佳时机_II
 * @Author: whc
 * @Date: 2021/04/09/14:19
 */
public class _122_买卖股票的最佳时机_II {

	public int maxProfit(int[] prices) {
		// 1. 确定dp数组以及下标含义
		// dp[i][0] 表示第i天持有股票所得现金
		// dp[i][1] 表示第i天不持有股票所得现金
		int[][] dp = new int[prices.length][2];

		// 2. 确定递推公式
		// 	  第i-1天持有股票所得现金    第i天买入 + 之前不持有股票所得现金 (多次买入,与之前不同,需要加上)
		// dp[i][0] = max{dp[i-1][0], -prices[i] + dp[i-1][1]}
		//  第i-1天不持有股票所得现金    第i天卖出 + 之前持有股票所得现金
		// dp[i][1] = max{dp[i-1][1], prices[i] + dp[i-1][0]}

		// 3. 初始化
		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		// 4. 确定遍历顺序
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], -prices[i] + dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
		}

		return dp[prices.length-1][1];
	}
}
