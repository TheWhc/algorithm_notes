package 动态规划.股票问题;

/**
 * @ClassName: _188_买卖股票的最佳时机IV
 * @Author: whc
 * @Date: 2021/06/12/11:25
 */
public class _188_买卖股票的最佳时机IV {

	// 最多k次买卖

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j] : 表示第i天状态为j时,所获得的最大利润
	 *   	j的范围是0~2*k, dp[i][0]表示不操作, dp[i][1]表示第一次买入, dp[i][2]表示第一次卖出, dp[i][3]表示第二次买入, dp[i][4]表示第二次卖出
	 *     所以很容易看出来, 奇数就是买入, 偶数就出卖出
	 *  2. 确定递推公式
	 *  	dp[i][1] = Math.max(dp[i-1][1], -prices[i] + dp[i-1][0]);
	 *  	dp[i][2] = Math.max(dp[i-1][2], prices[i] + dp[i-1][1]);
	 *      dp[i][3] = Math.max(dp[i-1][3], -prices[i] + dp[i-1][2]);
	 *      dp[i][4] = Math.max(dp[i-1][4], prices[i] + dp[i-1][3]);
	 *  3. 初始化
	 *  	dp[0][0] = 0
	 *      dp[0][1] = -prices[0]
	 *	4. 遍历顺序
	 *      从前往后遍历
	 *
	 *  时间: O(n * k)
	 *  空间: O(n * k)
	 */
	/*public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}

		int[][] dp = new int[prices.length][2 * k + 1];

		for (int j = 1; j < 2 * k + 1; j += 2) {
			dp[0][j] = -prices[0];
		}

		for (int i = 1; i < prices.length; i++) {
			for (int j = 1; j < 2 * k + 1; j += 2) {
				// j为奇数时,表示买入
				dp[i][j] = Math.max(dp[i-1][j], -prices[i] + dp[i-1][j-1]);
				// j为偶数时,表示卖出
				dp[i][j+1] = Math.max(dp[i-1][j+1], prices[i] + dp[i-1][j]);
			}
		}

		return dp[prices.length-1][2*k];
	}*/

	// 动态规划 + 空间优化到一维
	// 时间: O(n * k) 空间: O(k)
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}

		int[] dp = new int[2 * k + 1];

		for (int j = 1; j < 2 * k + 1; j += 2) {
			dp[j] = -prices[0];
		}

		for (int i = 1; i < prices.length; i++) {
			for (int j = 1; j < 2 * k + 1; j += 2) {
				// j为奇数时,表示买入
				dp[j] = Math.max(dp[j], -prices[i] + dp[j-1]);
				// j为偶数时,表示卖出
				dp[j+1] = Math.max(dp[j+1], prices[i] + dp[j]);
			}
		}

		return dp[2*k];
	}

}
