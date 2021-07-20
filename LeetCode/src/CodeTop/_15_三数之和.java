package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _15_三数之和
 * @Author: whc
 * @Date: 2021/07/20/13:08
 */
public class _15_三数之和 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length <= 2) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				return res;
			}

			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int left = i+1;
			int right = nums.length-1;
			int sum = 0 - nums[i];
			while(left < right) {
				if(nums[left] + nums[right] < sum) {
					left++;
				} else if(nums[left] + nums[right] > sum) {
					right--;
				} else {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while(left < right && nums[left] == nums[left-1]) {
						left++;
					}

					while(left < right && nums[right] == nums[right+1]) {
						right--;
					}
				}
			}
		}
		return res;
	}
}
