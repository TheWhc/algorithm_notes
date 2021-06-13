package 动态规划.股票问题;

/**
 * @ClassName: _309_最佳买卖股票时机含冷冻期
 * @Author: whc
 * @Date: 2021/06/12/12:03
 */
public class _309_最佳买卖股票时机含冷冻期 {

	// 多次买卖 + 冷冻期问题

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义: dp[i][j]表示第i天状态为j时,所获得的最大利润值
	 *  	j的范围是0~3
	 *  	dp[i][0]:状态一 表示买入股票状态(今天买入, 之前买入了股票然后没有操作保持到今天还是买入状态)
	 *  				             今天买入又分两种情况:
	 *  				             - 前一天是冷冻期(状态四)
	 *  				             - 前一天是保持卖出的状态(状态二)
	 *      dp[i][1]:状态二 表示保持卖出股票状态(两天前就已卖出了股票, 度过了冷冻期, 一直没有操作保持到今天还是卖出状态)
	 *      				分两种情况:
	 *      				- 前一天是卖出(状态二)
	 *      				- 前一天是冷冻期(状态四)
	 *      dp[i][2]:状态三 表示今天是卖出股票状态(今天卖出)
	 *      				- 昨天一定是买入的状态(状态一)
	 *      dp[i][3]:状态四 表示今天为冷冻期,冷冻期只有一天
	 *      				- 昨天一定是卖出的状态(状态三)
	 *
	 *      为什么要把卖出拆为两个状态(状态二和状态三), 而买入可以用一个状态(状态一)表示?
	 *      因为有个冷冻期状态表示卖出的情况, 而且为了满足状态一中的今天买入情况以及状态四中的情况, 所以要拆分出来卖出两个状态
	 *
	 *  2. 确定递推公式:
	 *  	dp[i][0] = Math.max(-prices[i] + Math.max(dp[i-1][3], dp[i-1][1]), dp[i-1][0])
	 *      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3])
	 *		dp[i][2] = prices[i] + dp[i-1][0]
	 *	    dp[i][3] = dp[i-1][2]
	 *	3. 初始化
	 *		dp[i][0] = -prices[0]
	 *	    dp[i][1] = 0
	 *	    dp[i][2] = 0
	 *	    dp[i][3] = 0
	 *	4. 确定遍历顺序
	 *		从前往后遍历
	 *
	 *  5. 返回最大值时 需要返回状态二、状态三、状态四其中的最大值
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][4];

		dp[0][0] = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(-prices[i] + Math.max(dp[i-1][3], dp[i-1][1]), dp[i-1][0]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
			dp[i][2] = prices[i] + dp[i-1][0];
			dp[i][3] = dp[i-1][2];
		}

		// 冷冻期也有可能为最大值
		return Math.max(dp[prices.length-1][3], Math.max(dp[prices.length-1][1], dp[prices.length-1][2]));
	}


}
