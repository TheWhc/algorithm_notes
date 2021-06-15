package 贪心.股票问题;

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
	public int maxProfit(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] - prices[i-1] > 0) {
				result += prices[i] - prices[i-1];
			}
		}
		return result;
	}
}
