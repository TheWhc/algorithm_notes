package 待分类;

/**
 * @ClassName: 待分类._121_买卖股票的最佳时机
 * @Author: whc
 * @Date: 2021/03/14/11:15
 */
public class _121_买卖股票的最佳时机 {

	// 暴力解法
/*	public int maxProfit(int[] prices) {
		int res = 0;

		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				res = Math.max(res, prices[j] - prices[i]);
			}
		}

		return res;
	}*/

	// 贪心算法
	// 取最左最小值, 取最右最大值
	// 时间复杂度O(n^2)
	/*public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			// 把每一天都当成卖出,最后求出最大利润
			res = Math.max(res, prices[i] - min);
		}

		return res;
	}*/

	// 动态规划
	// 时间O(n)
	// 空间O(n)
	/*public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];
		// 初始化状态
		// dp[i][0] 表示第i天持有股票所得现金
		// dp[i][1] 表示第i天不持股票
		dp[0][0] -= prices[0];
		dp[0][1] = 0;

		// 定义状态转移方程
		for (int i = 11; i < prices.length; i++) {
			// 有可能是前一天持有现金,或者是当天买入,求出最大值(即以最小的价格买入)
			dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
			// 有可能是前一天就不持有股票了,或者当天卖入,求出最大值(以最大的价格卖出)
			dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
		}

		return dp[prices.length-1][1];
	}*/

	// 进行时间优化,滚动数组
	// 时间O(n)
	// 空间O(1)
	/*public int maxProfit(int[] prices) {
		int[][] dp = new int[2][2];
		// 初始化状态
		// dp[i][0] 表示第i天持有股票所得现金
		// dp[i][1] 表示第i天不持股票
		dp[0][0] -= prices[0];
		dp[0][1] = 0;

		// 定义状态转移方程
		for (int i = 1; i < prices.length; i++) {
			// 有可能是前一天持有现金,或者是当天买入,求出最大值(即以最小的价格买入)
			dp[i%2][0] = Math.max(dp[(i-1)%2][0], -prices[i]);
			// 有可能是前一天就不持有股票了,或者当天卖入,求出最大值(以最大的价格卖出)
			dp[i%2][1] = Math.max(dp[(i-1)%2][1], prices[i] + dp[(i-1)%2][0]);
		}

		return dp[(prices.length-1)%2][1];
	}*/

	// 贪心
	// 左边找最小值 右边找最大值
	// 时间O(n)  空间O(1)
	/*public int maxProfit(int[] prices) {
		int low = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < prices.length; i++) {
			low = Math.min(low, prices[i]);
			result = Math.max(result, prices[i] - low);
		}

		return result;
	}*/

	// 动态规划
	public int maxProfit(int[] prices) {
		// 1. 确定dp数组以及下标含义
		// dp[i][0] 第i天持有股票所得现金
		// dp[i][1] 第i天不持有股票所得现金
		int[][] dp = new int[prices.length][2];

		// 2. 确定递推公式
		// 第i天持有股票  dp[i][0] = max{dp[i-1][0], -prices[i]}
		// 第i天不持有股票 dp[i][1] = max{dp[i-1][1], prices[i] + dp[i-1][0]}

		// 3. 初始化
		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		// 4. 确定递推顺序 从前往后
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
		}

		return dp[prices.length-1][1];
	}
}
