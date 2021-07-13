package 单调栈;

import java.util.Stack;

/**
 * @ClassName: _402_移掉K位数字
 * @Author: whc
 * @Date: 2021/07/13/14:08
 */
public class _402_移掉K位数字 {

	/**
	 * 思路: 单调栈
	 * 单调递增(栈底到栈顶)
	 *
	 */
	public String removeKdigits(String num, int k) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < num.length(); i++) {
			while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}

			// 这里做特殊处理, 当前字符不是'0',或栈非空 则入栈, 避免首位字符为0
			if(!stack.isEmpty() || num.charAt(i) != '0') {
				stack.push(num.charAt(i));
			}
		}

		// 如果是一直单调递增,导致k还有剩余,则依次剔除栈中的元素(移除低位)
		while(k > 0 && !stack.isEmpty()) {
			stack.pop();
			k--;
		}

		return stack.isEmpty() ? "0" : stackToString(stack);
	}

	private String stackToString(Stack<Character> stack) {
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return res.reverse().toString();
	}
}
