package 待分类;

/**
 * @ClassName: 待分类._10_II_青蛙跳台阶问题
 * @Author: whc
 * @Date: 2021/03/06/10:26
 */
public class _10_II_青蛙跳台阶问题 {

	/*public int numWays(int n) {
		int a = 1, b = 1;
		for (int i = 0; i < n; i++) {
			int sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return a;
	}*/

	public int numWays(int n) {
		if(n == 0 || n == 1)
			return 1;
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%1000000007;
		}

		return dp[n];
	}

}
