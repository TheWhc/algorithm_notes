package 双指针法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._15_三数之和
 * @Author: whc
 * @Date: 2021/04/25/9:39
 */
public class _15_三数之和 {

	// 时间复杂度 O(n^2)
	public List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length == 0) return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			// 如果第一个数字已经大于0,后面无论如何都不能组成三个数等于0
			if(nums[i] > 0) {
				break;
			}
			// 去重
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}

			int left = i+1;
			int right = nums.length-1;
			int sum = nums[i];
			while(left < right) {
				// 不能放这里,防止出现0 0 0情况, 会漏掉0 0 0 三元组的情况
				/*while(left < right && nums[left] == nums[left+1]) {
					left++;
				}
				while(left < right && nums[right] == nums[right-1]) {
					right--;
				}*/
				// 太小,left指针需要往右走
				if(sum + nums[left] + nums[right] < 0) {
					left++;
					// 太大, right指针需要往左走
				} else if(sum + nums[left] + nums[right] > 0) {
					right--;
				} else {
					List<Integer> tmp = Arrays.asList(nums[i], nums[left], nums[right]);
					res.add(tmp);

					// 去重
					while(left < right && nums[left] == nums[left+1]) {
						left++;
					}
					while(left < right && nums[right] == nums[right-1]) {
						right--;
					}

					left++;
					right--;
				}
			}
		}
		return res;
	}

}
