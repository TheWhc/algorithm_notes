package 栈与队列.计算器系列;

import java.util.Stack;

/**
 * @ClassName: _150_逆波兰表达式求值
 * @Author: whc
 * @Date: 2021/04/23/10:43
 */
public class _150_逆波兰表达式求值 {

	/**
	 * 思路: 栈
	 */

	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();

		for(String token : tokens) {
			if(!(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
				stack.push(token);
			} else {
				int num1 = Integer.valueOf(stack.pop());
				int num2 = Integer.valueOf(stack.pop());
				if(token.equals("+")) {
					stack.push(String.valueOf(num1 + num2));
				} else if(token.equals("-")) {
					stack.push(String.valueOf(num2 - num1));
				} else if(token.equals("*")) {
					stack.push(String.valueOf(num1 * num2));
				} else {
					stack.push(String.valueOf(num2 / num1));
				}
			}
		}

		return Integer.valueOf(stack.pop());
	}
}
