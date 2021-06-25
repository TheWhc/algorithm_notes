package 动态规划.基础题目;

/**
 * @ClassName: _509_斐波那契数
 * @Author: whc
 * @Date: 2021/06/25/10:02
 */
public class _509_斐波那契数 {

	/**
	 * 思路: 动态规划 + 优化
	 * 递推公式:dp[i] = dp[i-1] + dp[i-2]
	 * 维护两个变量进行优化空间
	 * 时间:O(n)
	 * 空间:O(1)
	 */
	public int fib(int n) {
		if(n < 2) {
			return n;
		}

		int a = 0;
		int b = 1;
		for (int i = 2; i <= n; i++) {
			int sum = a + b;
			a = b;
			b = sum;
		}

		return b;
	}
}
