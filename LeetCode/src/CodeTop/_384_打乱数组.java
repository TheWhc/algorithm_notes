package CodeTop;

import java.util.Random;

/**
 * @ClassName: _384_打乱数组
 * @Author: whc
 * @Date: 2021/08/20/14:40
 */
public class _384_打乱数组 {

	int[] original;
	public _384_打乱数组(int[] nums) {
		this.original = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return original;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] ans = original.clone();
		// nums[i]和nums[rand() % (i + 1)] 交换
		int i = original.length - 1;
		while(i >= 0) {
			/**
			 * 0 1 2 3 4 % 5  i为4时,任何数字在下标为4出现概率为1/5 , 5种可能
			 * 0 1 2 3 % 4    i为3时,任何数字在下标为3出现概率为4/5 * 1/4, 下标0到3这4个数不会出现在下标为4, 4种可能
			 * 0 1 2 % 3   3种可能
			 * 0 1 % 2     2种可能
			 * 0 % 1       1种可能
			 */
			swap(ans, i, new Random().nextInt(i + 1) % (i + 1));
			i--;
		}
		return ans;
	}

	private void swap(int[] ans, int idx1, int idx2) {
		int temp = ans[idx1];
		ans[idx1] = ans[idx2];
		ans[idx2] = temp;
	}

}
