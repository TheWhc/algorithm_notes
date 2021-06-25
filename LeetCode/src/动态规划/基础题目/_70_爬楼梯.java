package 动态规划.基础题目;

/**
 * @ClassName: _70_爬楼梯
 * @Author: whc
 * @Date: 2021/06/25/10:08
 */
public class _70_爬楼梯 {

	/**
	 * 思路: 动态规划 + 优化
	 * 递推公式: dp[i] = dp[i-1] + dp[i-2]
	 * 用两个变量优化空间
	 * 时间: O(n)
	 * 空间: O(1)
	 */
	public int climbStairs(int n) {
		if(n < 2) {
			return n;
		}

		int a = 1;
		int b = 1;
		for (int i = 2; i <= n; i++) {
			int sum = a + b;
			a = b;
			b = sum;
		}

		return b;
	}
}
