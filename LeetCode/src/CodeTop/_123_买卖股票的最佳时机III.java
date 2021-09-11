package CodeTop;

/**
 * @ClassName: _123_买卖股票的最佳时机III
 * @Author: whc
 * @Date: 2021/09/11/16:34
 */
public class _123_买卖股票的最佳时机III {

	/**
	 * 思路: 动态规划
	 * 1. 确定dp数字以及下标含义
	 * dp[i][j]:表示第i天状态为j时所获得的最大利润
	 * j范围为0~4
	 * 0: 不操作
	 * 1: 第一次买入
	 * 2: 第一次卖出
	 * 3: 第二次买入
	 * 4: 第二次卖出
	 *
	 * 2. 确定递推公式
	 * dp[i][1] = Math.max(dp[i-1][1], -prices[i] + dp[i-1][0])
	 * dp[i][2] = Math.max(dp[i-1][2], prices[i] + dp[i-1][1])
	 * dp[i][3] = Math.max(dp[i-1][3], -prices[i] + dp[i-1][2])
	 * dp[i][4] = Math.max(dp[i-1][4], prices[i] + dp[i-1][3])
	 *
	 * 3. 初始化
	 * dp[0][0] = 0
	 * dp[0][1] = -prices[0]
	 * dp[0][2] = 0
	 * dp[0][3] = -prices[0]
	 * dp[0][4] = 0
	 *
	 * 4. 确定遍历顺序
	 * 从前往后遍历
	 *
	 *
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

	// 优化
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
