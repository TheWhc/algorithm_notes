package 待分类;

/**
 * @ClassName: 待分类._123_买卖股票的最佳时机III
 * @Author: whc
 * @Date: 2021/04/09/15:47
 */
public class _123_买卖股票的最佳时机III {

	public int maxProfit(int[] prices) {
		// 1. 确定dp数组和下标含义
		// dp[i][0] 表示无操作  dp[i][1]:第一次买入  dp[i][2]:第一次卖出 dp[i][3]:第二次买入 dp[i][4]:第二次卖出
		// dp[i][j] 表示第i天状态为j所剩的最大现金
		int[][] dp = new int[prices.length][5];

		// 2. 确定递推公式
		/*
		第一次买入 dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
		第一次卖出 dp[i][2] = max(dp[i-1][2], dp[i-1][1]+prices[i])
		第二次买入 dp[i][3] = max(dp[i-1][3], dp[i-1][2]-prices[i])
		第二次卖出 dp[i][4] = max(dp[i-1][4], dp[i-1][3]+prices[i])
		 */

		// 3. 初始化
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		dp[0][2] = 0;
		// 不用管第几次，现在手头上没有现金，只要买入，现金就做相应的减少。
		dp[0][3] = -prices[0];
		dp[0][4] = 0;

		// 4. 确定遍历顺序 从前往后
		for (int i = 1; i < prices.length; i++) {
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
			dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]+prices[i]);
			dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]-prices[i]);
			dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3]+prices[i]);
		}

		return dp[prices.length-1][4];
	}

}
