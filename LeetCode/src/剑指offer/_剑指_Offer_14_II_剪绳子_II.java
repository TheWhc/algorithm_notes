package 剑指offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @ClassName: _剑指_Offer_14_II_剪绳子_II
 * @Author: whc
 * @Date: 2021/05/24/15:18
 */
public class _剑指_Offer_14_II_剪绳子_II {

	/**
	 * 思路: 动态规划
	 * 大数取余
	 * 1. 确定dp函数以及下标含义 dp[i]表示长度为i的最大乘积
	 * 2. 确定递推公式
	 * 		先切割第一段长度为j,j的取值范围为[2,i)
	 * 		第二段长度为i-j可切,可不切中选择最大的
	 * 		dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)))
	 */
	/*public int cuttingRope(int n) {
		BigInteger[] dp = new BigInteger[n+1];
		// 初始化
		Arrays.fill(dp, BigInteger.valueOf(1));
		dp[2] = BigInteger.valueOf(1);

		for (int i = 3; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				dp[i] = dp[i].max(BigInteger.valueOf(j).multiply(dp[i-j]).max( BigInteger.valueOf(j * (i-j))));
			}
		}

		return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
	}*/

	/**
	 * 思路: 贪心
	 * 尽可能将绳子分成长度为3的小段,这样乘积最大
	 *
	 */
	public int cuttingRope(int n) {
		if(n < 4) {
			return n-1;
		}
		long res = 1;
		while(n > 4) {
			res = res * 3 % 1000000007;
			n -= 3;
		}

		return (int) (res * n % 1000000007);
	}

}
