package 动态规划.基础题目;

/**
 * @ClassName: _JZ9_跳台阶扩展问题
 * @Author: whc
 * @Date: 2021/06/25/10:14
 */
public class _JZ9_跳台阶扩展问题 {

	/**
	 * 思路: 动态规划
	 * 1. 确定dp数组以及下标含义
	 * dp[i]表示跳到第n阶有多少跳法
	 *
	 * 2. 确定递推公式
	 * dp[i] = dp[i-1] + dp[i-2] + ....  + dp[0]
	 *
	 * 3. 初始化
	 * dp[0] = 1
	 * dp[1] = 1
	 *
	 * 4. 确定遍历顺序
	 * 从前往后遍历
	 *
	 * 时间: O(n^2)
	 * 空间: O(n)
	 */
	public int jumpFloorII(int target) {
		if(target < 2) {
			return target;
		}

		int[] dp = new int[target + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= target; i++) {
			for (int j = i-1; j >= 0; j--) {
				dp[i] += dp[j];
			}
		}

		return dp[target];
	}
}
