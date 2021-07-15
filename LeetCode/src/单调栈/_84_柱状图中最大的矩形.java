package 单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: _84_柱状图中最大的矩形
 * @Author: whc
 * @Date: 2021/07/14/12:09
 */
public class _84_柱状图中最大的矩形 {

	/**
	 * 思路: 暴力解法
	 */
	/*public int largestRectangleArea(int[] heights) {
		int area = 0;

		for (int i = 0; i < heights.length; i++) {
			int left = i;
			int right = i;
			int height = heights[i];
			while(left > 0 && heights[left - 1] >= height) {
				left--;
			}

			while(right < heights.length - 1 && heights[right + 1] >= height) {
				right++;
			}

			area = Math.max(area, (right - left + 1) * height);
		}

		return area;
	}*/

	/**
	 * 思路: 单调栈 + 哨兵
	 *
	 * 哨兵是用来解决栈中的剩余元素
	 *
	 * 1. 栈中存储的是每个元素的下标, 若当前元素高度大于栈顶元素,则入栈(保持为单调递增栈)
	 * 2. 若当前元素高度小于栈顶元素,则出栈,当前元素的右边界为i,左边界为栈顶元素,所以以刚才出栈的元素作为高度curHeight = height[i],
	 * 宽度为 i - stack.peek() - 1
	 *
	 * 更新最大值的面积 = Math.max(curHeight * curWeight, area)
	 */
	public int largestRectangleArea(int[] heights) {
		if(heights.length == 0) {
			return 0;
		}
		if(heights.length == 1) {
			return heights[0];
		}
		int[] newHeight = new int[heights.length + 2];
		// 原数组,原数组起始位置,新数组,新数组起始位置,复制的长度
		System.arraycopy(heights, 0, newHeight, 1, heights.length);
		newHeight[0] = 0;
		newHeight[heights.length + 1] = 0;
		heights = newHeight;

		Stack<Integer> stack = new Stack<>();
		// 存储第一个哨兵节点,高度为0,下标为0
		stack.push(0);
		int area = 0;
		// i从1开始
		for (int i = 1; i < heights.length; i++) {
			while(heights[stack.peek()] > heights[i]) {
				int curHeight = heights[stack.pop()];
				// 左边界为stack.peek(), 右边界为i
				int curWeight = i - stack.peek() - 1;
				area = Math.max(curHeight * curWeight, area);
			}
			stack.push(i);
		}

		return area;
	}

}
