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

	/**
	 * 思路: 贪心
	 * 局部最优：每次合并都取最大的右边界
	 * 全局最优： 合并所有重叠的区间
	 *
	 * 1. 按照区间的左边界进行从小到大的排序
	 * 2. 如果当前区间的左边界小于上一个区间的右边界 且当前区间的右边界大于上一个区间的右边界, 则合并这两个区间, 更新右边界
	 * 2. 如果当前区间左边界和右边界都小于上一个区间的右边界, 则不合并, continue
	 * 3. 如果当前区间左边界大于上一个区间的右边界, 则添加区间, 并且更新左边界和右边界的值
	 */
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> {
			if(o1[0] != o2[0]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});


		List<int[]> res = new ArrayList<>();
		res.add(intervals[0]);
		int beginEdge = intervals[0][0];
		int endEdge = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] <= endEdge && intervals[i][1] > endEdge) {
				res.remove(res.size()-1);
				res.add(new int[]{beginEdge, intervals[i][1]});
				endEdge = intervals[i][1];
			} else if(intervals[i][1] <= endEdge) {
				continue;
			} else {
				res.add(intervals[i]);
				beginEdge = intervals[i][0];
				endEdge = intervals[i][1];
			}
		}

		return res.toArray(new int[res.size()][]);
	}

	public static void main(String[] args) {
		_56_合并区间 _56_合并区间 = new _56_合并区间();
		_56_合并区间.merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
	}
}
