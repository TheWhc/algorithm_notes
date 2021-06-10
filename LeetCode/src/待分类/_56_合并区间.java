package 待分类;

import java.util.Arrays;

/**
 * @ClassName: 待分类._56_合并区间
 * @Author: whc
 * @Date: 2021/03/20/14:33
 */
// 贪心
public class _56_合并区间 {

	public int[][] merge(int[][] intervals) {
		// 对区间起始位置排序
		Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));

		// 结果数组
		int[][] res = new int[intervals.length][2];
		int idx = -1;
		for (int[] interval : intervals) {
			// 如果是空数组 或者 当前区间的起始位置 > 结果数组中最后区间的终止位置
			if(idx == -1 || interval[0] > res[idx][1]) {
				// 直接添加
				res[++idx] = interval;
			} else {
				// 反之则合并
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}

		return Arrays.copyOf(res, idx+1);
	}
}
