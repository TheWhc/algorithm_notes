package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _135_分发糖果
 * @Author: whc
 * @Date: 2021/09/09/23:39
 */
public class _135_分发糖果 {

	public int candy(int[] ratings) {

		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);

		// 从左往右, 右边评分 > 左边评分
		for (int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				candy[i] = candy[i-1] + 1;
			}
		}

		// 从右往左, 左边评分 > 右边评分
		for (int i = ratings.length - 2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1]) {
				candy[i] = Math.max(candy[i], candy[i+1] + 1);
			}
		}

		int res = 0;

		for (int i = 0; i < candy.length; i++) {
			res += candy[i];
		}

		return res;
	}
}
