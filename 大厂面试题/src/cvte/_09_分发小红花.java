package cvte;

import java.util.Arrays;

/**
 * @ClassName: _09_分发小红花
 * @Author: whc
 * @Date: 2021/10/01/12:30
 */
public class _09_分发小红花 {

	public int candy(int[] ratings) {
		int[] dp = new int[ratings.length];
		Arrays.fill(dp, 1);

		// 从左往右
		for (int i = 1; i < dp.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				dp[i] = dp[i-1] + 1;
			}
		}

		// 从右往左
		for (int i = dp.length-2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1]) {
				dp[i] = Math.max(dp[i], dp[i+1]+1);
			}
		}

		int res = 0;
		for (int num : dp) {
			res += num;
		}

		return res;
	}
}
