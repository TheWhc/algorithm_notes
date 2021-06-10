package top100;

import java.util.Stack;

/**
 * @ClassName: _85_最大矩形
 * @Author: whc
 * @Date: 2021/05/11/13:07
 */
public class _85_最大矩形 {

	public int maximalRectangle(char[][] matrix) {
		int res = 0;
		int[] heights = new int[matrix[0].length];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if(matrix[row][col] == '1') {
					heights[col] += 1;
				} else {
					heights[col] = 0;
				}
			}
			res = Math.max(res, largestRectangleArea(heights));
		}
		return res;
	}

	private int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int p = 0;
		int maxArea = 0;
		while(p < heights.length) {
			if(stack.isEmpty()) {
				stack.push(p++);
			} else {
				if(heights[stack.peek()] <= heights[p]) {
					stack.push(p++);
				} else {
					int height = heights[stack.pop()];
					int left = stack.isEmpty() ? -1 : stack.peek();
					int right = p;
					maxArea = Math.max(maxArea, (right-left-1) * height);
				}
			}
		}

		while(!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int left = stack.isEmpty() ? -1 : stack.peek();
			int right = heights.length;
			maxArea = Math.max(maxArea, (right-left-1) * height);
		}

		return maxArea;
	}
}
