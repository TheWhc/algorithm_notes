package 模拟;

import java.util.Arrays;

/**
 * @ClassName: _31_下一个排列
 * @Author: whc
 * @Date: 2021/09/25/18:35
 */
public class _31_下一个排列 {

	public void nextPermutation(int[] nums) {
		for (int i = nums.length-1; i >= 0; i--) {
			for (int j = nums.length-1; j > i; j--) {
				if(nums[j] > nums[i]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					Arrays.sort(nums, i+1, nums.length);
					return;
				}
			}
		}

		Arrays.sort(nums);
	}
}
