package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _56_合并区间
 * @Author: whc
 * @Date: 2021/07/23/15:36
 */
public class _56_合并区间 {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});
		List<int[]> res = new ArrayList<>();
		res.add(intervals[0]);
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			// 合并区间
			if(intervals[i][0] <= end && intervals[i][1] > end) {
				res.get(res.size()-1)[1] = intervals[i][1];
				end = intervals[i][1];
			} else if(intervals[i][0] > end)  {
				// 不能合并,添加到结果集中
				res.add(intervals[i]);
				end = intervals[i][1];
			}
		}

		return res.toArray(new int[res.size()][]);
	}
}
