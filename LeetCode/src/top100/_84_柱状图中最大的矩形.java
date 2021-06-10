package top100;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName: _84_柱状图中最大的矩形
 * @Author: whc
 * @Date: 2021/05/10/9:58
 */
public class _84_柱状图中最大的矩形 {

	/**
	 *  暴力解法:找出每一个高度对应的最大面积,选出最大的即可
	 *  时间: O(n^2) 超时
	 *  空间: O(n)
	 */
	/*public int largestRectangleArea(int[] heights) {
		Set<Integer> heightSet = new HashSet<>();
		// 得到所有高度,去重
		for (int height : heights) {
			heightSet.add(height);
		}

		int maxArea = 0;
		// 遍历每一个高度
		for (int h : heightSet) {
			int width = 0;
			int maxWidth = 1;
			for (int i = 0; i < heights.length; i++) {
				if(heights[i] >= h) {
					width++;
				} else {
					maxWidth = Math.max(maxWidth, width);
					width = 0;
				}
			}
			maxWidth = Math.max(maxWidth, width);
			maxArea = Math.max(maxArea, maxWidth * h);
		}

		return maxArea;
	}*/
	public static void main(String[] args) {
		largestRectangleArea(new int[]{1,2,5,7,6,4,3,7,5,4});
	}

	/**
	 *  思路: 单调栈栈
	 *	   - 如果当前栈空,或者当前柱子大于栈顶柱子的高度,就将当前柱子的下标入栈
	 *	   - 当前柱子的高度小于栈顶柱子的高度,那么就吧栈顶柱子出栈,作为要求面积的柱子(向左扩展,所形成的可能最大矩形)
	 *	     出栈的栈顶柱子右边第一个小于当前柱子的下标就是当前在遍历的柱子(right)
	 *	     出栈的栈顶柱子左边第一个小于当前柱子的下标就是当前新的栈顶(left)
	 *	   - 遍历结束后,如果栈没有空,就依次出栈 （依次出栈的元素作为每个要计算的高度）
	 *	   			left = stack.isEmpty() ? -1 : stack.peek();
	 *	   			right = heights.length;
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	public static int largestRectangleArea(int[] heights) {
		// 存储下标值
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int p = 0;
		while(p < heights.length) {
			if(stack.isEmpty()) {
				stack.push(p++);
			} else {
				// 保存栈高度
				int top = stack.peek();
				if(heights[p] >= heights[top]) {
					stack.push(p++);
				} else {
					int height = heights[stack.pop()];
					int left = stack.isEmpty() ? -1 : stack.peek();
					int right = p;
					maxArea = Math.max(maxArea, (right-left-1) * height);
				}

			}
		}

		// 栈还有剩余元素
		while(!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int left = stack.isEmpty() ? -1 : stack.peek();
			int right = heights.length;
			maxArea = Math.max(maxArea, (right-left-1) * height);
		}

		return maxArea;
	}


}
