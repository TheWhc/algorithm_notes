package 贪心;

import java.util.Arrays;

/**
 * @ClassName: _452_用最少数量的箭引爆气球
 * @Author: whc
 * @Date: 2021/04/14/8:19
 */
public class _452_用最少数量的箭引爆气球 {

	public static void main(String[] args) {
		int[][] a = {{1,6}, {2,8}, {7,12}, {10,16}};
		findMinArrowShots(a);
	}

	/**
	 *  思路: 贪心
	 *
	 *  局部最优: 当气球出现重叠时,一起射,所用弓箭最少
	 *  全局最优: 最少的箭
	 *
	 *  1. 对数组按照左边起始位置进行排序, 让气球尽量重叠
	 *  2. 从前往后遍历, 如果遇到左边起始位置大于上一个气球的最小右边界, 就引爆, res++
	 *  	如果左边起始位置小于上一个气球的最小右边界, 则更新气球的最小右边界
	 *
	 */
	public static int findMinArrowShots(int[][] points) {

		Arrays.sort(points, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});

		int res = 1;

		for (int i = 1; i < points.length; i++) {

			// 大于上一个气球的右边界,需要引爆
			if(points[i][0] > points[i-1][1]) {
				res++;
			} else {
				// 更新重叠的最小右边界
				points[i][1] = Math.min(points[i-1][1], points[i][1]);
			}
		}

		return res;
	}

}
