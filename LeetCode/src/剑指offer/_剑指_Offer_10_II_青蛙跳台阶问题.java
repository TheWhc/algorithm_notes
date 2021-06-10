package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_10_II_青蛙跳台阶问题
 * @Author: whc
 * @Date: 2021/04/02/18:45
 */
public class _剑指_Offer_10_II_青蛙跳台阶问题 {

	/**
	 * 思路: 动态规划
	 * 1. dp[i] = dp[i-1] + dp[i-2]
	 * 2. 由于dp[i]只与前面两项相关,所以用三个变量sum,a,b记录,优化空间,降为O(1)
	 *
	 * 时间:O(n)
	 * 空间:O(1)
	 */
	public int numWays(int n) {
		if(n < 2) {
			return 1;
		}

		int a = 1;
		int b = 1;
		int sum = 0;
		for(int i = 2; i <= n; i++) {
			sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}

		return b;
	}
}
