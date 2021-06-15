package 贪心.股票问题;

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
	public int maxProfit(int[] prices) {
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
}
