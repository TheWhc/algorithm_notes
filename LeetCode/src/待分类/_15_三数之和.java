package 待分类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._15_三数之和
 * @Author: whc
 * @Date: 2021/03/01/0:40
 */
public class _15_三数之和 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length < 3) {
			return res;
		}
		int len = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < len; i++) {
			// 第一个大于0, 由于排序原因,后面全都是大于0,不符合
			if(nums[i] > 0)
				break;
			// 去重
			if(i > 0 && nums[i] == nums[i-1])
				continue;
			int L = i+1;
			int R = len-1;
			while(L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if(sum == 0) {
					res.add(Arrays.asList(nums[i], nums[L], nums[R]));
					// 去重
					while(L < R && nums[L+1] == nums[L]) {
						L++;
					}
					while(L < R && nums[R-1] == nums[R]) {
						R--;
					}
					L++;
					R--;
				} else if(sum > 0) {
					R--;
				} else {
					L++;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		threeSum(nums);
	}
}
