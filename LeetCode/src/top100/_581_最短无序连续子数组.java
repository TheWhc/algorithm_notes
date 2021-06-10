package top100;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: _581_最短无序连续子数组
 * @Author: whc
 * @Date: 2021/05/20/23:09
 */
public class _581_最短无序连续子数组 {

	/**
	 *  思路: 排序 + 双指针法
	 *  从左往右遍历,比对原数组和排序数组,得到元素不同,求得最左边下标即左边界
	 *  从右往左遍历,比对原数组和排序数组,得到元素不同,求得最右边下标即右边界
	 *  时间复杂度: O(nlogn)
	 *  空间复杂度: O(n)
	 */
	/*public static int findUnsortedSubarray(int[] nums) {
		int[] old;
		int len = nums.length;
		old = Arrays.copyOf(nums, len);
		Arrays.sort(nums);
		int begin = Integer.MAX_VALUE;
		int end = 0;
		for (int i = 0; i < len; i++) {
			if(nums[i] != old[i]) {
				begin = i;
				break;
			}
		}

		for (int i = len-1; i >= 0; i--) {
			if(nums[i] != old[i]) {
				end = i;
				break;
			}
		}

		if(begin >= end) {
			return 0;
		}
		return end - begin + 1;
	}*/

	/**
	 * 思路: 单调栈, 存储下标位置
	 */
	/*public static int findUnsortedSubarray(int[] nums) {
		if(nums.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int min = nums.length-1;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if(stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
				stack.push(i);
			} else {
				while(!stack.isEmpty()  && nums[i] < nums[stack.peek()]) {
					min = Math.min(stack.pop(), min);
				}
			}
		}
		stack.clear();
		for (int i = nums.length-1; i >= 0; i--) {
			if(stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
				stack.push(i);
			} else {
				while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
					max = Math.max(stack.pop(), max);
				}
			}
		}
		if(min >= max) return 0;
		return max - min + 1;
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
	 */
	public static int findUnsortedSubarray(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int left = nums.length-1;
		int right = 0;
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				left = Math.min(stack.pop(), left);
			}
			stack.push(i);
		}
		stack.clear();
		for (int i = nums.length-1; i >= 0; i--) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				right = Math.max(stack.pop(), right);
			}
			stack.push(i);
		}

		if(left >= right) {
			return 0;
		} else {
			return right-left+1;
		}
	}

	public static void main(String[] args) {
		findUnsortedSubarray(new int[]{1,3,2,2,2});
	}

}
