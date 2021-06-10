package 剑指offer;

/**
 * @ClassName: _剑指_Offer_49_丑数
 * @Author: whc
 * @Date: 2021/06/03/11:15
 */
public class _剑指_Offer_49_丑数 {

	/**
	 *  思路: 三指针法
	 *
	 * 2x展开 (2 * 1) (2 * 2) (2 * 3) ......
	 * 3x展开 (3 * 1) (3 * 2) (3 * 3) ......
	 * 5x展开 (5 * 1) (5 * 2) (5 * 3) ......
	 * 因此我们可以用三个指针来表示x， 通过动态规划来进行排序存储
	 *
	 * p2代表对应dp数组值 * 2
	 * p3代表对应dp数组值 * 3
	 * p5代表对应dp数组值 * 5
	 */
	public int nthUglyNumber(int n) {
		if(n == 1) {
			return 1;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
			if(dp[i] == dp[p2] * 2) {
				p2++;
			}
			if(dp[i] == dp[p3] * 3) {
				p3++;
			}
			if(dp[i] == dp[p5] * 5) {
				p5++;
			}
		}

		return dp[n-1];
	}
}
