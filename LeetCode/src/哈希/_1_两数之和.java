package 哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _1_两数之和
 * @Author: whc
 * @Date: 2021/07/06/9:47
 */
public class _1_两数之和 {

	/**
	 * 思路：利用HashMap记录值和对应的下标位置
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[]{i, map.get(target - nums[i])};
			}
			map.put(nums[i], i);
		}

		return new int[2];
	}
}
