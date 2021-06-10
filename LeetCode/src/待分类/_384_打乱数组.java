package 待分类;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: 待分类._384_打乱数组
 * @Author: whc
 * @Date: 2021/04/05/17:19
 */
public class _384_打乱数组 {

	int[] nums;
	int[] oldNums;
	List<List<Integer>> shuffleNums = new ArrayList<>();

	public _384_打乱数组(int[] nums) {
		this.nums = nums;
		this.oldNums = nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		this.nums = oldNums;
		oldNums = oldNums.clone();
		return oldNums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		/*for (int i = nums.length - 1; i >= 0; i--) {
			int randIndex = new Random().nextInt(i + 1);
			swap(nums[i], nums[randIndex]);
		}*/
		for (int i = 0; i < nums.length; i++) {
			int randIndex = new Random().nextInt(nums.length - i) + i;
			swap(i, randIndex);
		}
		return nums;
	}

	private void swap(int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}


	public static void main(String[] args) {
		_384_打乱数组 a = new _384_打乱数组(new int[]{1,2,3});
		a.shuffle();
		a.reset();
		a.shuffle();
	}
}
