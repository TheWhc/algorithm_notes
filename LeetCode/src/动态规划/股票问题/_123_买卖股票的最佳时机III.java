package 动态规划.股票问题;

/**
 * @ClassName: _123_买卖股票的最佳时机III
 * @Author: whc
 * @Date: 2021/06/12/11:07
 */
public class _123_买卖股票的最佳时机III {

	// 最多只有两次买卖股票

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j] : 表示第i天状态为j时,所获得的最大利润
	 *   	j的范围是0~4, dp[i][0]表示不操作, dp[i][1]表示第一次买入, dp[i][2]表示第一次卖出, dp[i][3]表示第二次买入, dp[i][4]表示第二次卖出
	 *  2. 确定递推公式
	 *  	dp[i][1] = Math.max(dp[i-1][1], -prices[i] + dp[i-1][0]);
	 *  	dp[i][2] = Math.max(dp[i-1][2], prices[i] + dp[i-1][1]);
	 *      dp[i][3] = Math.max(dp[i-1][3], -prices[i] + dp[i-1][2]);
	 *      dp[i][4] = Math.max(dp[i-1][4], prices[i] + dp[i-1][3]);
	 *  3. 初始化
	 *  	dp[0][0] = 0
	 *      dp[0][1] = -prices[0]
	 *      dp[0][2] = 0
	 *      dp[0][3] = -prices[0]
	 *	4. 遍历顺序
	 *      从前往后遍历
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][5];

		dp[0][1] = -prices[0];
		dp[0][3] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp[i][1] = Math.max(dp[i-1][1], -prices[i] + dp[i-1][0]);
			dp[i][2] = Math.max(dp[i-1][2], prices[i] + dp[i-1][1]);
			dp[i][3] = Math.max(dp[i-1][3], -prices[i] + dp[i-1][2]);
			dp[i][4] = Math.max(dp[i-1][4], prices[i] + dp[i-1][3]);
		}

		return dp[prices.length-1][4];
	}*/

	// 动态规划 + 优化空间
	// 时间: O(n)   空间: O(1)
	public int maxProfit(int[] prices) {
		int[] dp = new int[5];

		dp[1] = -prices[0];
		dp[3] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp[1] = Math.max(dp[1], -prices[i] + dp[0]);
			dp[2] = Math.max(dp[2], prices[i] + dp[1]);
			dp[3] = Math.max(dp[3], -prices[i] + dp[2]);
			dp[4] = Math.max(dp[4], prices[i] + dp[3]);
		}

		return dp[4];
	}
}
