package 待分类;

/**
 * @ClassName: 待分类._188_买卖股票的最佳时机_IV
 * @Author: whc
 * @Date: 2021/04/10/0:44
 */
public class _188_买卖股票的最佳时机_IV {
	public int maxProfit(int k, int[] prices) {
		if(prices.length == 0) {
			return 0;
		}
		// 1. 确定dp数组以及下标含义
		// dp[i][j] 表示第i天状态为j所剩的最大现金
		// j为0时, 表示不操作
		// j不为0时, 为奇的时候, 表示买入; 为偶的时候,表示卖出
		int[][] dp = new int[prices.length][2 * k + 1];

		// 2. 确定递推公式
		// dp[i][1] = max(dp[i-1][1], -prices[i] + dp[i-1][0])
		// dp[i][2] = max(dp[i-1][2], prices[i] + dp[i-1][1]
		// 从而推出 j为奇时, dp[i][j] = max(dp[i-1][j], -prices[i] + dp[i-1][j-1])
		//        j为偶时, dp[i][j] = max(dp[i-1][j], prices[i] + dp[i-1][j-1])

		// 3. 初始化
		// i=0时, j为奇时, dp[0][j] = -prices[0]  为偶时, dp[0][j] = 0
		for (int j = 1; j < 2 * k + 1; j += 2) {
			dp[0][j] = -prices[0];
		}

		// 4. 遍历顺序 从前往后
		for (int i = 1; i < prices.length; i++) {
			for (int j = 1; j < 2 * k + 1; j++) {
				if (j % 2 == 0) {
					dp[i][j] = Math.max(dp[i - 1][j], prices[i] + dp[i - 1][j - 1]);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], -prices[i] + dp[i - 1][j - 1]);
				}
			}
		}

		return dp[prices.length - 1][2 * k];
	}
}
