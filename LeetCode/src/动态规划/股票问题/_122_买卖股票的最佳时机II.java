package 动态规划.股票问题;

/**
 * @ClassName: _122_买卖股票的最佳时机II
 * @Author: whc
 * @Date: 2021/06/11/11:25
 */
public class _122_买卖股票的最佳时机II {

	// 股票问题 - 多次买卖

	/**
	 *  思路: 贪心法
	 *
	 *  贪心策略:
	 *  	局部最优:收集每天的正利润
	 *      全局最优:求得最大利润
	 *
	 *  将最终利润进行拆解
	 *  比如prices[3] - prices[0]
	 *  (prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
	 *  像这样利润分解为每天为单位的维度,不是从第0天到第3天整体考虑
	 *  由此推出 (prices[i] - prices[i-1]) + (prices[i-1] - prices[i-2]) + .....(prices[1] - prices[0])
	 *
	 *  举例:  7  1  5 10  3  6  4
	 *          -6  4  5 -7  3  -2
	 *  第一天不纳入考虑,因为第一天没有利润
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	/*public int maxProfit(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] - prices[i-1] > 0) {
				result += prices[i] - prices[i-1];
			}
		}
		return result;
	}*/

	/**
	 *  思路: 动态规划
	 *
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j]:表示第i天状态为j的时候,多次买卖后的最大利润值
	 *  2. 确定递推公式
	 *
	 *  	持有股票
	 *  	dp[i][0] = Math.max(dp[i-1][0], -prices[i] + dp[i-1][1])
	 *                 第i-1天持有股票保持现状	   第i天买入股票 + 第i-1天不持有股票(与一次买卖不同的地方,因为这里存在多次买卖,所以要加上第i-1天不持有股票的利润)
	 *
	 *      不持有股票
	 *      dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]
	 *      		  第i-1天不持有股票保持现状   第i天卖出股票 + 第i-1天持有股票的最大值(即买入的最小值,在dp数组中,持有股票是按负数计算的)
	 *  3. 初始化
	 *  	dp[0][0] = -prices[0]
	 *      dp[0][1] = 0
	 *  4. 遍历顺序
	 *      从前往后遍历
	 *
	 * 时间: O(n)
	 * 空间: O(n)
	 */
	/*public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];

		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		for (int i = 1; i < prices.length; i++) {
			// 持有股票,与一次买卖唯一不同的地方的递推公式上
			dp[i][0] = Math.max(dp[i-1][0], -prices[i] + dp[i-1][1]);
			// 不持有股票
			dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
		}

		return dp[prices.length-1][1];
	}*/


	// 动态规划 + 空间优化降为一维
	// 时间: O(n)
	// 空间: O(1)
	public int maxProfit(int[] prices) {
		int[] dp = new int[2];

		dp[0] = -prices[0];
		dp[1] = 0;

		for (int i = 1; i < prices.length; i++) {
			// 持有股票,与一次买卖唯一不同的地方的递推公式上
			dp[0] = Math.max(dp[0], -prices[i] + dp[1]);
			// 不持有股票
			dp[1] = Math.max(dp[1], prices[i] + dp[0]);
		}

		return dp[1];
	}
}
