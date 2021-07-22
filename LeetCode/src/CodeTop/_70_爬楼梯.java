package CodeTop;

/**
 * @ClassName: _70_爬楼梯
 * @Author: whc
 * @Date: 2021/07/22/12:11
 */
public class _70_爬楼梯 {

	public int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}

		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}

	/*public int climbStairs(int n) {
		int a = 1;
		int b = 2;

		for (int i = 2; i <= n; i++) {
			int sum = a + b;
			a = b;
			b = sum;
		}

		return a;
	}*/
}
