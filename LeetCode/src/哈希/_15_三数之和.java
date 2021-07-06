package 哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _15_三数之和
 * @Author: whc
 * @Date: 2021/07/06/10:41
 */
public class _15_三数之和 {

	/**
	 * 思路: 排序 + 双指针法 + 去重
	 *
	 * 1. 对数组进行排序
	 * 2. i遍历nums数组, left指向当前i的后面元素, right指向末尾元素
	 *    - 如果当前i对应的元素大于0,直接返回结果,因为后面无论如何都无法凑成三元数组
	 *    - 当i>0时, 对nums[i] == nums[i-1]进行去重
	 *    - nums[i] + nums[left] + nums[right] < 0, 则移动左指针
	 *    - nums[i] + nums[left] + nums[right] > 0, 则移动右指针
	 *    - nums[i] + nums[left] + nums[right] == 0, 则添加结果后, 继续移动左右指针, 同时还要进行去重的处理
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length <= 2) {
			return res;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			// 排序之后第一个数已经大于0,后面无论如何都无法凑成三元组
			if(nums[i] > 0) {
				return res;
			}

			// 去重
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}

			int left = i + 1;
			int right = nums.length - 1;

			while(left < right) {
				if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else if (nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[left]);
					temp.add(nums[right]);
					res.add(temp);

					right--;
					left++;
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
