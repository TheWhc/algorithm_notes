package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _739_每日温度
 * @Author: whc
 * @Date: 2021/09/01/10:22
 */
public class _739_每日温度 {

	// 单调栈
	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = T.length-1; i >= 0; i--) {
			while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}
			res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return res;
	}
}
