package 哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _18_四数之和
 * @Author: whc
 * @Date: 2021/07/06/14:18
 */
public class _18_四数之和 {

	/**
	 * 思路: 排序 + 双指针 + 去重
	 *
	 * 1. 按照三数之和的思路
	 * 2. 注意这里是target,而不是0
	 * 3. 注意去重的问题
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length <= 3) {
			return res;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			// 去重
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length; j++) {
				// 去重
				if(j > i + 1 && nums[j] == nums[j-1]) {
					continue;
				}

				int left = j + 1;
				int right = nums.length - 1;

				while(left < right) {
					if(nums[left] + nums[right] + nums[i] + nums[j] < target) {
						left++;
					} else if(nums[left] + nums[right] + nums[i] + nums[j] > target) {
						right--;
					} else {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
						// 去重
						while(left < right && nums[left] == nums[left-1]) {
							left++;
						}
						while(left < right && nums[right] == nums[right+1]) {
							right--;
						}
					}
				}
			}
		}

		return res;
	}
}
