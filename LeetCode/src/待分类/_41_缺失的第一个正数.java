package 待分类;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName: 待分类._41_缺失的第一个正数
 * @Author: whc
 * @Date: 2021/03/24/16:46
 */
public class _41_缺失的第一个正数 {

	// 哈希表(空间复杂度不符合)
	/*public int firstMissingPositive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int i = 1; i <= nums.length; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}

		return nums.length + 1;
	}*/

	// 二分查找(时间复杂度不符合)
	/*public int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i <= nums.length; i++) {
			int index = binarySearch(i, nums);
			if(index == -1) {
				return i;
			}
		}

		return nums.length + 1;
	}

	private int binarySearch(int target, int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(nums[mid] == target) {
				return left;
			} else if(nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}*/


	// 哈希
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			while(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i]-1]) {
				swap(i, nums[i]-1, nums);
			}
		}

		// [1,-1,3,4]
		for (int i = 0; i < len; i++) {
			if(nums[i]-1 != i) {
				return i+1;
			}
		}

		// 都正确返回数组长度+1
		return len+1;
	}

	private void swap(int a, int b, int[] nums) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
