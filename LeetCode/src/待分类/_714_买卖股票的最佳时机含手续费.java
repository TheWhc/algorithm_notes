package 待分类;

/**
 * @ClassName: 待分类._714_买卖股票的最佳时机含手续费
 * @Author: whc
 * @Date: 2021/04/10/10:47
 */
public class _714_买卖股票的最佳时机含手续费 {

	public int maxProfit(int[] prices, int fee) {
		// 1. 定义dp数组以及下标含义
		// dp[i][j] 表示第i天状态为j所得最大现金
		// dp[i][0] 持有股票
		// dp[i][1] 不持有股票
		int[][] dp = new int[prices.length][2];

		// 2. 确定递推公式
		/*                i-1天就持有股票    第i天当天买入
			dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i])
			              i-1天就不持有股票   第i天当天卖出
			dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i]-fee)
		 */

		// 3. 初始化
		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		// 4. 确定遍历顺序 从前往后
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]-fee);
		}

		return dp[prices.length-1][1];
	}

}
