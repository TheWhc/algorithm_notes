package 回溯.其它;

import java.util.Arrays;

/**
 * @ClassName: _698_划分为k个相等的子集
 * @Author: whc
 * @Date: 2021/06/26/15:25
 */
public class _698_划分为k个相等的子集 {

	/**
	 * 思路: 回溯
	 * 1. 确定递归函数返回值以及参数的含义
	 * boolean backtrack(int[] nums, int target, int startIndex, int[] size, boolean[] used)
	 * 返回值为boolean,一旦搜索到结果为true,则立即返回
	 *  nums
	 *  target 每个子集的和
	 *  startIndex 当前元素的下标
	 *  size 长度为k的数组
	 *  used 去重用的数组
	 *
	 *  2. 回溯终止条件
	 *  startIndex == nums.length, 当前元素下标等于数组大小时,
	 *
	 *  3. 单层回溯逻辑
	 *  从0开始一直到k,装满每个桶为止
	 */
	/*public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if(sum % k != 0) {
			return false;
		}

		Arrays.sort(nums);
		// 对数组降序排列，首先安排最大的数能够减少很多不必要的分支，小的数有更加灵活的选择
		for (int i = 0, j = nums.length-1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		boolean[] used = new boolean[nums.length];
		return backtrack(nums, sum / k, 0, new int[k], used);
	}

	*//**
	 *
	 * @param nums
	 * @param target 每个子集的和
	 * @param startIndex 当前元素的下标
	 * @param size 长度为k的数组
	 * @param used 去重用的数组
	 * @return
	 *//*
	private boolean backtrack(int[] nums, int target, int startIndex, int[] size, boolean[] used) {
		// 回溯终止条件
		if(startIndex == nums.length) {
			return true;
		}

		for (int i = 0; i < size.length; i++) {
			if(startIndex > 0 && nums[startIndex] == nums[startIndex-1] && !used[startIndex-1]) {
				continue;
			}

			if(size[i] + nums[startIndex] <= target) {
				size[i] += nums[startIndex];
				used[startIndex] = true;
				if(backtrack(nums, target, startIndex+1, size, used)) {
					return true;
				}
				used[startIndex] = false;
				size[i] -= nums[startIndex];
			} //else {
				// 填充下一个桶
			  //}
		}

		return false;
	}*/
	public static void main(String[] args) {
		canPartitionKSubsets(new int[]{5,4,3,2,2,2,2}, 4);
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if(sum % k != 0) {
			return false;
		}

		Arrays.sort(nums);
		// 对数组降序排列，首先安排最大的数能够减少很多不必要的分支，小的数有更加灵活的选择
		for (int i = 0, j = nums.length-1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		if(nums[0] > sum / k) {
			return false;
		}
		return backtrack(nums, sum / k, 0, new int[k]);
	}

	/**
	 *
	 * @param nums
	 * @param target 每个子集的和
	 * @param startIndex 当前元素的下标
	 * @param size 长度为k的数组
	 * @return
	 */
	private static boolean backtrack(int[] nums, int target, int startIndex, int[] size) {
		// 回溯终止条件
		if(startIndex == nums.length) {
			return true;
		}

		for (int i = 0; i < size.length; i++) {
			if(size[i] + nums[startIndex] <= target) {
				size[i] += nums[startIndex];
				if(backtrack(nums, target, startIndex+1, size)) {
					return true;
				} else {
					// 剪枝思路2:
					// 比如说第一个桶填充失败了,后面无需填充第2个、第3个桶了
					// // 当size[i] = 0 时, 某元素放入第i个桶时,size[i] += 元素大小, 然后backtrack失败, size[i] -= 元素大小值 == 0, 则后面的桶无需循环遍历了,直接返回false
					size[i] -= nums[startIndex];
					if(size[i] == 0) {
						return false;
					}
				}
			}
		}

		return false;
	}
}
