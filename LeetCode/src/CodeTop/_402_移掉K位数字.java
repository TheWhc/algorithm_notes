package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _402_移掉K位数字
 * @Author: whc
 * @Date: 2021/08/19/16:06
 */
public class _402_移掉K位数字 {

	// 单调栈
	public String removeKdigits(String num, int k) {
		if(num.length() == k) {
			return "0";
		}

		Stack<Integer> stack = new Stack<>();
		// 返回结果的数字个数
		int resSize = num.length() - k;

		for (int i = 0; i < num.length(); i++) {

			while (!stack.isEmpty() && k > 0 && stack.peek() > (num.charAt(i)) - '0') {
				stack.pop();
				k--;
			}

			// 如果栈中大小与返回结果数字个数相等,那么此时不入栈,k--,
			if(stack.size() == resSize) {
				k--;
			} else {
				// 入栈
				stack.push((num.charAt(i) - '0'));
			}
		}

		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}
		res = res.reverse();

		int len = res.length();

		for (int i = 0; i < len; i++) {
			if(res.charAt(0) != '0') {
				break;
			} else {
				res.deleteCharAt(0);
			}
		}

		return res.length() == 0 ? "0" : res.toString();
	}

	public static void main(String[] args) {
		_402_移掉K位数字 _402_移掉K位数字 = new _402_移掉K位数字();
		System.out.println(_402_移掉K位数字.removeKdigits("12", 1));
	}
}
