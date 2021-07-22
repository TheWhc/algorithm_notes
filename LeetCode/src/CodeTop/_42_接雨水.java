package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _42_接雨水
 * @Author: whc
 * @Date: 2021/07/22/9:44
 */
public class _42_接雨水 {

	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int area = 0;

		for (int i = 0; i < height.length; i++) {
			while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
				int curIdx = stack.pop();
				if(stack.isEmpty()) {
					break;
				}
				int curWeight = i - stack.peek() - 1;
				int curHeight = Math.min(height[i], height[stack.peek()]) - height[curIdx];
				area += curWeight * curHeight;
			}

			stack.push(i);
		}

		return area;
	}
}
