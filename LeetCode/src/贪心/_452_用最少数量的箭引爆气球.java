package 贪心;

import java.util.Arrays;

/**
 * @ClassName: _452_用最少数量的箭引爆气球
 * @Author: whc
 * @Date: 2021/04/14/8:19
 */
public class _452_用最少数量的箭引爆气球 {

	public static void main(String[] args) {
		int[][] a = {{3,8}, {3,9}, {9,10}};
		findMinArrowShots(a);
	}

	public static int findMinArrowShots(int[][] points) {
		if(points.length == 0) {
			return 0;
		}

		// 排序
		// 按照左边界从小到大排序, 尽可能多一点重叠
		Arrays.sort(points, (o1, o2) -> {
			return o1[0] >= o2[0] ? 1 : -1;
		});

		int result = 1;
		for (int i = 1; i < points.length; i++) {
			// 大于上一个气球的右边界
			if(points[i][0] > points[i-1][1]) {
				result++;
			} else {
				// 更新重叠最小右边界
				points[i][1] = points[i-1][1];
			}
		}

		return result;
	}

}
