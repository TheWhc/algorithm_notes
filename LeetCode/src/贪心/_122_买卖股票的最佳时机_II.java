package 贪心;

/**
 * @ClassName: 待分类._122_买卖股票的最佳时机_II
 * @Author: whc
 * @Date: 2021/04/11/23:47
 */
public class _122_买卖股票的最佳时机_II {

	// 贪心
	// 把利润分解为每天为单位的维度,收集正利润的区间
	// 局部最优: 收集每天的正利润   全局最优: 求得最大利润
	// 时间O(n) 空间O(1)
	public int maxProfit(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			result += Math.max(prices[i]-prices[i-1], 0);
		}
		return result;
	}
}
