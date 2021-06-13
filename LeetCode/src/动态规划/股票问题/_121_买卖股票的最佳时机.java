package 动态规划.股票问题;

/**
 * @ClassName: _121_买卖股票的最佳时机
 * @Author: whc
 * @Date: 2021/06/11/10:38
 */
public class _121_买卖股票的最佳时机 {

	// 股票问题-一次买卖

	/**
	 *  思路: 贪心法
	 *  1. 左边选择买入最小值
	 *  2. 循环遍历每个元素当成当天卖出,与买入最小值相减,并与结果利润最大值进行比较
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	/*public int maxProfit(int[] prices) {
		int leftMin = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < leftMin) {
				leftMin = prices[i];
			}
			res = Math.max(res, prices[i] - leftMin);
		}
		return res;
	}

	/**
	 *  思路: 动态规划
	 *  (一次股票买卖问题)
	 *  1. 确定dp数组以及下标含义
	 *     dp[i][j] : 表示第i天处于j状态的最大值利润值 (j值只有0和1, 0代表持有股票(即买入), 1代表不持有股票(即卖出))
	 *  2. 确定递推公式
	 *     dp[i][0] = Math.max(dp[i-1][0], -prices[i])
	 *                 第i-1天就持有股票保持现状; 第i天买入股票
	 *     dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0])
	 *                 第i-1天就不持有股票保持现状; 第i天卖出股票 + 第i-1天持有股票的最大值(即买入的最小值,在dp数组中,持有股票是按负数计算的)
	 *	3. 初始化
	 *     从上面的递推公式可以看出,初始状态有两个,dp[0][0]和dp[0][1]
	 *	   dp[0][0]	= -prices[0]
	 *	   dp[0][1] = 0
	 *	4. 确定遍历顺序
	 *     从前往后遍历
	 *
	 *  5. 举例推导dp数组
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];

		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		for (int i = 1; i < prices.length; i++) {
			// 持有股票
			dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
			// 不持有股票
			dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
		}

		return dp[prices.length-1][1];
	}*/

	// 在前面动态规划的基础进行空间优化,从二维降为一维
	public int maxProfit(int[] prices) {
		int[] dp = new int[2];

		dp[0] = -prices[0];
		dp[1] = 0;

		for (int i = 1; i < prices.length; i++) {
			// 持有股票
			dp[0] = Math.max(dp[0], -prices[i]);
			// 不持有股票
			dp[1] = Math.max(dp[1], prices[i] + dp[0]);
		}

		return dp[1];
	}
}
