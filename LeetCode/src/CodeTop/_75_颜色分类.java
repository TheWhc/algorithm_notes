package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _75_颜色分类
 * @Author: whc
 * @Date: 2021/09/11/17:03
 */
public class _75_颜色分类 {

	/**
	 * 思路:
	 * 1. 第一次遍历数组,将0归位
	 * 2. 第二次遍历数组,将1归位
	 */
	/*public void sortColors(int[] nums) {
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				swap(nums, i, pos++);
			}
		}

		for (int i = pos; i < nums.length; i++) {
			if(nums[i] == 1) {
				swap(nums, i, pos++);
			}
		}
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}*/


	/**
	 * 思路: 三指针
	 */
	public void sortColors(int[] nums) {
		int p0 = 0;
		int p2 = nums.length-1;

		for (int i = 0; i <= p2; i++) {
			// 因为交换后不确定当前位置是否仍为2
			while(i <= p2 && nums[i] == 2) {
				swap(nums, i, p2);
				p2--;
			}

			if(nums[i] == 0) {
				swap(nums, i, p0);
				p0++;
			}
		}
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
}
