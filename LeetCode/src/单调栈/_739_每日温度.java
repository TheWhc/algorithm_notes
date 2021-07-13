package 单调栈;

import java.util.Stack;

/**
 * @ClassName: _739_每日温度
 * @Author: whc
 * @Date: 2021/07/13/9:51
 */
public class _739_每日温度 {

	/**
	 * 思路: 单调栈
	 * 1. 逆序遍历温度数组, 保持栈为单调递增的栈
	 * 2. 如果栈为空,那么此时res[i] = 0, 如果栈不为空,则res[i] = stack.peek() - i, 再将当天温度的下标存储栈中
	 */
	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = T.length - 1; i >= 0; i--) {

			while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				res[i] = 0;
			} else {
				res[i] = stack.peek() - i;
			}
			stack.push(i);
		}

		return res;
	}

	public static void main(String[] args) {
		_739_每日温度 _739_每日温度 = new _739_每日温度();
		_739_每日温度.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
	}
}
