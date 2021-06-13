package 动态规划.股票问题;

/**
 * @ClassName: _714_买卖股票的最佳时机含手续费
 * @Author: whc
 * @Date: 2021/06/12/12:08
 */
public class _714_买卖股票的最佳时机含手续费 {

	// 多次买卖 + 手续费问题

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j]表示第i天状态为j所获得的最大利润
	 *  	dp[i][0]表示持有股票(买入)状态
	 *      dp[i][1]表示不持有股票(卖出)状态
	 *  2. 确定递推公式
	 *  	dp[i][0] = Math.max(dp[i-1][0], -prices[i] + dp[i-1][1])
	 *  				前一天是买入的状态保持到现在, 当天买入 + 前一天卖出状态(因为是多次买卖,所以要加上)
	 *      dp[i][1] = Math.max(dp[i-1][1], prices[i] - fee + dp[i-1][0])
	 *      			前一天是卖出的状态保持到现在, 当天卖出 - 手续费 + 前一天是买入的状态
	 *  3. 初始化
	 *  	dp[0][0] = -prices[0]
	 *  	dp[0][1] = 0
	 *  4. 确定遍历顺序
	 *  	从前往后遍历
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public int maxProfit(int[] prices, int fee) {
		int[][] dp = new int[prices.length][2];

		dp[0][0] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], -prices[i] + dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-1][1], prices[i] - fee + dp[i-1][0]);
		}

		return dp[prices.length-1][1];
	}*/

	// 动态规划 + 空间优化为一维
	// 时间: O(n)   空间: O(1)
	public int maxProfit(int[] prices, int fee) {
		int[] dp = new int[2];

		dp[0] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp[0] = Math.max(dp[0], -prices[i] + dp[1]);
			dp[1] = Math.max(dp[1], prices[i] - fee + dp[0]);
		}

		return dp[1];
	}
}
