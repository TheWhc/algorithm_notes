package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _189_旋转数组
 * @Author: whc
 * @Date: 2021/08/20/13:45
 */
public class _189_旋转数组 {

	/*public void rotate(int[] nums, int k) {
		k = k % nums.length;

		int[] newNums = new int[nums.length];
		for (int i = 0; i < newNums.length; i++) {
			newNums[i] = nums[(nums.length - k + i) % nums.length];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = newNums[i];
		}
	}*/

	// 三次翻转
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		// 第一次翻转
		rotateArr(nums, 0, nums.length-1);

		// 第二次翻转
		rotateArr(nums, 0, k-1);

		// 第三次翻转
		rotateArr(nums, k, nums.length-1);
	}

	private void rotateArr(int[] nums, int l, int r) {
		// 第一次翻转
		while(l < r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		_189_旋转数组 _189_旋转数组 = new _189_旋转数组();
		_189_旋转数组.rotate(new int[]{1,2,3,4,5,6,7}, 3);
	}

}
