package 剑指offer;

/**
 * @ClassName: _剑指_Offer_14_I_剪绳子
 * @Author: whc
 * @Date: 2021/05/24/13:24
 */
public class _剑指_Offer_14_I_剪绳子 {

	/**
	 *  思路: 动态规划
	 *  1. 定义dp数组以及下标含义
	 *  	dp[i]:表示长度为i剪成m段后的最大乘积
	 *  2. 确定递推公式
	 *  	先把绳子剪掉第一段(长度为j),如果只剪长度为1,对最后乘积无益处,所以从长度为2开始剪
	 *  	剪了第一段后,剩下(i-j)长度可以剪可以不剪,取两者最大值, max(j*(i-j), j * dp[i-j])
	 *  	第一段长度区间可以取值范围区间为[2,i),对所有j不同的情况取最大值
	 *  	最终dp[i]的转移方程为: dp[i] = max(dp[i],max(j*(i-j),j*dp[i-j]))
	 *  3. 初始化
	 *  	dp[2] = 1
	 *  4. 最后返回dp[n]即可
	 *
	 *  时间复杂度:O(n^2)
	 *  空间复杂度:O(n)
	 */
	/*public int cuttingRope(int n) {
		int[] dp = new int[n+1];

		dp[2] = 1;
		*//*for (int i = 3; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
			}
		}*//*
		// 优化
		// i=3时,是特殊情况,要单独初始化
		if(n >= 3) {
			dp[3] = 2;
		}
		for (int i = 3; i <= n; i++) {
			for (int j = 2; j < i/2+1; j++) {
				dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
			}
		}

		return dp[n];
	}*/

	/**
	 *	 思路2:  贪心
	 *	 尽可能将绳子长度分为长度为3的小段,这样乘积最大
	 *
	 *	 1. 当n=2时,返回1;当n=3时,返回2; 两个合并,n < 4时, return n-1
	 *	 2. 当n=4时,返回4
	 *	 3. 当n>4时,尽可能分为长度为3,累乘
	 *	 2和3步可以合并
	 */
	public int cuttingRope(int n) {
		if(n < 4) {
			return n-1;
		}
		int res = 1;
		while(n > 4) {
			res *= 3;
			n -= 3;
		}
		return res * n;
	}
}
