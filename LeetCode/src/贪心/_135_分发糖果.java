package 贪心;

import java.util.Arrays;

/**
 * @ClassName: _135_分发糖果
 * @Author: whc
 * @Date: 2021/04/13/10:18
 */
public class _135_分发糖果 {

	/**
	 * 思路: 贪心
	 * 两次贪心:
	 * 	- 一次是从左往右遍历,只比较评分右边比左边高的情况
	 * 	- 一次是从右往左遍历,只比较评分左边比右边高的情况
	 *
	 * 	为什么第二次是从右往左遍历？
	 * 	原因是因为要利用上一次的比较结果
	 *
	 *
	 */
	public int candy(int[] ratings) {

		int[] candy = new int[ratings.length];
		// 每个孩子至少拿一颗糖果
		Arrays.fill(candy, 1);

		// 第一次贪心,从前往后遍历
		// 右边比左边评分高
		for (int i = 1; i < candy.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				candy[i] = candy[i-1] + 1;
			}
		}

		// 第二次贪心,从后往前遍历
		// 左边比右边评分高
		for (int i = ratings.length - 2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1]) {
				candy[i] = Math.max(candy[i+1] + 1, candy[i]);
			}
		}

		int res = 0;
		for (int num : candy) {
			res += num;
		}

		return res;
	}
}
