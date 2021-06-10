package 栈与队列;

import java.util.Stack;

/**
 * @ClassName: _150_逆波兰表达式求值
 * @Author: whc
 * @Date: 2021/04/23/10:43
 */
public class _150_逆波兰表达式求值 {

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if(stack.isEmpty() || !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
				stack.push(Integer.valueOf(token));
			} else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				if(token.equals("+")) {
					stack.push(num1 + num2);
				} else if(token.equals("-")) {
					stack.push(num2 - num1);
				} else if (token.equals("*")) {
					stack.push(num2 * num1);
				} else {
					stack.push(num2 / num1);
				}
			}
		}

		return stack.pop();
	}
}
