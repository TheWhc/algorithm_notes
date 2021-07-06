package 哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _454_四数相加II
 * @Author: whc
 * @Date: 2021/07/06/10:15
 */
public class _454_四数相加II {

	/**
	 * 思路：HashMap统计元素之和,以及出现的次数
	 * 1. 先遍历前面两个数组,统计两个数组的元素任意组合的元素之和,以及次数
	 * 2. 后遍历后面两个数组,统计剩余两个元素之和,在map中查找是否存在相加为0的情况,若存在则记录次数
	 */
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<>();
		// 统计两个数组的元素之和,以及出现的次数
		for (int num_1 : nums1) {
			for (int num_2 : nums2) {
				map.put(num_1 + num_2, map.getOrDefault(num_1 + num_2, 0) + 1);
			}
		}

		int res = 0;

		// 统计剩余的两个元素之和,在map中找是否存在相加为0的情况,同时记录次数
		// x + temp = 0, x = 0 - temp
		for (int num_3 : nums3) {
			for (int num_4 : nums4) {
				int temp = num_3 + num_4;
				if(map.containsKey(0 - temp)) {
					res += map.get(0 - temp);
				}
			}
		}

		return res;
	}
}
