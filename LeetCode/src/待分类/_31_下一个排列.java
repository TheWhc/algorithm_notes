package 待分类;

import java.util.Arrays;

/**
 * @ClassName: 待分类._31_下一个排列
 * @Author: whc
 * @Date: 2021/03/05/12:51
 */
public class _31_下一个排列 {
	// 比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，比123大的那个数 也就是132

	/*public void nextPermutation(int[] nums) {
		int len = nums.length;
		for (int i = len-1; i >= 0; i--) {
			// 比如1238 5764, 从后往前找到相对升序的元素, i对应的元素是7 比前面5大
			if(nums[i] > nums[i-1]) {
				// 排序是想找到一个增加的幅度尽可能小 将尽可能小的【大数】 和 前面的 【小数】交换
				Arrays.sort(nums, i, len);
				// 1238 5764 -> 1238 5467
				for (int j = i; j < len; j++) {
					if(nums[j] > nums[i-1]) {
						int tmp = nums[j];
						nums[j] = nums[i-1];
						nums[i-1] = tmp;
						// 1238 5467 -> 1238 6457
						return;
					}
				}
			}
		}


		// 如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，那么就返回1，2，3排序后所有数中最小的那个，也就是1，2，3 -> [1,2,3]
		Arrays.sort(nums);
		return;
	}*/


	// 2021/3/26 二刷
	public static void nextPermutation(int[] nums) {
		for (int i = nums.length-1; i >= 0; i--) {
			for (int j = nums.length-1; j > i; j--) {
				if(nums[j] > nums[i]) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					Arrays.sort(nums, i+1, nums.length);
					return;
				}
			}
		}
		Arrays.sort(nums);
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		nextPermutation(nums);
	}
}
