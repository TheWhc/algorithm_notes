package 单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: _503_下一个更大元素II
 * @Author: whc
 * @Date: 2021/07/13/12:00
 */
public class _503_下一个更大元素II {

	/**
	 * 思路： 单调栈  + 循环组数取模
	 *
	 * 因为存在环形的数组,所以,需要处理循环数组的索引直接使用模运算, index % nums.length
	 *
	 * 1. 遍历两边数组,将数组进行翻倍处理（不是扩容为两倍,而是遍历两遍就可以了, 采用模运算的方式来处理）
	 *
	 * 2. 从数组后往前遍历,倒序入栈
	 *
	 * 两个知识点：一是，使用模运算来模拟环状数组，二是翻倍，将环状拉直，因为2圈就可以拉直为线性的方式来处理。
	 */
	public int[] nextGreaterElements(int[] nums) {

		int[] res = new int[nums.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = nums.length * 2 - 1; i >= 0; i--) {
			while(!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
				stack.pop();
			}

			res[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums[i % nums.length]);
		}

		return res;
	}
}
