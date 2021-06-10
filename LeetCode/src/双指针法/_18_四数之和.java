package 双指针法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _18_四数之和
 * @Author: whc
 * @Date: 2021/04/25/10:34
 */
public class _18_四数之和 {

	// 时间复杂度O(n^3)
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();
		for (int k = 0; k < nums.length; k++) { // 跟三数之和相比 多了一层for

			// 不能加这句
			/*if(nums[0] > target) {
				break;
			}*/

			// 去重
			if(k > 0 && nums[k] == nums[k-1]) {
				continue;
			}

			for (int i = k+1; i < nums.length; i++) {

				// 去重
				if(i > k+1 && nums[i] == nums[i-1]) {
					continue;
				}

				int left = i+1;
				int right = nums.length-1;

				while(left < right) {
					if(nums[k] + nums[i] + nums[left] + nums[right] < target) {
						left++;
					} else if(nums[k] + nums[i] + nums[left] + nums[right] > target) {
						right--;
					} else {
						List<Integer> tmp = Arrays.asList(nums[k], nums[i], nums[left], nums[right]);
						res.add(tmp);
						// 去重
						while(left < right && nums[left] == nums[left+1]) {
							left++;
						}
						while(left < right && nums[right] == nums[right-1]) {
							right--;
						}
						// 双指针收缩
						left++;
						right--;
					}
				}
			}
		}

		return res;
 	}


}
