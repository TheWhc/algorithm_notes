package 待分类;

import java.util.Stack;

/**
 * @ClassName: 待分类._42_接雨水
 * @Author: whc
 * @Date: 2021/03/17/22:16
 */
public class _42_接雨水 {

	// 双指针法 时间复杂度O(n^2)
	/*public int trap(int[] height) {
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			// 第一个柱子和最后一个柱子不接雨水
			if(i == 0 || i == height.length - 1)
				continue;
			int rightHeight = height[i]; // 记录右边柱子最高高度
			int leftHeight = height[i]; // 记录左边柱子最高高度
			for (int r = i+1; r < height.length; r++) {
				if(height[r] > rightHeight) {
					rightHeight = height[r];
				}
			}

			for (int l = i-1; l >= 0; l--) {
				if(height[l] > leftHeight) {
					leftHeight = height[l];
				}
			}
			// 左右柱子中选择最小的柱子 再减去 柱子本身高度 即雨水的高度
			int h = Math.min(leftHeight, rightHeight) - height[i];
			if(h > 0)
				sum += h;
		}
		return sum;
	}*/

	// 动态规划
	// 避免左右柱子最高高度重复计算
	// 递推公示:
	// 从左往右: maxLeft[i] = max(height[i], maxLeft[i-1])
	// 从右往左: maxRight[i] = max(height[i], maxRight[i+1])
	/*public int trap(int[] height) {
		if(height.length <= 2)
			return 0;
		int[] maxLeft = new int[height.length];
		int[] maxRight = new int[height.length];

		// 记录每个柱子左边柱子最大高度
		maxLeft[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
		}

		// 记录每个柱子右边柱子最大高度
		maxRight[height.length-1] = height[height.length-1];
		for (int i = height.length-2; i >= 0; i--) {
			maxRight[i] = Math.max(height[i], maxRight[i+1]);
		}

		// 求和
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
			if(count > 0) {
				sum += count;
			}
		}

		return sum;
	}*/


	// 单调栈
	public int trap(int[] height) {
		if(height.length <= 2) return 0;
		Stack<Integer> stack = new Stack<>(); // 存着下标,计算的时候可以用下标对应柱子的高度
		stack.push(0);
		int sum = 0;
		for (int i = 1; i < height.length; i++) {
			// 情况一: 当前遍历的元素（柱子）高度小于栈顶元素的高度
			if(height[i] < height[stack.peek()]) {
				stack.push(i);
			}
			// 情况二: 当前遍历的元素（柱子）高度等于栈顶元素的高度
			else if(height[i] == height[stack.peek()]) {
				stack.pop();
				stack.push(i);
			} else {
				// 情况三: 当前遍历的元素（柱子）高度大于栈顶元素的高度,出现凹槽
				while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
					int mid = stack.pop();
					if(!stack.isEmpty()) {
						int h = Math.min(height[i], height[stack.peek()]) - height[mid]; // 求高度
						int w = i - stack.peek() - 1; // 求宽度
						sum += h * w;
					}
				}
				stack.push(i);
			}
		}

		return sum;
	}
}
