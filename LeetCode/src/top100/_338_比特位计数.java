package top100;

/**
 * @ClassName: _338_比特位计数
 * @Author: whc
 * @Date: 2021/05/08/13:11
 */
public class _338_比特位计数 {

	/*public int[] countBits(int num) {
		int[] res = new int[num+1];
		for (int i = 0; i <= num; i++) {
			res[i] = Integer.bitCount(i);
		}
		return res;
	}*/

	// 动态规划

	/**
	 * 思路: 对于奇数来说,奇数一定比前面的偶数多一个1, 所以dp[i] = dp[i-1] + 1
	 *      对于偶数来说,偶数最后一位为0,那么将偶数右移一位, 个数还是不变,所以dp[i] = dp[i/2]
	 */
	public int[] countBits(int num) {
		int[] dp = new int[num+1];
		dp[0] = 0;
		for (int i = 1; i <= num; i++) {
			if(i % 2 == 1) {
				dp[i] = dp[i-1] + 1;
			} else {
				dp[i] = dp[i/2];
			}
		}
		return dp;
	}

}
