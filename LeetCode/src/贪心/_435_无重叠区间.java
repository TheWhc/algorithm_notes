package 贪心;

import java.util.Arrays;

/**
 * @ClassName: _435_无重叠区间
 * @Author: whc
 * @Date: 2021/04/14/9:30
 */
public class _435_无重叠区间 {



	/*public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		// 左边界从小到大排序
		Arrays.sort(intervals, (o1, o2) -> {
			return o1[0] >= o2[0] ? 1 : -1;
		});

		int res = 0;
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] < intervals[i-1][1]) {
				res++;
				// 更新右边界
				intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
			}
		}
		return res;
	}*/

	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length == 0) {
			return 0;
		}

		// 按右边界排序, 从左到右遍历
		Arrays.sort(intervals, (o1, o2) -> {
			return o1[1] > o2[1] ? 1 : -1;
		});

		int result = 1;
		int end = intervals[0][1];

		// 计算非交叉区间个数
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] >= end) {
				result++;
				end = intervals[i][1];
			}
		}

		return intervals.length - result;
	}
}
