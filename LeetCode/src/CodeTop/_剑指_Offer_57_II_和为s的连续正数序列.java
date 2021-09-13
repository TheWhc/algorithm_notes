package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _剑指_Offer_57_II_和为s的连续正数序列
 * @Author: whc
 * @Date: 2021/09/13/22:57
 */
public class _剑指_Offer_57_II_和为s的连续正数序列 {

	// 滑动窗口
	public int[][] findContinuousSequence(int target) {
		List<int[]> res = new ArrayList<>();

		int left = 1;
		int right = 2;
		int sum = left + right;
		while(left <= target / 2) {
			if(sum < target) {
				sum += ++right;
			} else if(sum > target) {
				sum -= left;
				left++;
			} else {
				int[] temp = new int[right - left + 1];
				for (int i = left; i <= right; i++) {
					temp[i - left] = i;
				}
				res.add(temp);
				sum -= left;
				left++;
			}
		}

		return res.toArray(new int[res.size()][]);
	}
}
