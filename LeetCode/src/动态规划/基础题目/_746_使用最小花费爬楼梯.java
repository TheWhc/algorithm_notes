package 动态规划.基础题目;

/**
 * @ClassName: _746_使用最小花费爬楼梯
 * @Author: whc
 * @Date: 2021/06/25/10:20
 */
public class _746_使用最小花费爬楼梯 {

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  dp[i]: 到达第i个阶梯的最低花费体力值
	 *
	 *  2. 确定递推公式
	 *  dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i]
	 *
	 *  3. 初始化
	 *  dp[0] = cost[0]
	 *  dp[1] = cost[1]
	 *
	 *  4. 遍历顺序
	 *  从前往后遍历
	 *
	 *  5. 返回最小值
	 *  可以理解为最后一步不花费体力
	 *  return Math.min(dp[dp.length-1], dp[dp.length-2]);
	 *
	 *  举例推导: 10 15 20
	 *  对应dp数组 10 15 30
	 *  最小花费为15,从cost[1]开始,然后走两步就可以
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length];

		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < cost.length; i++) {
			dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
		}

		// 比如 10 15 20 对应dp为 10 15 30
		return Math.min(dp[dp.length-1], dp[dp.length-2]);
	}*/


	/**
	 * 思路: 动态规划 + 空间优化
	 *
	 * 时间: O(n)
	 * 空间: O(1)
	 */
	public int minCostClimbingStairs(int[] cost) {

		int a  = cost[0];
		int b  = cost[1];

		for (int i = 2; i < cost.length; i++) {
			int sum = Math.min(a,b) + cost[i];
			a = b;
			b = sum;
		}

		// 比如 10 15 20 对应dp为 10 15 30
		return Math.min(a, b);
	}

}
