package 剑指offer;

import java.util.Stack;

/**
 * @ClassName: _剑指_Offer_31_栈的压入_弹出序列
 * @Author: whc
 * @Date: 2021/05/28/14:10
 */
public class _剑指_Offer_31_栈的压入_弹出序列 {

	public static void main(String[] args) {
		validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
	}

	/**
	 *  思路: 用一个新栈实时模拟进出栈操作
	 *  1. for循环入栈pushed元素,每push一次就检查能不能pop出来
	 *  2. 如果最后栈为空,说明一进一出刚刚好
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for (int num : pushed) {
			stack.push(num);
			while(!stack.isEmpty() && stack.peek() == popped[index]) {
				stack.pop();
				index++;
			}
		}

		return stack.isEmpty();
	}
}
