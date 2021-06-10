package 贪心;

import java.util.Arrays;

/**
 * @ClassName: _135_分发糖果
 * @Author: whc
 * @Date: 2021/04/13/10:18
 */
public class _135_分发糖果 {
	public static void main(String[] args) {
		candy(new int[]{1,2,2,5,4,3,2});
	}

	public static int candy(int[] ratings) {
		int[] dp = new int[ratings.length];
		Arrays.fill(dp, 1);

		// 右边评分比左边大,右边孩子就多一个糖果(从前往后)
		for (int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				dp[i] = dp[i-1] + 1;
			}
		}

		// 左评分比右评分大,左边孩子就多一个糖果(从后往前,主要是因为要利用上一次比较结果)
		for (int i = ratings.length-2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1]) {
				dp[i] = Math.max(dp[i], dp[i+1] + 1);
			}
		}

		int res = 0;
		for (int i = 0; i < ratings.length; i++) {
			res += dp[i];
		}
		return res;
	}
}
