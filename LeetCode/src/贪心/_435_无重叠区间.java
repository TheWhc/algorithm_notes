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

	/*public int eraseOverlapIntervals(int[][] intervals) {
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
	}*/

	/**
	 * 思路: 贪心
	 * 按左边界排序
	 * 1. 按照左边界进行从小到大排序,如果左边界相同,则按照右边界从小到大排序
	 * 2. 遍历数组, 如果遇到起始位置小于上一个的最小右边界,则res++,并且更新最小右边界
	 */
	/*public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> {
			if(o1[0] != o2[0]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int res = 0;
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] < intervals[i-1][1]) {
				res++;
				// 更新最小右边界
				intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
			}
		}

		return res;
	}*/

	/**
	 * 思路：贪心
	 * 按右边界排序
	 *
	 * 局部最优: 优先选右边界小的区间(留给下一个区间的空间更大一些)
	 * 全局最优: 选取最多的非交叉区间
	 *
	 *
	 */
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> {
			if(o1[0] != o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o2[0], o1[0]);
			}
		});

		int res = 0;
		int edge = intervals[0][1]; // 记录区间分割点
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] < edge) {
				res++;
			} else {
				edge = intervals[i][1];
			}
		}

		return res;
	}
}
