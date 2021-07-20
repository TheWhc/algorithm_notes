package CodeTop;

import java.util.HashMap;

/**
 * @ClassName: _1_两数之和
 * @Author: whc
 * @Date: 2021/07/20/11:53
 */
public class _1_两数之和 {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i};
			} else {
				map.put(nums[i], i);
			}
		}

		return new int[0];
	}
}
