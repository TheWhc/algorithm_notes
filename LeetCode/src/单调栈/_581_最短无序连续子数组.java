package 单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: _581_最短无序连续子数组
 * @Author: whc
 * @Date: 2021/07/14/10:43
 */
public class _581_最短无序连续子数组 {

	/**
	 * 思路: 双指针法
	 *
	 * 1. 拷贝一份数组的副本,并对其进行排序
	 * 2. 设置指针left指向原数组和副本数组的第一个元素
	 * 	  同时遍历,直到遇到不相同的元素
	 *
	 * 	  设置指针right指向原数组和副本数组的最后一个元素
	 * 	  同时遍历,直到遇到不相同的元素
	 * 3. 右指针下标 - 左指针下标即为所求
	 *
	 * 时间： O(nlogn)
	 * 空间： O(n)
	 */

	/*public int findUnsortedSubarray(int[] nums) {
		*//*int[] copyNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copyNums);
		int left = 0;
		int right = nums.length - 1;

		while(left < nums.length && nums[left] == copyNums[left]) {
			left++;
		}

		while(right > 0 && nums[right] == copyNums[right]) {
			right--;
		}

		if(left == nums.length || right < 0) {
			return 0;
		}

		return right - left + 1;*//*

		int[] nums2 = nums.clone();
		Arrays.sort(nums2);
		int right = 0;
		int left = nums2.length;

		for (int i = 0; i < nums2.length; i++) {
			if(nums[i] != nums2[i]) {
				left = Math.min(left, i);
				right = Math.max(right, i);
			}
		}

		return right >= left ? right - left + 1 : 0;
	}*/

	/**
	 * 思路: 单调栈
	 * 单调栈存储左边界和右边界 单调递增、单调递减下标值
	 *
	 * 左边界:
	 *   - 出栈(栈中缺失的下标值中最小值即为左边界)
	 *   	- 栈为非空以及栈顶元素大于当前元素时
	 *   	- 更新左边界最小值
	 *   - 入栈
	 *   	- 栈为空或者栈顶元素小于当前元素时
	 *
	 *	右边界:
	 *   - 出栈(栈中缺失的下标值中的最大值即为右边界)
	 *   	- 栈为非空以及栈顶元素小于当前元素时
	 *   	- 更新右边界最大值
	 *   - 入栈
	 *   	- 栈为空或者栈顶元素大于当前元素时
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	public int findUnsortedSubarray(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int left = nums.length - 1;

		// 求最左边界,保持栈为单调递增
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				left = Math.min(left, stack.pop());
			}
			stack.push(i);
		}

		// 求最右边界,保持栈为单调递减
		stack.clear();
		int right = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				right = Math.max(right, stack.pop());
			}
			stack.push(i);
		}

		return right > left ? right - left + 1 : 0;
	}

	public static void main(String[] args) {
		_581_最短无序连续子数组 _581_最短无序连续子数组 = new _581_最短无序连续子数组();
		_581_最短无序连续子数组.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
	}
}
