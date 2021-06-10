package 待分类;

import java.util.*;

/**
 * @ClassName: 待分类._1_两数之和
 * @Author: whc
 * @UpdateUser: whc
 * @Version: 0.0.1
 * @Date: 2021/01/01/23:16
 */
public class _1_两数之和 {
	/*public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[]{map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}*/

	// 2021/3/5 二刷
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target- nums[i])) {
				return new int[]{map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
		}

		return new int[0];
	}

	public static void main(String[] args) {
		new _1_两数之和().twoSum(new int[]{2,7,11,15}, 9);
	}
}
