package 待分类;

/**
 * @ClassName: 待分类._309_最佳买卖股票时机含冷冻期
 * @Author: whc
 * @Date: 2021/04/10/1:04
 */
public class _309_最佳买卖股票时机含冷冻期 {
	/*public int maxProfit(int[] prices) {
		// 1. 定义dp数组以及下标含义
		int[][] dp = new int[prices.length][4];

		// 2. 确定递推公式

		// 3. 初始化
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		dp[0][2] = 0;
		dp[0][3] = 0;

		// 4. 确定遍历顺序
		for (int i = 1; i < prices.length; i++) {
			// 状态一: 买入股票状态
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][3], dp[i-1][1])-prices[i]);
			// 状态二: 今天保持卖出股票状态  (前一天的卖出保持态 和 前一天为冷冻期)
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
			// 状态三: 今天卖出股票
			dp[i][2] = dp[i-1][0] + prices[i];
			// 状态四: 今天为冷冻期状态(只有一天)
			dp[i][3] = dp[i-1][2];
		}

		return Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][2], dp[prices.length-1][1]));
	}*/

	// 冷冻期: 只要在今天想买入的时候判断一下前一天是不是刚卖出，即可
	public int maxProfit(int[] prices) {
		// 1. 确定dp数组以及下标含义
		int[][] dp = new int[prices.length][3];

		// 2. 确定递推公式
		/*
		   一共三种状态
		   0: 不持有股票当天没卖出
		   1: 表示持有股票
		   2: 不持股且当天卖出了
                          i-1不持股且当天没卖出  i-1天不持股且当天卖出
		   dp[i][0] = max(dp[i-1][0], dp[i-1][2])
		                  i-1持有股票    当天买入
		   dp[i][1] = max(dp[i-1][1], -prices[i] + dp[i-1][0])
		   				  i-1买入
		   dp[i][2] = prices[i] + dp[i-1][1]
		 */

		// 3. 初始化
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		dp[0][2] = 0;

		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
			dp[i][1] = Math.max(dp[i-1][1], -prices[i] + dp[i-1][0]);
			dp[i][2] = prices[i] + dp[i-1][1];
		}

		return Math.max(dp[prices.length-1][0], dp[prices.length-1][2]);
	}
}
