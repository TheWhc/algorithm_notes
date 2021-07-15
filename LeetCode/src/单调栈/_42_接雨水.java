package 单调栈;

import java.util.Stack;

/**
 * @ClassName: _42_接雨水
 * @Author: whc
 * @Date: 2021/07/15/9:15
 */
public class _42_接雨水 {

	/**
	 * 思路: 暴力解法
	 *
	 * 1. 遍历每个柱子,搜索柱子的左右最大高度
	 * 2. 统计每个柱子所能容纳的最大雨水
	 *
	 * 时间: O(n^2)
	 * 空间: O(1)
	 */
	/*public int trap(int[] height) {
		int area = 0;

		for (int i = 0; i < height.length; i++) {
			int leftHeight = height[i]; // 记录左边最高的柱子高度
			int rightHeight = height[i]; // 记录右边最高的柱子高度

			// 找到当前柱子的右边最大高度
			for (int right = i + 1; right < height.length; right++) {
				if(height[right] > rightHeight) {
					rightHeight = height[right];
				}
			}

			// 找到当前柱子的左边最大高度
			for (int left = i - 1; left >= 0; left--) {
				if(height[left] > leftHeight) {
					leftHeight = height[i];
				}
			}

			// 左右最高柱子选择最小的柱子的高度,并且减去当前柱子的高度,即为当前柱子所能容纳的最大雨水高度
			area = area + Math.min(leftHeight, rightHeight) - height[i];
		}

		return area;
	}*/

	/**
	 * 思路： 单调栈
	 *
	 * 1. 从左向右遍历数组,维护一个单调递减栈,栈内存储的是数组的下标索引
	 * 2. 当遍历的元素小于等于栈顶索引对应的元素的时候,被遍历的元素下标直接入栈
	 * 	  当出现某个元素大于栈顶下标对应的元素的时候,计算当前雨水的面积
	 */
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();

		int area = 0;
		for (int i = 0; i < height.length; i++) {
			// 维护单调递减
			while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
				// 此时的凹槽的下标
				int curIdx = stack.pop();
				// 若栈为空,则结束循环
				if(stack.isEmpty()) {
					break;
				}
				// i为右边界,stack.peek()为左边界
				int curWeight = i - stack.peek() - 1;
				// 取左右边界的最小值 - 凹槽柱子的高度, 即为凹槽所能容纳的最大雨水高度
				int curHeight = Math.min(height[i], height[stack.peek()]) - height[curIdx];
				area += curHeight * curWeight;
			}
			stack.push(i);
		}

		return area;
	}
}
