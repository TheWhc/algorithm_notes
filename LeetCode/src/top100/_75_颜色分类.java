package top100;

import java.util.Arrays;

/**
 * @ClassName: _75_颜色分类
 * @Author: whc
 * @Date: 2021/05/07/10:11
 */
public class _75_颜色分类 {

	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		for (int i = 0; i <= right; i++) {
			if(nums[i] == 2) {
				swap(i--, right--, nums);
			} else if(nums[i] == 0) {
				swap(left++, i, nums);
			}
		}
	}

	private void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
