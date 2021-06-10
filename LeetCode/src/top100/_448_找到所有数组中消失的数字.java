package top100;

import java.util.*;

/**
 * @ClassName: _448_找到所有数组中消失的数字
 * @Author: whc
 * @Date: 2021/04/27/9:23
 */
public class _448_找到所有数组中消失的数字 {

	// 额外空间O(n)
	// 时间复杂度O(n)
	/*public List<Integer> findDisappearedNumbers(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new ArrayList<>();
		}

		List<Integer> res = new ArrayList<>();
		int[] bucket = new int[nums.length + 1];
		for (int num : nums) {
			bucket[num]++;
		}

		for (int i = 1; i < bucket.length; i++) {
			if(bucket[i] == 0) {
				res.add(i);
			}
		}

		return res;
	}*/


	public static void main(String[] args) {
		findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}

	// 空间O(1)
	// 时间O(n)
	// 哈希
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while(nums[i] != nums[nums[i] - 1]) {
				int temp = nums[i];
				nums[i] = nums[nums[i]-1];
				nums[temp-1] = temp;
			}
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] - 1 != i) {
				res.add(i+1);
			}
		}

		return res;
	}
}
