package 前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _560_和为K的子数组
 * @Author: whc
 * @Date: 2021/08/21/12:57
 */
public class _560_和为K的子数组 {

	/**
	 * 思路: 前缀和
	 * 时间：O(n^2)
	 * 空间: O(n)
	 */
	/*public int subarraySum(int[] nums, int k) {
		// 前缀数组
		int[] preSum = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if(preSum[j + 1] - preSum[i] == k) {
					count++;
				}
			}
		}

		return count;
	}*/

	// 优化
	// 前缀 + HashMap
	public int subarraySum(int[] nums, int k) {
		// 前缀数组
		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);

		int count = 0;
		int preSum = 0;

		for (int num : nums) {
			preSum += num;

			if(map.containsKey(preSum - k)) {
				count += map.get(preSum - k);
			}

			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}

		return count;
	}

}
