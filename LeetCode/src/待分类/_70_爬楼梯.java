package 待分类;

/**
 * @ClassName: 待分类._70_爬楼梯
 * @Author: whc
 * @Date: 2021/03/21/21:52
 */
public class _70_爬楼梯 {

	/*public int climbStairs(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}*/

	// 优化
	/*public int climbStairs(int n) {
		int[] dp = new int[2];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i % 2] = dp[(i-1) % 2] + dp[(i-2) % 2];
		}

		return dp[n % 2];
	}*/

	public int climbStairs(int n) {
		if(n <= 1) {
			return n;
		}
		int[] dp = new int[2];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = dp[0] + dp[1];
			dp[0] = dp[1];
			dp[1] = sum;
		}

		return dp[1];
	}
}
