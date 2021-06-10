package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._56_合并区间
 * @Author: whc
 * @Date: 2021/04/14/13:47
 */
public class _56_合并区间 {

	public int[][] merge(int[][] intervals) {
		if(intervals == null || intervals.length == 0)
			return new int[0][];

		// 左边界进行从小到大排序
		Arrays.sort(intervals, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});

		List<int[]> res = new ArrayList<>();
		int len = intervals.length;
		boolean flag = false; // 判断最后一个区间是否被合并
		for (int i = 1; i < len; i++) {
			int begin = intervals[i-1][0];
			int end = intervals[i-1][1];
			while(i < len && intervals[i][0] <= end) {
				// 更新区间右边界 (合并)
				end = Math.max(end, intervals[i][1]);
				if(i == len - 1) {
					flag = true;
				}
				i++;
			}
			res.add(new int[]{begin, end});
		}

		// 添加最后一个区间
		if(!flag) {
			res.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});
		}

		return res.toArray(new int[res.size()][]);
	}
}
