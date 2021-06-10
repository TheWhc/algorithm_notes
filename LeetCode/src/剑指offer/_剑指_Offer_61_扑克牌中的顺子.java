package 剑指offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: 剑指offer._剑指_Offer_61_扑克牌中的顺子
 * @Author: whc
 * @Date: 2021/04/02/16:03
 */
public class _剑指_Offer_61_扑克牌中的顺子 {

	/**
	 * 思路: 模拟
	 *
	 * Set + 遍历
	 * 1. 构成顺子的条件
	 * 		- 无重复元素(大小王除外)
	 * 		- 最大值 - 最小值 < 5 (大小王除外)
	 *
	 * 时间: O(N) = O(5) = O(1)
	 * 空间: O(N) = O(5) = O(1)
	 */
	/*public boolean isStraight(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int minVal = 14;
		int maxVal= 0;
		for (int num : nums) {
			// 遇到大小王时则跳过
			if(num == 0) {
				continue;
			}
			if(set.contains(num)) {
				return false;
			}
			set.add(num);
			minVal = Math.min(minVal, num);
			maxVal = Math.max(maxVal, num);
		}

		return maxVal - minVal < 5;
	}*/


	/**
	 * 思路: 模拟
	 *
	 * 快排 + 遍历
	 * 1. 构成顺子的条件
	 * 		- 无重复元素(大小王除外)
	 * 		- 最大值 - 最小值 < 5 (大小王除外)
	 *
	 * 时间: O(nlogn) = O(1)
	 * 空间: O(logn) = O(1)
	 */
	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int jokers = 0;
		for (int i = 0; i < 4; i++) {
			if(nums[i] == 0) {
				jokers++;
			} else if(nums[i+1] == nums[i]) {
				return false;
			}
		}

		// 最大值 - 最小值
		return nums[4] - nums[jokers] < 5;
	}
}
